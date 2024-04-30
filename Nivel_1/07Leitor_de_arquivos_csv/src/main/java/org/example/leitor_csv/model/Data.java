package org.example.leitor_csv.model;

public class Data {
    private int index;
    private String childIQScore;
    private String motherEducation;
    private String motherIQ;
    private String motherJob;
    private String motherAge;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getChildIQScore() {
        return childIQScore;
    }

    public void setChildIQScore(String childIQScore) {
        this.childIQScore = childIQScore;
    }

    public String getMotherEducation() {
        return motherEducation;
    }

    public void setMotherEducation(String motherEducation) {
        this.motherEducation = motherEducation;
    }

    public String getMotherIQ() {
        return motherIQ;
    }

    public void setMotherIQ(String motherIQ) {
        this.motherIQ = motherIQ;
    }

    public String getMotherJob() {
        return motherJob;
    }

    public void setMotherJob(String motherJob) {
        this.motherJob = motherJob;
    }

    public String getMotherAge() {
        return motherAge;
    }

    public void setMotherAge(String motherAge) {
        this.motherAge = motherAge;
    }

    @Override
    public String toString() {
        return "Dados: {" +
                "index = " + index +
                "| childIQScore = '" + childIQScore + '\'' +
                "| motherEducation = '" + motherEducation + '\'' +
                "| motherIQ = '" + motherIQ + '\'' +
                "| motherJob = '" + motherJob + '\'' +
                "| motherAge = '" + motherAge + '\'' +
                '}';
    }
}
