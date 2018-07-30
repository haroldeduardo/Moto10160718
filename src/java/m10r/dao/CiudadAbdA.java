
package m10r.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import m10r.model.Ciudad;

/*
 * @author CSR
 */

public class CiudadAbdA extends AbdA{
    
    public List<Ciudad> reporteCiudades() throws Exception{
        
        List<Ciudad> reportesCiudad;
        ResultSet rs;
        
        try{
            this.Conectar();
            PreparedStatement st = this.getCnt().prepareCall("SELECT idCiudad, nombreCiudad FROM CIUDAD");
            rs = st.executeQuery();
            reportesCiudad = new ArrayList();
            while(rs.next()){
                Ciudad Ciu = new Ciudad();
                Ciu.setIdCiudad(rs.getInt("idCiudad"));
                Ciu.setNombreCiudad(rs.getString("nombreCiudad"));
                reportesCiudad.add(Ciu);
            }
        }
        catch (Exception e){
            throw e;
        }
        finally{
            this.Desconectar();
        }
        return reportesCiudad;
    }
    
}