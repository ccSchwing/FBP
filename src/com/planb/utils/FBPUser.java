package com.planb.utils;

public class FBPUser {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String displayName;
    private String hashedPassword;

    public FBPUser(String firstName, String lastName, String emailAddress, String displayName, String hashedPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.displayName = displayName;
        this.hashedPassword = hashedPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }
}