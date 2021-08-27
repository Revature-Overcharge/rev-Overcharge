export class Objective {
    name: string;
    pointsToAward: number;
    progressPercent: number;
    progressCount: number;
   
  
   
    constructor(name: string, pointsToAward: number, countForGoal: number, progressCount: number){
        this.name = name;
        this.pointsToAward = pointsToAward;
        this.progressPercent  = countForGoal;
        this.progressCount = progressCount;
       
    }
}