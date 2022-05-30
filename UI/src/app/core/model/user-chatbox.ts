import { Chatbox } from "./chatbox"
import { User } from "./user"

export class UserChatbox {
    id : number = 0;
    last_update : string = '';
    chatbox : Chatbox = new Chatbox();
    user : User = new User();
}
