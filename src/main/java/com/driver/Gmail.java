package com.driver;

import java.util.*;

public class Gmail extends Email {

    int inboxCapacity; //maximum number of mails inbox can store
    Date date;
    String sender;
    String message;
    Gmail gmail;
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
    private Deque<Mail> Inbox;
    private Deque<Mail> Trash;

    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity = inboxCapacity;
        Inbox = new LinkedList<>();
        Trash = new LinkedList<>();
    }

    public void receiveMail(Date date, String sender, String message){
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.
        Mail mail = new Mail(date, sender, message);

        if (inboxCapacity==0) {
            Trash.add(Inbox.removeLast());
            inboxCapacity++;
        }

            Inbox.addFirst(mail);
            inboxCapacity--;
    }

    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing
        Stack<Mail> store = new Stack<>();

        while(!Inbox.isEmpty()){
            Mail mail = Inbox.pop();
            if(mail.getMesssage().equals(message))
                continue;
           store.push(mail);
        }

        while(!store.isEmpty())
            Inbox.addFirst(store.pop());
    }

    public String findLatestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox
        if(Inbox.isEmpty())
            return null;

        Mail mail = Inbox.getFirst();
        return mail.getMesssage();
    }

    public String findOldestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox
        if (Inbox.isEmpty())
            return null;

        Mail mail = Inbox.getLast();
        return mail.getMesssage();
    }

    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date

        int count = 0;
        for(Mail mail : Inbox){
            int stValue = start.compareTo(mail.getDate());
            int endValue = end.compareTo(mail.getDate());

            if(stValue<=0 && endValue>=0)
                count++;
        }
        return count;
    }

    public int getInboxSize(){
        // Return number of mails in inbox
        return Inbox.size();
    }

    public int getTrashSize(){
        // Return number of mails in Trash
        return Trash.size();
    }

    public void emptyTrash(){
        // clear all mails in the trash
        while (!Trash.isEmpty())
            Trash.pop();
    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox
        return this.inboxCapacity;
    }
}
