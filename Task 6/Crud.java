import java.sql.*;
import java.util.Scanner;


public class Crud{

    // private static String url = jdbc:mysql://<HOST>:<PORT>/<DATABASE>?<OPTIONS>
    private static String url = "jdbc:mysql://localhost:3306/testdb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static String user = "root";
    private static String password = "root";

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        try{
           
             // Step 1: Load the MySQL JDBC driver (not always required in Java 8+)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Get a connection
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established.");

            // below getting details to add in table
            System.out.print("Enter name = ");
            String name = sc.nextLine();
            
            System.out.print("Enter email = ");
            String email = sc.nextLine();

            String insertQuery = "INSERT INTO demoTest(name, email) VALUES (?, ?)";
            PreparedStatement ps1 = con.prepareStatement(insertQuery);
            ps1.setString(1, name);
            ps1.setString(2, email);

            int rows = ps1.executeUpdate();
            if(rows == 1){

                System.out.println("Record inserted successfully!");
            }
            else{

                System.out.println("Failed to insert records!");
            }

            System.out.print("\nEnter : \n 1. \"y\" - Display table contents.\n 2. \"n\" - Exit program.\n\nEnter option = ");
            String option = sc.nextLine();

            if(option.equals("y")){

                String selectQuery = "SELECT * FROM demoTest";
                PreparedStatement ps2 = con.prepareStatement(selectQuery);
                ResultSet rs1 = ps2.executeQuery();

                System.out.println("\nBelow are the table contents :\n");

                // Print table header
                System.out.printf("%-5s %-20s %-30s%n", "Id", "Name", "Email");
                System.out.println("---------------------------------------------------------------");

                // Print table rows
                while (rs1.next()) {
                    int rs1Id = rs1.getInt("id");
                    String rs1Name = rs1.getString("name");
                    String rs1Email = rs1.getString("email");

                    System.out.printf("%-5d %-20s %-30s%n", rs1Id, rs1Name, rs1Email);
                }

                ps2.close();
                rs1.close();
            }

            ps1.close();
            con.close();
            System.out.println("\nThanks for using the application!");
        }
        catch(Exception e){

            e.printStackTrace();
        }
        finally{

            sc.close();
        }
    }
}