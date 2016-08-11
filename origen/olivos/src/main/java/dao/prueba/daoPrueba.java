package dao.prueba;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static com.conexion.Conexion.*;


public class daoPrueba {

	public static String cargarNombrePrueba(){
      Connection  cn =null;
      PreparedStatement pstm = null;
      ResultSet rs;
      String nom = null;
		try {
			cn = obtenerConexion();
		
			System.out.println(">>>>>>>> cn : " + cn);
			if(cn!=null){
				System.out.println("cn is open? : " + !cn.isClosed());	
			}else{
				return "Es nulla";
			}
			
        	 pstm = cn.prepareStatement("select * from cliente ");
             rs = pstm.executeQuery();

             while (rs.next()) {
            	 nom = rs.getString(2);
				
			}
        } catch (Exception e) {
            e.printStackTrace();
            return "catch > " + e.toString();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
               e.printStackTrace();
            }
             pstm = null;
             rs = null;
             cn = null;
        }
        return nom;
    }
}
