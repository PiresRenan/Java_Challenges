package org.example.leitor_csv.model;

public class Data {
    private int index;
    private int childIQScore;
    private int motherEducation;
    private int motherIQ;
    private String motherJob;
    private int motherAge;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getChildIQScore() {
        return childIQScore;
    }

    public void setChildIQScore(int childIQScore) {
        this.childIQScore = childIQScore;
    }

    public int getMotherEducation() {
        return motherEducation;
    }

    public void setMotherEducation(int motherEducation) {
        this.motherEducation = motherEducation;
    }

    public int getMotherIQ() {
        return motherIQ;
    }

    public void setMotherIQ(int motherIQ) {
        this.motherIQ = motherIQ;
    }

    public String getMotherJob() {
        return motherJob;
    }

    public void setMotherJob(String motherJob) {
        this.motherJob = motherJob;
    }

    public int getMotherAge() {
        return motherAge;
    }

    public void setMotherAge(int motherAge) {
        this.motherAge = motherAge;
    }
}
