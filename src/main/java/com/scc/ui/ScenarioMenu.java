package com.scc.ui;

import com.scc.dao.ScenarioDao;
import com.scc.model.ScenarioEntity;

import java.util.List;
import java.util.Scanner;

public class ScenarioMenu {
    private final ScenarioDao scenarioDao;
    private final Scanner scanner;

    public ScenarioMenu() {
        this.scenarioDao = new ScenarioDao();
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        int choice = 0;
        do {
            System.out.println("==================================================");
            System.out.println("            EVENT TICKET SALES SYSTEM             ");
            System.out.println("==================================================");
            System.out.println("[1] Add New Ticket");
            System.out.println("[2] View Sold Tickets");
            System.out.println("[3] Exit System");
            System.out.println("==================================================");
            System.out.print("Enter choice: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 3.");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    addTicketFlow();
                    break;
                case 2:
                    viewTicketsFlow();
                    break;
                case 3:
                    System.out.println("\nExiting system... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1, 2, or 3.");
            }
            System.out.println();
        } while (choice != 3);
    }

    private void addTicketFlow() {
        System.out.println("\n--- ISSUE EVENT TICKET ---");
        System.out.print("Enter Attendee Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Ticket Tier (REGULAR / VIP / VVIP): ");
        String tier = scanner.nextLine().toUpperCase();

        System.out.print("Enter Price: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid price. Please enter a valid number.");
            System.out.print("Enter Price: ");
            scanner.next();
        }
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Payment Method (CASH / GCASH / CARD): ");
        String payment = scanner.nextLine().toUpperCase();

        ScenarioEntity newTicket = new ScenarioEntity(name, tier, price, payment);
        boolean success = scenarioDao.addTicket(newTicket);

        if (success) {
            System.out.println("\nSUCCESS: Ticket issued to attendee!");
        } else {
            System.out.println("\nFAILED: Could not issue ticket.");
        }
    }

    private void viewTicketsFlow() {
        List<ScenarioEntity> tickets = scenarioDao.getAllTickets();

        System.out.println("\n==================================================");
        System.out.println("            EVENT TICKET PURCHASES                ");
        System.out.println("==================================================");
        System.out.println("+-----+--------------------+--------------+------------+------------+");
        System.out.printf("| %-3s | %-18s | %-12s | %-10s | %-10s |\n", "ID", "ATTENDEE NAME", "TICKET TIER", "PRICE", "PAYMENT");
        System.out.println("+-----+--------------------+--------------+------------+------------+");

        for (ScenarioEntity t : tickets) {
            System.out.printf("| %-3d | %-18s | %-12s | %-10.2f | %-10s |\n",
                    t.getId(),
                    t.getAttendeeName(),
                    t.getTicketTier(),
                    t.getPrice(),
                    t.getPaymentMethod()
            );
        }
        System.out.println("+-----+--------------------+--------------+------------+------------+");
        System.out.println("Total Records Displayed: " + tickets.size());
    }
}