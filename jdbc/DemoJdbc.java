package jdbc;

import javax.swing.plaf.nimbus.State;
import java.sql.*;


public class DemoJdbc {
    /*
    import packages
    load and register driver
    creat connection
    execute statement
    process the results
    close
    */

    public static void selectData(Statement statement) throws SQLException {
        String query = "select * from student";
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("student_id") + "   " + resultSet.getString("s_name") + "    " + resultSet.getInt("marks"));
        }
    }

    public static void addData(Statement statement, Integer id, String name, Integer marks) throws SQLException {
        String query = """
                insert into student values (%d,'%s',%d);
                """.formatted(id, name, marks);
        statement.execute(query);
    }

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/demo";
        String userName = "postgres";
        String password = "1234";

        try (
                Connection con = DriverManager.getConnection(url, userName, password);
                Statement statement = con.createStatement();
        ) {

            System.out.println("Connection Established....\n\n");
            Class.forName("org.postgresql.Driver");

            String query = """
                    UPDATE student SET s_name = '%s' WHERE student_id = 2
                    """.formatted("Reyansh");

            statement.executeUpdate(query);
            addData(statement, 4, "Shivam", 67);
            selectData(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
