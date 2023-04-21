package br.com.neogrid.assemblyline.controllers;

import br.com.neogrid.assemblyline.filereaders.AssemblyLineFileReaderImpl;
import br.com.neogrid.assemblyline.services.AssemblyLineService;
import br.com.neogrid.assemblyline.to.AssemblyLineProcessStepTO;
import br.com.neogrid.assemblyline.to.AssemblyLineTO;

import java.util.List;

public class AssemblyLineController {

    private final AssemblyLineFileReaderImpl assemblyLineFileReaderTxt;
    private final AssemblyLineService assemblyLineService;

    public AssemblyLineController() {
        this.assemblyLineService = new AssemblyLineService();
        this.assemblyLineFileReaderTxt = new AssemblyLineFileReaderImpl();
    }

    public void readInputFile(String fileName) {
        List<AssemblyLineProcessStepTO> assemblyLineProcessStepTOList = this.readFile(fileName);

        if(assemblyLineProcessStepTOList.isEmpty()) {
            System.err.println("File returned 0 lines");
        }

        List<AssemblyLineTO> assemblyLineTOList = this.getAssemblyLines(assemblyLineProcessStepTOList);

        int index = 0;
        for (AssemblyLineTO assemblyLineTO : assemblyLineTOList) {
            index++;
            System.out.println("Linha de montagem " + index + ":");
            assemblyLineTO
                    .getAssemblySteps()
                    .forEach(step -> System.out.println(step.toString()));
            System.out.println();
        }
    }
    private List<AssemblyLineProcessStepTO> readFile(String pathFile) {
        return assemblyLineFileReaderTxt.readLinesFromFile(pathFile);
    }

    private List<AssemblyLineTO> getAssemblyLines( List<AssemblyLineProcessStepTO> assemblyLineProcessStepTOList) {
        return assemblyLineService.getAssemblyLinesOrdinate(assemblyLineProcessStepTOList);
    }
}
