import { Chatbox } from "./chatbox";
import { User } from "./user";

export class Message {
    id : number = 0;
    content : string = '';
    createdDate : string = '';
    chatbox : Chatbox = new Chatbox();
    user : User = new User();
}
