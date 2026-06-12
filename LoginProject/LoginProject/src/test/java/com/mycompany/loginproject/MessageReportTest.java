package com.mycompany.loginproject;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageReportTest {
    
    @Test
    public void testPart3Requirements() {
        MessageReport report = new MessageReport();
        report.populateTestData();

        // 1. Verify Array populate matches target size
        assertEquals(4, report.getArraySize());

        // 2. Verify display longest message
        String expectedLongest = "Where are you? You are late! I have asked you to be on time.";
        assertEquals(expectedLongest, report.displayLongestMessage());

        // 3. Verify searching by unique message ID
        assertEquals("It is dinner time!", report.searchByMessageID("0838884567"));

        // 4. Verify tracking recipient messaging lists
        String expectedSearch = "\"Where are you? You are late! I have asked you to be on time.\" \"It is dinner time!\"";
        assertEquals(expectedSearch, report.searchByRecipient("+27838884567"));

        // 5. Verify string confirmation sequence returned on dynamic deletes
        String expectedDelete = "Message: \"Where are you? You are late! I have asked you to be on time.\" successfully deleted.";
        assertEquals(expectedDelete, report.deleteMessageByHash("Test Message 2"));
    }
}

