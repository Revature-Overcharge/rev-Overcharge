package com.revature.overcharge.beans;

public class Objective {

    private String name;

    private int pointsToAward;

    private int progressPercent;

    private int countForGoal;

    public Objective() {
        super();
    }

    public Objective(String name, int pointsToAward, int progressPercent,
            int countForGoal) {
        super();
        this.name = name;
        this.pointsToAward = pointsToAward;
        this.progressPercent = progressPercent;
        this.countForGoal = countForGoal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPointsToAward() {
        return pointsToAward;
    }

    public void setPointsToAward(int pointsToAward) {
        this.pointsToAward = pointsToAward;
    }

    public int getprogressPercent() {
        return progressPercent;
    }

    public void setprogressPercent(int progressPercent) {
        this.progressPercent = progressPercent;
    }

    public int getCountForGoal() {
        return countForGoal;
    }

    public void setCountForGoal(int countForGoal) {
        this.countForGoal = countForGoal;
    }

    @Override
    public String toString() {
        return "Objective [name=" + name + ", pointsToAward=" + pointsToAward
                + ", progressPercent=" + progressPercent + ", countForGoal="
                + countForGoal + "]";
    }

}
