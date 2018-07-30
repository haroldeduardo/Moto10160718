
package m10r.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import m10r.model.TipoPersona;

/*
 *@author CSR
 */

public class TipoPersonaAbdA extends AbdA{
    
    public List<TipoPersona> reporteTipoPersonas() throws Exception{
        
        List<TipoPersona> reportesTipoPersona;
        ResultSet rs;
        
        try{
            this.Conectar();
            PreparedStatement st = this.getCnt().prepareCall("SELECT idTipoPersona, descripcionPersona FROM TIPOPERSONA");
            rs = st.executeQuery();
            reportesTipoPersona = new ArrayList();
            while(rs.next()){
                TipoPersona Per = new TipoPersona();
                Per.setIdTipoPersona(rs.getInt("idTipoPersona"));
                Per.setDescripcionPersona(rs.getString("descripcionPersona"));
                reportesTipoPersona.add(Per);
            }
        }
        catch (Exception e){
            throw e;
        }
        finally{
            this.Desconectar();
        }
        return reportesTipoPersona;
    }
    
}