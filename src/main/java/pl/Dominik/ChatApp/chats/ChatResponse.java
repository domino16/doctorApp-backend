package pl.Dominik.ChatApp.chats;

import pl.Dominik.ChatApp.user.User;

import java.util.ArrayList;
import java.util.List;

public class ChatResponse {
    private int id;
    private ArrayList<String> userIDs = new ArrayList<>();
    private ArrayList<ChatUsers> users= new ArrayList<>();
    private boolean lastMessageUnread;
    private LastMessage lastMessage;

    public ChatResponse() {
    }

    public ChatResponse(int id, ArrayList<String> userIDs, ArrayList<ChatUsers> users, boolean lastMessageUnread, LastMessage lastMessage) {
        this.id = id;
        this.userIDs = userIDs;
        this.users = users;
        this.lastMessageUnread = lastMessageUnread;
        this.lastMessage = lastMessage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<String> getUserIDs() {
        return userIDs;
    }

    public void setUserIDs(ArrayList<String> userIDs) {
        this.userIDs = userIDs;
    }

    public ArrayList<ChatUsers> getUsers() {
        return users;
    }

    public void setUser(ArrayList<ChatUsers> users) {
        this.users = users;
    }

    public boolean isLastMessageUnread() {
        return lastMessageUnread;
    }

    public void setLatMessageUnread(boolean lastMessageUnread) {
        this.lastMessageUnread = lastMessageUnread;
    }

    public void setUsers(ArrayList<ChatUsers> users) {
        this.users = users;
    }

    public void setLastMessageUnread(boolean lastMessageUnread) {
        this.lastMessageUnread = lastMessageUnread;
    }

    public LastMessage getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(LastMessage lastMessage) {
        this.lastMessage = lastMessage;
    }
}
