
package m10r.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import m10r.model.PresentacionProducto;

/*
 * @author CSR
 */

public class PresentacionProductoAbdA extends AbdA{
    
    public List<PresentacionProducto> reportePresentacionesProducto() throws Exception{
        
        List<PresentacionProducto> reportesPresentacionProducto;
        ResultSet rs;
        
        try{
            this.Conectar();
            PreparedStatement st = this.getCnt().prepareCall("SELECT idPresentacionProducto, descripcionPresentacionPro FROM PRESENTACIONPRODUCTO");
            rs = st.executeQuery();
            reportesPresentacionProducto = new ArrayList();
            while(rs.next()){
                PresentacionProducto Pre = new PresentacionProducto();
                Pre.setIdPresentacionProducto(rs.getInt("idPresentacionProducto"));
                Pre.setDescripcionPresentacionPro(rs.getString("descripcionPresentacionPro"));
                reportesPresentacionProducto.add(Pre);
            }
        }
        catch (Exception e){
            throw e;
        }
        finally{
            this.Desconectar();
        }
        return reportesPresentacionProducto;
    }
    
}