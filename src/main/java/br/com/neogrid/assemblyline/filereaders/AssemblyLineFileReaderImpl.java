package br.com.neogrid.assemblyline.filereaders;

import br.com.neogrid.assemblyline.enums.AssemblyLineStepType;
import br.com.neogrid.assemblyline.interfaces.AssemblyLineFileReader;
import br.com.neogrid.assemblyline.to.AssemblyLineProcessStepTO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AssemblyLineFileReaderImpl implements AssemblyLineFileReader {

    private static final int MAINTENANCE_STEP_DURATION = 5;
    private static final String MINUTES_UNIT = " min";
    private static final String STEP_DURATION_REGEX = "[^?0-9]+";
    private static final String STEP_DESCRIPTION_REGEX = "[0-9]+";

    @Override
    public List<AssemblyLineProcessStepTO> readLinesFromFile(String pathFile) {
        try {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(Files.newInputStream(Paths.get(pathFile))))) {
                return getStepsFromFile(reader.lines());
            }
        } catch (IOException exception) {
            System.err.println(String.format("Failed to read a file %s", exception.getCause()));
        }
        return Collections.emptyList();
    }


    private List<AssemblyLineProcessStepTO> getStepsFromFile(Stream<String> lines) {
        return lines.map(this::processStep).collect(Collectors.toList());
    }


    private AssemblyLineProcessStepTO processStep(String line) {
        AssemblyLineProcessStepTO step = new AssemblyLineProcessStepTO();
        String stepMinutes = line.replaceAll(STEP_DURATION_REGEX, "");
        String stepDescription = line.replaceAll(STEP_DESCRIPTION_REGEX, "").replace(MINUTES_UNIT, "").trim();
        step.setStepDescription(stepDescription);
        step.setStepDuration(line.contains(AssemblyLineStepType.MAINTENANCE_STEP.getStepTypeDescription())
                ? MAINTENANCE_STEP_DURATION
                : Integer.parseInt(stepMinutes));
        return step;
    }
}
