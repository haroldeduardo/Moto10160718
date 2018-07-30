
package m10r.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import m10r.model.UbicacionProducto;

/*
 * @author CSR
 */

public class UbicacionProductoAbdA extends AbdA{
    
    public List<UbicacionProducto> reporteUbicacionesProducto() throws Exception{
        
        List<UbicacionProducto> reportesUbicacionProducto;
        ResultSet rs;
        
        try{
            this.Conectar();
            PreparedStatement st = this.getCnt().prepareCall("SELECT idUbicacionProducto, descripcionUbicacionPro FROM UBICACIONPRODUCTO");
            rs = st.executeQuery();
            reportesUbicacionProducto = new ArrayList();
            while(rs.next()){
                UbicacionProducto Ubi = new UbicacionProducto();
                Ubi.setIdUbicacionProducto(rs.getInt("idUbicacionProducto"));
                Ubi.setDescripcionUbicacionPro(rs.getString("descripcionUbicacionPro"));
                reportesUbicacionProducto.add(Ubi);
            }
        }
        catch (Exception e){
            throw e;
        }
        finally{
            this.Desconectar();
        }
        return reportesUbicacionProducto;
    }
    
}