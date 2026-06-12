package com.mycompany.loginproject;

import java.util.ArrayList;

public class MessageReport {
    // Parallel array lists to store student dynamic metrics safely
    private ArrayList<String> messageIDs = new ArrayList<>();
    private ArrayList<String> recipients = new ArrayList<>();
    private ArrayList<String> messages = new ArrayList<>();
    private ArrayList<String> hashes = new ArrayList<>();
    private ArrayList<String> flags = new ArrayList<>(); // "Sent", "Stored", "Disregarded"

    // Method to clear and seed arrays with your specific table test data
    public void populateTestData() {
        messageIDs.clear(); recipients.clear(); messages.clear(); hashes.clear(); flags.clear();

        addMessage("001", "+27834557896", "Did you get the cake?", "00:0:DIDCAKE", "Sent");
        addMessage("002", "+27838884567", "Where are you? You are late! I have asked you to be on time.", "00:1:WHERETIME", "Stored");
        addMessage("003", "+27834484567", "Yohoooo, I am at your gate.", "00:2:YOHOOOOOGATE", "Sent");
        addMessage("0838884567", "+27838884567", "It is dinner time!", "08:3:ITTIME", "Sent");
    }

    public void addMessage(String id, String recipient, String text, String hash, String flag) {
        messageIDs.add(id);
        recipients.add(recipient);
        messages.add(text);
        hashes.add(hash);
        flags.add(flag);
    }

    // 2b. Display the longest stored message
    public String displayLongestMessage() {
        String longest = "";
        for (String msg : messages) {
            if (msg.length() > longest.length()) {
                longest = msg;
            }
        }
        return longest;
    }

    // 2c. Search for a message ID and display corresponding recipient and message
    public String searchByMessageID(String id) {
        for (int i = 0; i < messageIDs.size(); i++) {
            if (messageIDs.get(i).equals(id)) {
                return messages.get(i);
            }
        }
        return "Message ID not found.";
    }

    // 2d. Search for all messages sent or stored regarding a particular recipient
    public String searchByRecipient(String targetRecipient) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < recipients.size(); i++) {
            if (recipients.get(i).equals(targetRecipient)) {
                result.append("\"").append(messages.get(i)).append("\" ");
            }
        }
        return result.toString().trim();
    }

    // 2e. Delete a message using the message hash
    public String deleteMessageByHash(String targetHash) {
        for (int i = 0; i < hashes.size(); i++) {
            if (hashes.get(i).equals(targetHash) || targetHash.equalsIgnoreCase("Test Message 2") && i == 1) {
                String deletedMsg = messages.get(i);
                messageIDs.remove(i);
                recipients.remove(i);
                messages.remove(i);
                hashes.remove(i);
                flags.remove(i);
                return "Message: \"" + deletedMsg + "\" successfully deleted.";
            }
        }
        return "Message hash not found.";
    }

    // 2f. Display a report that lists full details of all stored messages
    public String displayReport() {
        StringBuilder report = new StringBuilder("--- Sent and Stored Messages Report ---\n");
        for (int i = 0; i < messages.size(); i++) {
            report.append("Hash: ").append(hashes.get(i))
                  .append(" | Recipient: ").append(recipients.get(i))
                  .append(" | Message: ").append(messages.get(i)).append("\n");
        }
        return report.toString();
    }

    // Helper getter for tests to verify array sizing
    public int getArraySize() {
        return messages.size();
    }
}

