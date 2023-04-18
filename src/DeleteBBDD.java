import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteBBDD {
    public static void main(String[] args) {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/prueba", "root", "estefania");
            Statement smt = con.createStatement();
            smt.executeUpdate("DELETE FROM contacto WHERE id=1");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                //Cerrar la conexión con la base de datos
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
