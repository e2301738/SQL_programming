package fi.christian;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {

    static Connection connection = null;

    public static Connection connect() throws SQLException {
        String URL = "jdbc:mysql://localhost:3306/MeetingCalendarDB";
        String USER = "root";
        String PASSWORD = "Password1";

        connection = DriverManager.getConnection(URL, USER, PASSWORD);
        System.out.println("MySQL connection has been established");
        return connection;
    }

    public void queryParticipants() throws SQLException {
        String sql = "SELECT * FROM Participants";
        ResultSet rs = connection.createStatement().executeQuery(sql);

        System.out.println("\n--- PARTICIPANTS ---");
        while(rs.next()) {
            System.out.println(rs.getInt("id") + " " + rs.getString("name") + " (" + rs.getString("email") + ")");
        }
    }

    public void insertParticipant(String name, String email) throws SQLException {
        String sql = String.format("INSERT INTO Participants (name, email) VALUES ('%s', '%s')", name, email);
        connection.createStatement().executeUpdate(sql);
        System.out.println("Added to DB: " + name);
    }

    public void updateParticipant(int id, String newName) throws SQLException {
        String sql = String.format("UPDATE Participants SET name='%s' WHERE id=%d", newName, id);
        connection.createStatement().executeUpdate(sql);
        System.out.println("Updated ID: " + id);
    }

    public void deleteParticipant(int id) throws SQLException {
        String sql = String.format("DELETE FROM Participants WHERE id=%d", id);
        connection.createStatement().executeUpdate(sql);
        System.out.println("Deleted ID: " + id);
    }
}