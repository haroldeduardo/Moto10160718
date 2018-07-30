
package m10r.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import m10r.model.TipoTransaccion;

/*
 * @author CSR
 */

public class TipoTransaccionAbdA extends AbdA{
    
    public List<TipoTransaccion> reporteTipoTransacciones() throws Exception{
        
        List<TipoTransaccion> reportesTipoTransaccion;
        ResultSet rs;
        
        try{
            this.Conectar();
            PreparedStatement st = this.getCnt().prepareCall("SELECT idTipoTransaccion, descripcionTransaccion FROM TIPOTRANSACCION");
            rs = st.executeQuery();
            reportesTipoTransaccion = new ArrayList();
            while(rs.next()){
                TipoTransaccion Tra = new TipoTransaccion();
                Tra.setIdTipoTransaccion(rs.getInt("idTipoTransaccion"));
                Tra.setDescripcionTransaccion(rs.getString("descripcionTransaccion"));
                reportesTipoTransaccion.add(Tra);
            }
        }
        catch (Exception e){
            throw e;
        }
        finally{
            this.Desconectar();
        }
        return reportesTipoTransaccion;
    }
    
}