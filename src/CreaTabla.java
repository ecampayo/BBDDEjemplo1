import java.sql.*;

public class CreaTabla {
    public static void main(String[] args) {
        Connection con=null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/prueba", "root", "estefania");
            Statement smt = con.createStatement();
            //Creamos una nueva tabla
            smt.executeUpdate("CREATE TABLE contacto (id INT AUTO_INCREMENT, PRIMARY KEY (id), " +
                    "nombre VARCHAR(20), apellidos VARCHAR(20), telefono VARCHAR(20))");
            //Creamos algunos datos
            String nombre[] = {"Juan", "Pedro", "Antonia"};
            String apellidos[] = {"Lopez", "Fernandez", "Ruiz"};
            String telefono[] = {"971242525", "971253536", "971225295"};
            //insertamos en la BBDD
            for (int i = 0; i < nombre.length; i++){
                smt.executeUpdate("INSERT INTO contacto (nombre, apellidos, telefono) VALUES (" + nombre[i] + " " + apellidos[i] + " " + telefono[i] + ")");
            }
        //Consulta para comprobar que se ha cargado correctamente
            ResultSet rs =smt.executeQuery("select * from contacto");
            //Recorremos la tabla con un bucle
            while (rs.next()){
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+ rs.getString(3)+ " "+ rs.getString(4));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        } finally{
            try{
                //Cerrar la conexión con la base de datos
                if (con!=null){
                    con.close();
                }
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }

}
