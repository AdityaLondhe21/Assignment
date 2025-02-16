import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

public class EmployeeData {
    private static final String URL = "jdbc:postgresql://postgres-container:5432/EmployeeDB";
    private static final String USER = "postgres";
    private static final String PASSWORD = "tiger";

    public static void loadData(HashMap<Integer, Employee> employees) {
        try {
            // Register the PostgreSQL JDBC driver
            Class.forName("org.postgresql.Driver");

            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT * FROM Employee")) {

                while (rs.next()) {
                    int id = rs.getInt("EID");
                    String name = rs.getString("NAME");
                    String designation = rs.getString("DESIGNATION");
                    int age = rs.getInt("AGE");
                    int salary = rs.getInt("SALARY");

                    Employee employee;
                    switch (designation) {
                        case "CEO" -> {
                            employee = CEO.loadCEO(name, designation, salary, age, id);
                            CEO.setCEO(employee);
                        }
                        case "CLERK" -> employee = Clerk.loadClerk(name, designation, salary, age, id);
                        case "PROGRAMMER" -> employee = Programmer.loadProgrammer(name, designation, salary, age, id);
                        case "MANAGER" -> employee = Manager.loadManager(name, designation, salary, age, id);
                        default -> employee = OtherDesignation.loadOther(name, designation, salary, age, id);
                    }
                    employees.put(id, employee);
                }
                String deleteSQL = "DELETE FROM Employee";
                try (Statement deleteStmt = conn.createStatement()) {
                    deleteStmt.executeUpdate(deleteSQL);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveData(HashMap<Integer, Employee> employees) {
        try {
            // Register the PostgreSQL JDBC driver
            Class.forName("org.postgresql.Driver");

            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
                String deleteSQL = "DELETE FROM Employee";
                try (Statement stmt = conn.createStatement()) {
                    stmt.executeUpdate(deleteSQL);
                }

                String insertSQL = "INSERT INTO Employee (EID, NAME, DESIGNATION, AGE, SALARY) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
                    for (Employee employee : employees.values()) {
                        pstmt.setInt(1, employee.getID());
                        pstmt.setString(2, employee.getName());
                        pstmt.setString(3, employee.getDesignation());
                        pstmt.setInt(4, employee.getAge());
                        pstmt.setInt(5, employee.getSalary());
                        pstmt.addBatch();
                    }
                    pstmt.executeBatch();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}