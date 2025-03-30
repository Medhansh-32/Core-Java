package jdbc;

import javax.swing.plaf.nimbus.State;
import java.net.ConnectException;
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

    static {
        loadData();
    }

    public static void loadData() {
        String url = "jdbc:postgresql://localhost:5432/demo";
        String userName = "postgres";
        String password = "1234";
        String name[] = {"Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace", "Hannah", "Ian", "Jack"};
        int marks[] = {87, 92, 76, 85, 90, 78, 88, 95, 82, 89};

        try (
                Connection con = DriverManager.getConnection(url, userName, password);
        ) {
            for (int i = 0; i < 10; i++) {
                addData(con, i + 1, name[i], marks[i]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void readData(Connection connection) throws SQLException {
        String query = "select * from student";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        System.out.println("+------ID-----------Student_Name---------------Marks-------+\n\n");
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("student_id") + "                    " + resultSet.getString("s_name") + "                        " + resultSet.getInt("marks"));
        }
        System.out.println("+-----------------------------------------+\n\n");
    }

    public static void addData(Connection connection, Integer id, String name, Integer marks) throws SQLException {
        String query = "insert into student values (?,?,?)";

        try (PreparedStatement stmt = connection.prepareStatement(query);) {
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setInt(3, marks);

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateNameById(Connection connection,
                                      String fieldValue,
                                      Integer whereValue) throws SQLException {


        String sql = " update student set s_name = ? where student_id = ? ;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, fieldValue);
        preparedStatement.setInt(2, whereValue);
        preparedStatement.executeUpdate();
        readData(connection);
    }

    public static void deleteDataById(Connection connection, Integer fieldValue) throws SQLException {
        String sql = "Delete from student where student_id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1, fieldValue);

        preparedStatement.executeUpdate();
        readData(connection);
    }

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/demo";
        String userName = "postgres";
        String password = "1234";

        try (
                Connection con = DriverManager.getConnection(url, userName, password);
        ) {

            System.out.println("Connection Established....\n\n");
            Class.forName("org.postgresql.Driver");

            addData(con, 11, "Kartik", 78);                          // create
            readData(con);                                                           //read
            updateNameById(con, "Ritish", 2);        //update
            deleteDataById(con, 4);                          //  delete
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
