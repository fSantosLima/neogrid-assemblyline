package br.com.neogrid.assemblyline.enums;

public enum AssemblyLineStepType {
    MAINTENANCE_STEP("maintenance"),

    LUNCH_STEP("almoço"),

    GYM_LABORAL_STEP(
            "ginástica"),

    NORMAL_STEP("normal");

    private String stepTypeDescription;

    AssemblyLineStepType(String stepTypeDescription) {
        this.stepTypeDescription = stepTypeDescription;
    }

    public String getStepTypeDescription() {
        return stepTypeDescription;
    }
}
