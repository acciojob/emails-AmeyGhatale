package com.driver;

import java.util.Date;

public class Mail {
    private Date date;
    private String sender;
    private String messsage;

    public Mail(Date date, String sender, String messsage) {
        this.date = date;
        this.sender = sender;
        this.messsage = messsage;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMesssage() {
        return messsage;
    }

    public void setMesssage(String messsage) {
        this.messsage = messsage;
    }
}
