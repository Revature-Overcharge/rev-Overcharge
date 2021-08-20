
export class User {

    id: number;
    username: string;
    password: string;
    points: number;
    lastLogin: number;
    // createdDecks: Deck[];
    // studiedCards: StudiedCard[];
    // ratings: Rating[];

    constructor(id: number, username: string, password: string, points: number, lastLogin: number){
        this.id = id;
        this.username = username;
        this.password = password;
        this.points = points;
        this.lastLogin = lastLogin;
    }

}

