// import { User } from 'src/app/models/user';

export class Feedback {
    id: number;
    content: string;
    //creator: User;
    createdOn: number;
  static id: number;

    constructor(content: string){
        this.content = content;
    }
}

