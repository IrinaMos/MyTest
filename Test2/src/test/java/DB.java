import java.sql.*;

public class DB {
        private static Connection con;

        public static void main(String[] args) throws SQLException, ClassNotFoundException {
            connectToDB();
            readDBTable();
        }

        public static void connectToDB() throws ClassNotFoundException, SQLException {

            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // Open a connection
            con = DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/mysql?serverTimezone=UTC", "sql12284329", "JhY4KKTk7Q");

        }

        private static void readDBTable() throws SQLException {
            //Execute a query
            String statementToExecute = "";
            Statement stmt = con.createStatement();
           //statementToExecute = "SELECT * FROM ir_schema.first_table;";
            statementToExecute = "SELECT * FROM sql12284329.map_table;";


            // iterate over query results
            ResultSet rs = stmt.executeQuery(statementToExecute);
            while (rs.next()) {
                //Retrieve by column name
                String search = rs.getString("criteria");
                String location = rs.getString("url");

                //Display values
                System.out.println("Search: " + search);
                System.out.println("Location: " + location);
            }
            stmt.close();
            con.close();
            rs.close();
            // close db connections
        }
    }
