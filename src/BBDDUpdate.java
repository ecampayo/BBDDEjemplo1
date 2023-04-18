import java.nio.channels.ScatteringByteChannel;
import java.sql.*;

public class BBDDUpdate {
    public static void main(String[] args) {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/prueba", "root", "estefania");
            Statement smt = con.createStatement();
            //Realizamos consulta para asegurarnos de los datos en la bbdd
            ResultSet rs = smt.executeQuery("SELECT id from contacto where nombre='Juan'");
            if (rs.next()) {
                int id = rs.getInt("id");//Obtener el id a modificar
                //Actualizamos el registro
                smt.executeUpdate("UPDATE contacto SET telefono'971234567' WHERE id=" + id);
            }
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

