package com.monitorelectricitybill.model;

public class Data {
    String name;
    String description;
    double power;
    int usesHour;
    int usesMinutes;
    int vectorId;

    public Data(String name, String description, double power, int usesHour, int usesMinutes, int vectorId, int usePerDuration) {
        this.name = name;
        this.description = description;
        this.power = power;
        this.usesHour = usesHour;
        this.usesMinutes = usesMinutes;
        this.vectorId = vectorId;
        this.usePerDuration = usePerDuration;
    }

    int usePerDuration;

    public Data(String name, String description, double power, int usesHour, int usesMinutes) {
        this.name = name;
        this.description = description;
        this.power = power;
        this.usesHour = usesHour;
        this.usesMinutes = usesMinutes;
    }

    public Data(String name, String description, double power, int usesHour, int usesMinutes, int vectorId) {
        this.name = name;
        this.description = description;
        this.power = power;
        this.usesHour = usesHour;
        this.usesMinutes = usesMinutes;
        this.vectorId = vectorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public int getUsesHour() {
        return usesHour;
    }

    public void setUsesHour(int usesHour) {
        this.usesHour = usesHour;
    }

    public int getUsesMinutes() {
        return usesMinutes;
    }

    public void setUsesMinutes(int usesMinutes) {
        this.usesMinutes = usesMinutes;
    }

    public int getVectorId() {
        return vectorId;
    }

    public void setVectorId(int vectorId) {
        this.vectorId = vectorId;
    }

    public int getUsePerDuration() {
        return usePerDuration;
    }

    public void setUsePerDuration(int usePerDuration) {
        this.usePerDuration = usePerDuration;
    }
}
