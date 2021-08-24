export class User {
    id: number;
    username: string;
    password: string;
    objective_points: number;
    last_login_on: number;
   
<<<<<<< HEAD
    constructor(username: string, password: string, id?: number, objective_points?: number, last_login_on?: number){
=======
  
   
    constructor(id: number,username: string, password: string,  objective_points: number, last_login_on: number){
>>>>>>> 4a9d3b5aa71482545e54b02a461cbdedf0a49dcd
        this.id = id || -1;
        this.username = username;
        this.password  = password;
        this.objective_points = objective_points || 0;
        this.last_login_on = last_login_on || 0;
       
    }
}
