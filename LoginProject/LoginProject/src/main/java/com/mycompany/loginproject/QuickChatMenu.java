package com.mycompany.loginproject;

import java.util.Scanner;

public class QuickChatMenu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to QuickChat.");
        
        int choice = 0;
        int currentMsgIndex = 0;
        Message helperMsg = new Message(0, "", ""); // Internal helper counter tool
        MessageReport reporter = new MessageReport();
        reporter.populateTestData(); // Pre-load the required Part 3 assignment test data matrix

        while (choice != 5) {
            System.out.println("\nSelect an Option:");
            System.out.println("1) Send Messages");
            System.out.println("2) Show recently sent messages");
            System.out.println("4) Open Stored Messages Reporting Tools (Part 3)");
            System.out.println("5) Quit");
            System.out.print("Choice: ");
            
            choice = input.nextInt();
            input.nextLine(); // Clear scanner string buffer sequence safely

            if (choice == 1) {
                System.out.print("How many messages do you wish to enter? ");
                int numEntries = input.nextInt();
                input.nextLine();

                for (int i = 0; i < numEntries; i++) {
                    System.out.print("\nEnter Recipient: ");
                    String cell = input.nextLine();
                    System.out.print("Enter Message text: ");
                    String text = input.nextLine();

                    Message currentMsg = new Message(currentMsgIndex, cell, text);
                    
                    System.out.println(currentMsg.validateMessageLength(text));
                    System.out.println(currentMsg.checkRecipientCell());
                    
                    System.out.println("Choose action: 1) Send Message, 0) Disregard Message, 2) Store Message");
                    int action = input.nextInt();
                    input.nextLine();
                    
                    System.out.println(currentMsg.SentMessage(action));
                    if (action == 1) {
                        System.out.println("\n--- Full Message Details ---");
                        System.out.println(currentMsg.printMessages());
                        System.out.println("\nResearched JSON Output:\n" + currentMsg.storeMessage());
                        // Add live input data directly to array system matching assignment specs
                        reporter.addMessage("00"+currentMsgIndex, cell, text, currentMsg.createMessageHash(), "Sent");
                    } else if (action == 2) {
                        reporter.addMessage("00"+currentMsgIndex, cell, text, currentMsg.createMessageHash(), "Stored");
                    }
                    currentMsgIndex++;
                }
            } else if (choice == 2) {
                System.out.println("Coming Soon.");
            } else if (choice == 4) {
                System.out.println("\n--- Part 3 Reporting SubMenu ---");
                System.out.println("a) Display longest message");
                System.out.println("b) Search for Message ID");
                System.out.println("c) Search for Recipient Phone Number");
                System.out.println("d) Delete Message via Hash");
                System.out.println("e) View Full Report");
                System.out.print("Select feature letter (a-e): ");
                String sub = input.nextLine();

                if (sub.equalsIgnoreCase("a")) {
                    System.out.println("\nLongest Message: " + reporter.displayLongestMessage());
                } else if (sub.equalsIgnoreCase("b")) {
                    System.out.print("Enter Message ID: ");
                    String searchID = input.nextLine();
                    System.out.println("Result: " + reporter.searchByMessageID(searchID));
                } else if (sub.equalsIgnoreCase("c")) {
                    System.out.print("Enter Target Recipient Number: ");
                    String searchPhone = input.nextLine();
                    System.out.println("Result: " + reporter.searchByRecipient(searchPhone));
                } else if (sub.equalsIgnoreCase("d")) {
                    System.out.print("Enter Target Hash to Delete: ");
                    String targetHash = input.nextLine();
                    System.out.println(reporter.deleteMessageByHash(targetHash));
                } else if (sub.equalsIgnoreCase("e")) {
                    System.out.println("\n" + reporter.displayReport());
                } else {
                    System.out.println("Invalid selection.");
                }
            } else if (choice == 5) {
                System.out.println("Total accumulated messages sent: " + helperMsg.returnTotalMessagess());
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid menu option selected.");
            }
        }
        input.close();
    }
}
