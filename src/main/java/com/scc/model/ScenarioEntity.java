package com.scc.model;

public class ScenarioEntity {
    private int id;
    private String attendeeName;
    private String ticketTier;
    private double price;
    private String paymentMethod;

    public ScenarioEntity() {}

    public ScenarioEntity(String attendeeName, String ticketTier, double price, String paymentMethod) {
        this.attendeeName = attendeeName;
        this.ticketTier = ticketTier;
        this.price = price;
        this.paymentMethod = paymentMethod;
    }

    public ScenarioEntity(int id, String attendeeName, String ticketTier, double price, String paymentMethod) {
        this.id = id;
        this.attendeeName = attendeeName;
        this.ticketTier = ticketTier;
        this.price = price;
        this.paymentMethod = paymentMethod;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getAttendeeName() { return attendeeName; }
    public void setAttendeeName(String attendeeName) { this.attendeeName = attendeeName; }

    public String getTicketTier() { return ticketTier; }
    public void setTicketTier(String ticketTier) { this.ticketTier = ticketTier; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
}