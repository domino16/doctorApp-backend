package pl.Dominik.ChatApp.chats;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "chats")
public class Chat {
    @Id
    @GeneratedValue
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    private LastMessage lastMessage;

    private boolean lastMessageUnread;
    @ManyToOne(cascade = CascadeType.ALL)
   private ChatUsers firstChatUser ;


    @ManyToOne(cascade = CascadeType.ALL)
    private ChatUsers secondChatUser ;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Message> messages = new ArrayList<Message>();





    public Chat() {
    }

    public Chat(LastMessage lastMessage, boolean lastMessageUnread, ChatUsers firstChatUser, ChatUsers secondChatUser, List<Message> messages) {
        this.lastMessage = lastMessage;
        this.lastMessageUnread = lastMessageUnread;
        this.firstChatUser = firstChatUser;
        this.secondChatUser = secondChatUser;
        this.messages = messages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LastMessage getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(LastMessage lastMessage) {
        this.lastMessage = lastMessage;
    }

    public boolean isLastMessageUnread() {
        return lastMessageUnread;
    }

    public void setLastMessageUnread(boolean lastMessageUnread) {
        this.lastMessageUnread = lastMessageUnread;
    }

    public ChatUsers getFirstChatUser() {
        return firstChatUser;
    }

    public void setFirstChatUser(ChatUsers firstChatUser) {
        this.firstChatUser = firstChatUser;
    }

    public ChatUsers getSecondChatUser() {
        return secondChatUser;
    }

    public void setSecondChatUser(ChatUsers secondChatUser) {
        this.secondChatUser = secondChatUser;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
