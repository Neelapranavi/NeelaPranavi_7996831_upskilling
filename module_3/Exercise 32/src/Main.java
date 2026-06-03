public class Main {

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();

        dao.insertStudent(3, "Pranavi", 20);

        dao.updateStudent(3, "Pranavi Reddy");
    }
}