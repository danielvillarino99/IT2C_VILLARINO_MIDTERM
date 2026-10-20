package com.scc.dao;

import com.scc.model.ScenarioEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ScenarioDao {

    public boolean addTicket(ScenarioEntity ticket) {
        // Changed 'tickets' to 'scenario' to match your Letos table name
        String sql = "INSERT INTO scenario(attendee_name, ticket_tier, price, payment_method) VALUES(?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, ticket.getAttendeeName());
            pstmt.setString(2, ticket.getTicketTier());
            pstmt.setDouble(3, ticket.getPrice());
            pstmt.setString(4, ticket.getPaymentMethod());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return false;
        }
    }

    public List<ScenarioEntity> getAllTickets() {
        List<ScenarioEntity> tickets = new ArrayList<>();
        // Changed 'tickets' to 'scenario' to match your Letos table name
        String sql = "SELECT * FROM scenario";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                ScenarioEntity ticket = new ScenarioEntity(
                        rs.getInt("id"),
                        rs.getString("attendee_name"),
                        rs.getString("ticket_tier"),
                        rs.getDouble("price"),
                        rs.getString("payment_method")
                );
                tickets.add(ticket);
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
        return tickets;
    }
}