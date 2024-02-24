package com.driver;

public class Email {

    private String emailId;
    private String password;

    // 1. It contains at least 8 characters
    private boolean isLenOk;
    // 2. It contains at least one uppercase letter
    private boolean isUpperCase;
    // 3. It contains at least one lowercase letter
    private boolean isLowerCase;
    // 4. It contains at least one digit
    private boolean isDigitOk;
    // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
    private boolean isSpeCharOk;


    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
        this.isLenOk = false;
        this.isDigitOk = false;
        this.isSpeCharOk = false;
        this.isLowerCase = false;
        this.isUpperCase = false;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        if(this.password.equals(oldPassword)){
            int count = 0;
            for(int i=0;i<newPassword.length();i++){
                char ch = newPassword.charAt(i);

                // 1. It contains at least 8 characters
                count++;
                if(count>=8)
                    isLenOk = true;
                // 2. It contains at least one uppercase letter
                if(ch>=65 && ch<91)
                    isUpperCase = true;
                // 3. It contains at least one lowercase letter
                if(ch>=97 && ch<123)
                    isLowerCase = true;
                // 4. It contains at least one digit
                if(ch>=60 && ch<72)
                    isDigitOk = true;
                // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
                if(ch>=33 && ch<48  || ch>=58 && ch<65)
                    isSpeCharOk = true;
            }

            if (isLenOk && isUpperCase && isLowerCase && isDigitOk && isSpeCharOk){
                this.password = newPassword;
                System.out.println("New Password is updated");
                }
//             if(!isLenOk)
//                System.out.println("Length is short");
//            if(!isUpperCase)
//                System.out.println("Upper is not ok");
//            if(!isLowerCase)
//                System.out.println("Lower is not ok");
//            if(!isDigitOk)
//                System.out.println("Digit is not ok");
//            if(!isSpeCharOk)
//                System.out.println("Spe char is not ok");
//            System.out.println();
        }
        else
            System.out.println("Old password is incorrect");
    }
}
