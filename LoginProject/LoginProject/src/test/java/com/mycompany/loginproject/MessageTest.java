package com.mycompany.loginproject;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {

    @Test
    public void testMessageDataAndHash() {
        // Test Case 1 Data from your table
        String txt = "Hi Mike, can you join us for dinner tonight?";
        Message msg = new Message(0, "+27718693002", txt);
        msg.setMessageID("0012345678"); // Lock ID to 00 to verify hash format

        // 1. Verify Length Validation Success
        assertEquals("Message ready to send.", msg.validateMessageLength(txt));

        // 2. Verify Recipient Success Message
        assertEquals("Cell phone number successfully captured.", msg.checkRecipientCell());

        // 3. Verify exact Hash matches '00:0:HITONIGHT'
        assertEquals("00:0:HITONIGHT", msg.createMessageHash());
    }
    
    @Test
    public void testCellFailure() {
        // Test Case 2 Data (Fails because it does not start with +)
        Message msg2 = new Message(1, "08575975889", "Hi Keegan, did you receive the payment?");
        assertEquals("Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.", msg2.checkRecipientCell());
    }
}

