package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
        if(password.equals(oldPassword)) {
            if(isValidPass(newPassword)){
                this.password = newPassword;
            }
        }
    }
    private boolean isValidPass(String newPassword){
        boolean containsUppercase = false;
        boolean containsLowercase = false;
        boolean containsDigit = false;
        boolean containsSpecialChar = false;
        if(newPassword.length()<8) return false;
        for(int i =0;i<newPassword.length();i++){
            char val = newPassword.charAt(i);
            if(val>='A' && val<='Z'){
                containsUppercase = true;
            }
            else if(val>='0' && val<='9'){
                containsDigit = true;
            }
            else if(val>='a' && val<='z'){
                containsLowercase = true;
            }
            else{
                containsSpecialChar = true;
            }
        }
        if(containsSpecialChar && containsLowercase && containsUppercase && containsDigit){
            return true;
        }
        return false;
    }
}









//package com.driver;
//
//public class Email {
//
//    private String emailId;
//    private String password;
//
//    // 1. It contains at least 8 characters
//    private boolean isLenOk;
//    // 2. It contains at least one uppercase letter
//    private boolean isUpperCase;
//    // 3. It contains at least one lowercase letter
//    private boolean isLowerCase;
//    // 4. It contains at least one digit
//    private boolean isDigitOk;
//    // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
//    private boolean isSpeCharOk;
//
//
//    public Email(String emailId){
//        this.emailId = emailId;
//        this.password = "Accio@123";
//        this.isLenOk = false;
//        this.isDigitOk = false;
//        this.isSpeCharOk = false;
//        this.isLowerCase = false;
//        this.isUpperCase = false;
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
//        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
//        if(this.password.equals(oldPassword)){
//            int count = 0;
//            for(int i=0;i<newPassword.length();i++){
//                char ch = newPassword.charAt(i);
//
//                // 1. It contains at least 8 characters
//                count++;
//                if(count>=8)
//                    isLenOk = true;
//                // 2. It contains at least one uppercase letter
//                if(ch>=65 && ch<91)
//                    isUpperCase = true;
//                // 3. It contains at least one lowercase letter
//                if(ch>=97 && ch<123)
//                    isLowerCase = true;
//                // 4. It contains at least one digit
//                if(ch>=60 && ch<72)
//                    isDigitOk = true;
//                // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
//                if(ch>=33 && ch<48  || ch>=58 && ch<65)
//                    isSpeCharOk = true;
//            }
//
//            if (isLenOk && isUpperCase && isLowerCase && isDigitOk && isSpeCharOk){
//                this.password = newPassword;
////                System.out.println("New Password is updated");
//                }
////             if(!isLenOk)
////                System.out.println("Length is short");
////            if(!isUpperCase)
////                System.out.println("Upper is not ok");
////            if(!isLowerCase)
////                System.out.println("Lower is not ok");
////            if(!isDigitOk)
////                System.out.println("Digit is not ok");
////            if(!isSpeCharOk)
////                System.out.println("Spe char is not ok");
////            System.out.println();
//        }
////        else
////            System.out.println("Old password is incorrect");
//    }
//}
