export class Objective {
    name: string;
    pointsToAward: number;
    countForGoal: number;
    progressCount: number;
   
  
   
    constructor(name: string, pointsToAward: number, countForGoal: number, progressCount: number){
        this.name = name;
        this.pointsToAward = pointsToAward;
        this.countForGoal  = countForGoal;
        this.progressCount = progressCount;
       
    }
}