export class Objective {
    name: string;
    pointsToAward: number;
    countForGoal: number;
    progressPercent: number;
   
  
   
    constructor(name: string, pointsToAward: number, countForGoal: number, progressPercent: number){
        this.name = name;
        this.pointsToAward = pointsToAward;
        this.countForGoal  = countForGoal;
        this.progressPercent = progressPercent;
       
    }
}