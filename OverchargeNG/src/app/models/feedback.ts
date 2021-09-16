import { User } from 'src/app/models/user';

export class Feedback {
    id: number;
    content: string;
    //creator: User;
    createdOn: number;

    constructor(id: number, content: string, createdOn: number){
        this.id = id;
        this.content = content;
        this.createdOn = createdOn;
    }
}

