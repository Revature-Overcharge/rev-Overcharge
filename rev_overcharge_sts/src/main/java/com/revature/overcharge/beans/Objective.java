package com.revature.overcharge.beans;

public class Objective {

    private String name;

    private int pointsToAward;

    private int progressCount;

    private int countForGoal;

    public Objective() {
        super();
    }

    public Objective(String name, int pointsToAward, int progressCount,
            int countForGoal) {
        super();
        this.name = name;
        this.pointsToAward = pointsToAward;
        this.progressCount = progressCount;
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

    public int getProgressCount() {
        return progressCount;
    }

    public void setProgressCount(int progressCount) {
        this.progressCount = progressCount;
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
                + ", progressCount=" + progressCount + ", countForGoal="
                + countForGoal + "]";
    }

}
