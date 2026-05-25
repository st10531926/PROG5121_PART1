package com.mycompany.loginproject;

public class Login {
    private String regUser, regPass, fName, lName;

    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity(String password) {
        boolean hasCap = !password.equals(password.toLowerCase());
        boolean hasNum = password.matches(".*\\d.*");
        boolean hasSpec = password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*");
        return password.length() >= 8 && hasCap && hasNum && hasSpec;
    }

    public boolean checkCellPhoneNumber(String cell) {
        // Matches the test data: +27838968976
        return cell.startsWith("+") && cell.length() == 12;
    }

    public String registerUser(String user, String pass, String cell, String first, String last) {
        if (!checkUserName(user)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        } 
        if (!checkPasswordComplexity(pass)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        
        this.regUser = user;
        this.regPass = pass;
        this.fName = first;
        this.lName = last;
        return "Username and Password successfully captured.";
    }

    public boolean loginUser(String user, String pass) {
        return user.equals(regUser) && pass.equals(regPass);
    }

    public String returnLoginStatus(boolean loggedIn) {
        if (loggedIn) {
            return "Welcome " + fName + ", " + lName + " it is great to see you.";
        } else {
            return "Username or password incorrect, please try again";
        }
    }
}

