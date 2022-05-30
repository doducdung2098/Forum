import { User } from "./user";

export class Question {
    id : number = 0;
    title : string ='';
    content : string ='';
    created_date : string = '';
    img : string = '';
    status : number = 0;
    user : User = new User;
}
