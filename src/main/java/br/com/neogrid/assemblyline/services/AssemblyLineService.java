package br.com.neogrid.assemblyline.services;

import br.com.neogrid.assemblyline.enums.AssemblyLineStepType;
import br.com.neogrid.assemblyline.to.AssemblyLineProcessStepTO;
import br.com.neogrid.assemblyline.to.AssemblyLineTO;
import br.com.neogrid.assemblyline.utils.DateUtils;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class AssemblyLineService {

    private static final LocalTime LUNCH_HOUR = LocalTime.parse("12:00");
    private static final LocalTime MIN_HOUR_LABORAL_GYM = LocalTime.parse("16:00");
    private static final LocalTime MAX_HOUR_LABORAL_GYM = LocalTime.parse("17:00");
    private List<AssemblyLineProcessStepTO> steps = new ArrayList<>();
    private AssemblyLineProcessStepTO lineProcessAssemblyTO = new AssemblyLineProcessStepTO();

    public List<AssemblyLineTO> getAssemblyLinesOrdinate(List<AssemblyLineProcessStepTO> assemblyLineProcessStepTOList) {
        LocalTime stepHour = LocalTime.parse("09:00");
        List<AssemblyLineTO> assemblyLineTOList = new ArrayList<>();
        AssemblyLineTO assemblyLines = new AssemblyLineTO();

        while (!assemblyLineProcessStepTOList.isEmpty()) {
            lineProcessAssemblyTO = new AssemblyLineProcessStepTO();
            Optional<AssemblyLineProcessStepTO> assemblyLineProcessStepTO;
            if (isTimeToGym(stepHour)) {
                stepHour = doStepGym(stepHour, assemblyLineTOList, assemblyLines);
                assemblyLines = new AssemblyLineTO();
            }

            long minutesToLunch = DateUtils.getMinutesUntil(stepHour, LUNCH_HOUR);
            if (minutesToLunch != 0) {
                assemblyLineProcessStepTO = getStepByMinutesToLunch(assemblyLineProcessStepTOList, minutesToLunch);
            } else {
                stepHour = doStepLunch(stepHour);
                assemblyLineProcessStepTO = getAssemblyLineProcessStepTO(assemblyLineProcessStepTOList);
            }

            stepHour = doNormalStep(stepHour, assemblyLineProcessStepTO);
            assemblyLineProcessStepTOList.remove(assemblyLineProcessStepTO.get());
        }
        return assemblyLineTOList;
    }

    private LocalTime doNormalStep(LocalTime stepHour, Optional<AssemblyLineProcessStepTO> assemblyLineProcessStepTO) {
        lineProcessAssemblyTO.setTime(stepHour);
        lineProcessAssemblyTO.setStepDuration(assemblyLineProcessStepTO.get().getStepDuration());
        lineProcessAssemblyTO.setStepDescription(assemblyLineProcessStepTO.get().getStepDescription());
        lineProcessAssemblyTO.setAssemblyLineStepType(AssemblyLineStepType.NORMAL_STEP);
        steps.add(lineProcessAssemblyTO);

        stepHour = stepHour.plusMinutes(assemblyLineProcessStepTO.get().getStepDuration());
        return stepHour;
    }

    private LocalTime doStepLunch(LocalTime stepHour) {
        lineProcessAssemblyTO.setStepDuration(60);
        lineProcessAssemblyTO.setTime(LUNCH_HOUR);
        lineProcessAssemblyTO.setStepDescription("Almoço");
        lineProcessAssemblyTO.setAssemblyLineStepType(AssemblyLineStepType.LUNCH_STEP);
        steps.add(lineProcessAssemblyTO);

        lineProcessAssemblyTO = new AssemblyLineProcessStepTO();
        stepHour = stepHour.plusMinutes(60);
        return stepHour;
    }

    private LocalTime doStepGym(LocalTime stepHour, List<AssemblyLineTO> assemblyLineTOList, AssemblyLineTO assemblyLines) {
        lineProcessAssemblyTO.setTime(stepHour);
        lineProcessAssemblyTO.setStepDescription("Ginástica laboral");
        lineProcessAssemblyTO.setAssemblyLineStepType(AssemblyLineStepType.GYM_LABORAL_STEP);

        steps.add(lineProcessAssemblyTO);
        assemblyLines.setAssemblySteps(steps);
        assemblyLineTOList.add(assemblyLines);

        stepHour = LocalTime.parse("09:00");
        steps = new ArrayList<>();
        lineProcessAssemblyTO = new AssemblyLineProcessStepTO();
        return stepHour;
    }

    private static Optional<AssemblyLineProcessStepTO> getStepByMinutesToLunch(List<AssemblyLineProcessStepTO> assemblyLineProcessStepTOList, long minutesToLunch) {
        Optional<AssemblyLineProcessStepTO> assemblyLineProcessStepTO;
        assemblyLineProcessStepTO = assemblyLineProcessStepTOList.stream()
                .filter(step -> step.getStepDuration() == minutesToLunch)
                .findFirst();

        if (!assemblyLineProcessStepTO.isPresent()) {
            assemblyLineProcessStepTO = getAssemblyLineProcessStepTO(assemblyLineProcessStepTOList);
        }
        return assemblyLineProcessStepTO;
    }

    private static boolean isTimeToGym(LocalTime stepHour) {
        return (stepHour.isAfter(MIN_HOUR_LABORAL_GYM) && stepHour.isBefore(MAX_HOUR_LABORAL_GYM)) ||
                stepHour.equals(MAX_HOUR_LABORAL_GYM) ;
    }

    private static Optional<AssemblyLineProcessStepTO> getAssemblyLineProcessStepTO(List<AssemblyLineProcessStepTO> assemblyLineProcessStepTOList) {
        return assemblyLineProcessStepTOList.stream()
                .max(Comparator.comparing(AssemblyLineProcessStepTO::getStepDuration));
    }
}
