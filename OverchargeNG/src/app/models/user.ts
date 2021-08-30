import { ObjectivesComponent } from "../components/objectives/objectives.component";
import { Objective } from "./objective";

export class User {
    id: number;
    username: string;
    password: string;
    points: number;
    lastLogin: number;
    objectives: Objective[];



    constructor(id: number, username: string, password: string, points: number, lastLogin: number) {
        this.id = id || -1;
        this.username = username;
        this.password = password;
        this.points = points || 0;
        this.lastLogin = lastLogin || 0;

    }
}
