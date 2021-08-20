export class User {
    user_id: number;
    username: string;
    password: string;
    objective_points: number;
    last_login_on: number;
   
  
   
    constructor(username: string, password: string, user_id?: number, objective_points?: number, last_login_on?: number){
        this.user_id = user_id || -1;
        this.username = username;
        this.password  = password;
        this.objective_points = objective_points || 0;
        this.last_login_on = last_login_on || 0;
       
    }
}