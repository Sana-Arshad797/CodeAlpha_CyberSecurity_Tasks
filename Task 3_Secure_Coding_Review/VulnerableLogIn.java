import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class VulnerableLogIn {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/company_db";
    private static final String DB_USER = "demo_user";
    private static final String DB_PASSWORD = "DUMMY_PASSWORD_PLACEHOLDER_123";

    public void DB_Operations() {
        System.out.println("[*] Executing VulnerableLogIn logic of Code");
        System.out.println("[*] Attempting database connection with hardcoded credentials");

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            System.out.println("[+] Success! Connected to database using embedded string constants");

            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT version();");

            if (resultSet.next()) {
                System.out.println("[+] Database Engine Version: " + resultSet.getString(1));
            }

        } catch (Exception e) {
            System.out.println("[-] Connection runtime event: Database is offline or unreachable.");
            System.out.println("[-] Log details: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("**********VulnerableLogIn Process Started**********");
        VulnerableLogIn application = new VulnerableLogIn();
        application.DB_Operations();
        System.out.println("**********Process Ended**********");
    }
}