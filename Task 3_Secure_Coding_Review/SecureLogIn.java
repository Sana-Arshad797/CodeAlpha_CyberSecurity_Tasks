import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SecureLogIn {

    private static final String DB_URL = System.getenv("DB_URL") != null ? System.getenv("DB_URL") : "jdbc:mysql://localhost:3306/company_db";
    private static final String DB_USER = System.getenv("DB_USER") != null ? System.getenv("DB_USER") : "default_safe_user";
    private static final String DB_PASSWORD = System.getenv("DB_PASSWORD");

    public void secureDBOperations(String username, String password) {
        System.out.println("[*] Executing SecureLogIn logic of Code");
        System.out.println("[*] Fetching credentials safely from environment variables...");

        String loginQuery = "SELECT * FROM users WHERE username = ? AND password = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = connection.prepareStatement(loginQuery)) {

            System.out.println("[+] Success! Securely connected to database.");

            pstmt.setString(1, username);
            pstmt.setString(2, password);

            try (ResultSet resultSet = pstmt.executeQuery()) {
                if (resultSet.next()) {
                    System.out.println("[+] Login Successful!");
                } else {
                    System.out.println("[-] Invalid credentials.");
                }
            }

        } catch (SQLException e) {
            System.out.println("[-] Database Runtime Event: Connection or execution failed.");
            System.out.println("[-] Log details: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("**********SecureLogIn Process Started**********");
        SecureLogIn application = new SecureLogIn();
        application.secureDBOperations("admin", "password123");
        System.out.println("**********Process Ended**********");
    }
}