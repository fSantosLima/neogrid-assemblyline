package br.com.neogrid.assemblyline.to;

import br.com.neogrid.assemblyline.enums.AssemblyLineStepType;

import java.time.LocalTime;

public class AssemblyLineProcessStepTO {
    private LocalTime time;
    private int stepDuration;
    private String stepDescription;
    private AssemblyLineStepType assemblyLineStepType;

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public int getStepDuration() {
        return stepDuration;
    }

    public void setStepDuration(int stepDuration) {
        this.stepDuration = stepDuration;
    }

    public String getStepDescription() {
        return stepDescription;
    }

    public void setStepDescription(String stepDescription) {
        this.stepDescription = stepDescription;
    }

    public AssemblyLineStepType getAssemblyLineStepType() {
        return assemblyLineStepType;
    }

    public void setAssemblyLineStepType(AssemblyLineStepType assemblyLineStepType) {
        this.assemblyLineStepType = assemblyLineStepType;
    }

    @Override
    public String toString() {
        return
                time + " "
                + stepDescription + " "
                + (AssemblyLineStepType.NORMAL_STEP.equals(assemblyLineStepType) ? stepDuration + " mins" : "").trim();
    }
}
