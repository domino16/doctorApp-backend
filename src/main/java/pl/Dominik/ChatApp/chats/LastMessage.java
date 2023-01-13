package pl.Dominik.ChatApp.chats;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.util.Date;

@Entity
public class LastMessage {
    @Id
    @GeneratedValue
    private int id;
    private String lastMessage;
    private String lastMessageAuthor;
    private Date lastMessageDate;

    public LastMessage() {
    }

    public LastMessage(String lastMessage, String lastMessageAuthor, Date lastMessageDate) {
        this.lastMessage = lastMessage;
        this.lastMessageAuthor = lastMessageAuthor;
        this.lastMessageDate = lastMessageDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public String getLastMessageAuthor() {
        return lastMessageAuthor;
    }

    public void setLastMessageAuthor(String lastMessageAuthor) {
        this.lastMessageAuthor = lastMessageAuthor;
    }

    public Date getLastMessageDate() {
        return lastMessageDate;
    }

    public void setLastMessageDate(Date lastMessageDate) {
        this.lastMessageDate = lastMessageDate;
    }
}