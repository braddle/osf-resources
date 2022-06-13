package com.example.tdd;

public class PasswordValidator {

//    Password contains more than 8 characters
//Password contains ≥ 1 uppercase letter
//Password contains ≥ 1 number
//Password contains ≥ 1 special character
    public static boolean isNotEmpty(String password){
        if (password.isEmpty()) return false;
        return true;
    }

    public static boolean isOverEightChars(String password){
        if (password.length()<=8) return false;
        return true;
    }

    public static boolean containsUpperCase(String password){
        int uppercaseCount = 0;
        for (int i=0; i<password.length(); i++){
            if (Character.isUpperCase(password.charAt(i)) && !Character.isDigit(password.charAt(i))) {
                uppercaseCount += 1;
            }
        }
        return uppercaseCount != 0;
    }

    public static boolean containsNumber(String password){
        int numberCount = 0;
        for (int i=0; i<password.length(); i++){
            if (Character.isDigit(password.charAt(i))) {
                numberCount += 1;
            }
        }
        return  numberCount != 0;
    }

    public static boolean containsSpecialChar(String password){
        int specialCharCount = 0;
        for (int i=0; i<password.length(); i++){
            char character = password.charAt(i);
            if (!Character.isDigit(character) && !Character.isAlphabetic(character) && character!=' ') {
                specialCharCount += 1;
            }
        }
        return  specialCharCount != 0;
    }

    public static boolean isValid(String password) {
        //TODO: Implement me
        if (!isNotEmpty(password)) return false;
        if (!isOverEightChars(password)) return false;
        if (!containsUpperCase(password)) return false;
        if (!containsNumber(password)) return false;
        if (!containsSpecialChar(password)) return false;
        return true;
    }
}
