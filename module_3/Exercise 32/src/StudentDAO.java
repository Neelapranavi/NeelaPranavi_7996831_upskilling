import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class StudentDAO {

    String url = "jdbc:mysql://localhost:3306/school";
    String user = "root";
    String password = "2005";

    // Insert Student
    public void insertStudent(int id, String name, int age) {

        try {
            Connection con =
                    DriverManager.getConnection(url, user, password);

            String query =
                    "INSERT INTO students(id, name, age) VALUES (?, ?, ?)";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, age);

            int rows = ps.executeUpdate();

            System.out.println(rows + " record inserted.");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Update Student
    public void updateStudent(int id, String newName) {

        try {
            Connection con =
                    DriverManager.getConnection(url, user, password);

            String query =
                    "UPDATE students SET name=? WHERE id=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1, newName);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            System.out.println(rows + " record updated.");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
