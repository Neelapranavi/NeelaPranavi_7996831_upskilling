import java.sql.*;

public class TransactionDemo {

    static String url = "jdbc:mysql://localhost:3306/school";
    static String user = "root";
    static String password = "2005";

    public static void transfer(int fromId,
                                int toId,
                                double amount) {

        try {

            Connection con =
                    DriverManager.getConnection(
                            url, user, password);

            // Start Transaction
            con.setAutoCommit(false);

            String debitQuery =
                    "UPDATE accounts SET balance = balance - ? WHERE id = ?";

            PreparedStatement debit =
                    con.prepareStatement(debitQuery);

            debit.setDouble(1, amount);
            debit.setInt(2, fromId);

            debit.executeUpdate();

            String creditQuery =
                    "UPDATE accounts SET balance = balance + ? WHERE id = ?";

            PreparedStatement credit =
                    con.prepareStatement(creditQuery);

            credit.setDouble(1, amount);
            credit.setInt(2, toId);

            credit.executeUpdate();

            // Save changes
            con.commit();

            System.out.println("Transfer Successful");

            con.close();

        } catch (Exception e) {

            System.out.println("Transfer Failed");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        transfer(1, 2, 1000);
    }
}