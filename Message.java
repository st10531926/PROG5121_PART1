package loginproject;

import java.util.Random;

public class Message {
    private String messageID;
    private int messageNumber;
    private String recipient;
    private String messageText;
    private static int totalMessagesSent = 0; 

    // Constructor
    public Message(int messageNumber, String recipient, String messageText) {
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.messageText = messageText;
        this.messageID = generateRandomID();
    }

    // Helper method to make a 10-digit random number starting with "00" for the test match
    private String generateRandomID() {
        Random rand = new Random();
        long num = 10000000 + rand.nextInt(90000000);
        return "00" + num;
    }

    public String validateMessageLength(String msg) {
        if (msg.length() <= 250) {
            return "Message ready to send.";
        } else {
            int exceededBy = msg.length() - 250;
            return "Message exceeds 250 characters by " + exceededBy + "; please reduce the size.";
        }
    }

    public boolean checkMessageID() {
        return this.messageID != null && this.messageID.length() <= 10;
    }

    public String checkRecipientCell() {
        if (recipient.startsWith("+") && recipient.length() >= 10 && recipient.length() <= 13) { 
            return "Cell phone number successfully captured.";
        } else {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
    }

    public String createMessageHash() {
        String firstTwo = messageID.substring(0, 2);
        String cleanText = messageText.replaceAll("[^a-zA-Z0-9\\s]", ""); 
        String[] words = cleanText.trim().split("\\s+");
        
        String firstWord = words[0];
        String lastWord = words[words.length - 1];
        
        return (firstTwo + ":" + messageNumber + ":" + firstWord + lastWord).toUpperCase();
    }

    public String SentMessage(int choice) {
        if (choice == 1) {
            totalMessagesSent++;
            return "Message successfully sent.";
        } else if (choice == 0) {
            return "Press 0 to delete the message.";
        } else if (choice == 2) {
            return "Message successfully stored.";
        }
        return "Invalid Option";
    }

    public String printMessages() {
        return "Message ID generated: " + messageID + "\n" +
               "Message Hash: " + createMessageHash() + "\n" +
               "Recipient: " + recipient + "\n" +
               "Message: " + messageText;
    }

    public int returnTotalMessagess() {
        return totalMessagesSent;
    }

    public String storeMessage() {
        return "{\n" +
               "  \"messageID\": \" " + messageID + "\",\n" +
               "  \"messageHash\": \"" + createMessageHash() + "\",\n" +
               "  \"recipient\": \"" + recipient + "\",\n" +
               "  \"message\": \"" + messageText + "\"\n" +
               "}";
    }

    // Setter for testing purposes
    public void setMessageID(String id) { this.messageID = id; }
}

