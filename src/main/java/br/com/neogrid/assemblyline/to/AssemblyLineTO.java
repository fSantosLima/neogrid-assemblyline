package br.com.neogrid.assemblyline.to;

import java.util.List;

public class AssemblyLineTO {
    private int indexAssemblyLine;

    private List<AssemblyLineProcessStepTO> assemblySteps;

    public int getIndexAssemblyLine() {
        return indexAssemblyLine;
    }

    public void setIndexAssemblyLine(int indexAssemblyLine) {
        this.indexAssemblyLine = indexAssemblyLine;
    }

    public List<AssemblyLineProcessStepTO> getAssemblySteps() {
        return assemblySteps;
    }

    public void setAssemblySteps(List<AssemblyLineProcessStepTO> assemblySteps) {
        this.assemblySteps = assemblySteps;
    }
}
