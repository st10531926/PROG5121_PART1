package com.mycompany.loginproject;

import java.util.Scanner;

public class QuickChatMenu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to QuickChat.");
        
        int choice = 0;
        int currentMsgIndex = 0;
        Message helperMsg = new Message(0, "", ""); 

        while (choice != 3) {
            System.out.println("\nSelect an Option:\n1) Send Messages\n2) Show recently sent messages\n3) Quit");
            System.out.print("Choice: ");
            choice = input.nextInt();
            input.nextLine();

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
                    }
                    currentMsgIndex++;
                }
            } else if (choice == 2) {
                System.out.println("Coming Soon.");
            } else if (choice == 3) {
                System.out.println("Total accumulated messages sent: " + helperMsg.returnTotalMessagess());
                System.out.println("Goodbye!");
            }
        }
        input.close();
    }
}

 System.out.println("4) Open Stored Messages Reporting Tools");

// Handle Option 4 selection
 if (choice == 4) {
    MessageReport reporter = new MessageReport();
    reporter.populateTestData(); // seed sample parameters instantly

    System.out.println("\n--- Reporting SubMenu ---");
    System.out.println("a) Longest message\nb) Search ID\nc) Search Recipient\nd) Delete via Hash\ne) View Report");
    String sub = input.nextLine();

    if (sub.equalsIgnoreCase("a")) {
        System.out.println("Longest: " + reporter.displayLongestMessage());
    } else if (sub.equalsIgnoreCase("b")) {
        System.out.print("Enter ID: ");
        System.out.println(reporter.searchByMessageID(input.nextLine()));
    } else if (sub.equalsIgnoreCase("c")) {
        System.out.print("Enter Target Phone: ");
        System.out.println(reporter.searchByRecipient(input.nextLine()));
    } else if (sub.equalsIgnoreCase("d")) {
        System.out.print("Enter Hash target: ");
        System.out.println(reporter.deleteMessageByHash(input.nextLine()));
    } else if (sub.equalsIgnoreCase("e")) {
        System.out.println(reporter.displayReport());
    }
}

