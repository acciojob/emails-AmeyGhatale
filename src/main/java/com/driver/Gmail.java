package com.driver;

import java.util.*;


public class Gmail extends Email {

    int inboxCapacity; //maximum number of mails inbox can store
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
    private ArrayList<Address> inbox;
    private ArrayList<Address> trash;

    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity = inboxCapacity;
        inbox = new ArrayList<>();
        trash = new ArrayList<>();
    }

    public void receiveMail(Date date, String sender, String message){
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.
        if(inbox.size()>=getInboxCapacity()){
            trash.add(inbox.get(0));
            inbox.remove(0);
        }
        inbox.add(new Address(message,date,sender));
    }

    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing
        for(int i =0;i<inbox.size();i++){
            Address m = inbox.get(i);
            //if(m.message==null) continue;
            if(m.message.equals(message)){
                trash.add(m);
                inbox.remove(i);
                return;
            }
        }

    }

    public String findLatestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox
        if(inbox.size()==0) return null;
        else return inbox.get(inbox.size()-1).message;
    }

    public String findOldestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox
        if(inbox.size()==0) return null;
        else return inbox.get(0).message;
    }

    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date
        int count = 0;
        for(int i =0;i<inbox.size();i++){
            Address m = inbox.get(i);
            if(m.date.compareTo(start)>=0 && m.date.compareTo(end)<=0){
                count++;
            }
        }
        return count;
    }

    public int getInboxSize(){
        // Return number of mails in inbox
        return inbox.size();
    }

    public int getTrashSize(){
        // Return number of mails in Trash
        return trash.size();
    }

    public void emptyTrash(){
        // clear all mails in the trash
        trash.clear();
    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox
        return this.inboxCapacity;
    }
    private class Address{
        String sender;
        Date date;
        String message;
        Address(String message, Date date,String sender ){
            this.date = date;
            this.sender = sender;
            this.message = message;
        }
    }
}














//package com.driver;
//
//public class Email {
//
//    private String emailId;
//    private String password;
//
//    public Email(String emailId){
//        this.emailId = emailId;
//        this.password = "Accio@123";
//    }
//
//    public String getEmailId() {
//        return emailId;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void changePassword(String oldPassword, String newPassword){
//        //Change password only if the oldPassword is equal to current password and the new password meets all the following:
//        // 1. It contains at least 8 characters
//        // 2. It contains at least one uppercase letter
//        // 3. It contains at least one lowercase letter
//        // 4. It contains at least one digit
//        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
//        if(password.equals(oldPassword)) {
//            if(isValidPass(newPassword)){
//                this.password = newPassword;
//            }
//        }
//    }
//    private boolean isValidPass(String newPassword){
//        boolean containsUppercase = false;
//        boolean containsLowercase = false;
//        boolean containsDigit = false;
//        boolean containsSpecialChar = false;
//        if(newPassword.length()<8) return false;
//        for(int i =0;i<newPassword.length();i++){
//            char val = newPassword.charAt(i);
//            if(val>='A' && val<='Z'){
//                containsUppercase = true;
//            }
//            else if(val>='0' && val<='9'){
//                containsDigit = true;
//            }
//            else if(val>='a' && val<='z'){
//                containsLowercase = true;
//            }
//            else{
//                containsSpecialChar = true;
//            }
//        }
//        if(containsSpecialChar && containsLowercase && containsUppercase && containsDigit){
//            return true;
//        }
//        return false;
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
////package com.driver;
////
////import java.util.*;
////
////public class Gmail extends Email {
////
////    int inboxCapacity; //maximum number of mails inbox can store
////    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
////    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
////    private Deque<Mail> Inbox;
////    private Deque<Mail> Trash;
////
////    public Gmail(String emailId, int inboxCapacity) {
////        super(emailId);
////        this.inboxCapacity = inboxCapacity;
////        Inbox = new LinkedList<>();
////        Trash = new LinkedList<>();
////    }
////
////    public void receiveMail(Date date, String sender, String message){
////        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
////        // It is guaranteed that:
////        // 1. Each mail in the inbox is distinct.
////        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.
////        Mail mail = new Mail(date, sender, message);
////
////        if (inboxCapacity==0) {
////            Trash.add(Inbox.removeLast());
////            inboxCapacity++;
////        }
////
////            Inbox.addFirst(mail);
////            inboxCapacity--;
////    }
////
////    public void deleteMail(String message){
////        // Each message is distinct
////        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing
////        Stack<Mail> store = new Stack<>();
////
////        while(!Inbox.isEmpty()){
////            Mail mail = Inbox.pop();
////            if(mail.getMessage().equals(message))
////                Trash.add(mail);
////           store.push(mail);
////        }
////
////        while(!store.isEmpty())
////            Inbox.addFirst(store.pop());
////    }
////
////    public String findLatestMessage(){
////        // If the inbox is empty, return null
////        // Else, return the message of the latest mail present in the inbox
////        if(Inbox.isEmpty())
////            return null;
////
////        Mail mail = Inbox.getFirst();
////        return mail.getMessage();
////    }
////
////    public String findOldestMessage(){
////        // If the inbox is empty, return null
////        // Else, return the message of the oldest mail present in the inbox
////        if (Inbox.isEmpty())
////            return null;
////
////        Mail mail = Inbox.getLast();
////        return mail.getMessage();
////    }
////
////    public int findMailsBetweenDates(Date start, Date end){
////        //find number of mails in the inbox which are received between given dates
////        //It is guaranteed that start date <= end date
////
////        int count = 0;
////        for(Mail mail : Inbox){
////            int stValue = start.compareTo(mail.getDate());
////            int endValue = end.compareTo(mail.getDate());
////
////            if(stValue<=0 && endValue>=0)
////                count++;
////        }
////        return count;
////    }
////
////    public int getInboxSize(){
////        // Return number of mails in inbox
////        return Inbox.size();
////    }
////
////    public int getTrashSize(){
////        // Return number of mails in Trash
////        return Trash.size();
////    }
////
////    public void emptyTrash(){
////        // clear all mails in the trash
////        while (!Trash.isEmpty())
////            Trash.pop();
////    }
////
////    public int getInboxCapacity() {
////        // Return the maximum number of mails that can be stored in the inbox
////        return this.inboxCapacity;
////    }
////
////
////    private static class Mail{
////        private Date date;
////        private String senderId;
////        private String message;
////
////        public Mail(Date date, String senderId, String message) {
////            this.date = date;
////            this.senderId = senderId;
////            this.message = message;
////        }
////
////        public Date getDate() {
////            return date;
////        }
////
////        public String getSender() {
////            return senderId;
////        }
////
////        public String getMessage() {
////            return message;
////        }
////    }
////}
