import java.sql.*;

public class BBDDEjemplo {
    public static void main(String[] args) {
        Connection con= null;
        try{
            //Cargar el driver
           // Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection(("jdbc:mysql://localhost/prueba"), "root", "estefania");
            //Creo el objeto Statement para utilizarlo en el select
            Statement smt=con.createStatement();
            ResultSet rs= smt.executeQuery("select * from persona");
            // Imprimos resultados línea a línea
            while(rs.next()){
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDate(3));
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
