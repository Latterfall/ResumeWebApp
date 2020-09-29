package model;

import javax.persistence.*;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "message_subject", nullable = false)
    @Enumerated(value = EnumType.ORDINAL)
    private MessageSubject messageSubject;

    @Column(name = "messenger_name", nullable = false, length = 31)
    private String messengerName;

    @Column(name = "messenger_lastname", nullable = false, length = 31)
    private String messengerLastname;

    @Column(name = "messenger_email", nullable = false, length = 63)
    private String messengerEmail;

    @Column(name = "messenger_company", nullable = false, length = 63)
    private String messengerCompany;

    @Column(name = "message_text", length = 4095, nullable = false)
    private String messageText;

    @Column(name = "isViewed", nullable = false)
    private boolean isViewed;

    public Message() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public MessageSubject getMessageSubject() {
        return messageSubject;
    }

    public void setMessage_subject(MessageSubject messageSubject) {
        this.messageSubject = messageSubject;
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

    public String getMessengerCompany() {
        return messengerCompany;
    }

    public void setMessengerCompany(String messengerCompany) {
        this.messengerCompany = messengerCompany;
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
