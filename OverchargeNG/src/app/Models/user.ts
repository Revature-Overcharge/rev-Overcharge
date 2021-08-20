export class user {
  user_id: number;
  username: string;
  password: string;
  objective_points: number;
  last_login_on: number;
 

 
   constructor(user_id: number, username: string, password: string, objective_points: number,last_login_on: number){
     this.user_id = user_id;
     this.username = username;
     this.password  = password;
     this.objective_points = objective_points;
     this.last_login_on = last_login_on;
     
     
   }
 }