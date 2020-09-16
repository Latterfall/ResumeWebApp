package model;

import javax.persistence.*;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "messenger_name")
    private String messengerName;

    @Column(name = "messenger_lastname")
    private String messengerLastname;

    @Column(name = "messenger_email")
    private String messengerEmail;

    @Column(name = "message_header")
    private String messageHeader;

    @Column(name = "message_subject")
    @Enumerated(value = EnumType.ORDINAL)
    private MessageSubject messageSubject;

    @Column(name = "message_text")
    private String messageText;

    @Column(name = "isViewed")
    private boolean isViewed;

    public Message() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessengerName() {
        return messengerName;
    }

    public void setMessengerName(String messengerName) {
        this.messengerName = messengerName;
    }

    public String getMessengerLastname() {
        return messengerLastname;
    }

    public void setMessengerLastname(String messengerLastname) {
        this.messengerLastname = messengerLastname;
    }

    public String getMessengerEmail() {
        return messengerEmail;
    }

    public void setMessengerEmail(String messengerEmail) {
        this.messengerEmail = messengerEmail;
    }

    public String getMessageHeader() {
        return messageHeader;
    }

    public void setMessageHeader(String messageHeader) {
        this.messageHeader = messageHeader;
    }

    public MessageSubject getMessageSubject() {
        return messageSubject;
    }

    public void setMessage_subject(MessageSubject messageSubject) {
        this.messageSubject = messageSubject;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public boolean isViewed() {
        return isViewed;
    }

    public void setViewed(boolean viewed) {
        isViewed = viewed;
    }
}
