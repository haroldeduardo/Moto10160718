
package m10r.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import m10r.model.TipoDocumento;

/*
 * @author CSR
 */

public class TipoDocumentoAbdA extends AbdA{
    
    public List<TipoDocumento> reporteTipoDocumentos() throws Exception{
        
        List<TipoDocumento> reportesTipoDocumento;
        ResultSet rs;
        
        try{
            this.Conectar();
            PreparedStatement st = this.getCnt().prepareCall("SELECT idTipoDocumento, descripcionDocumento FROM TIPODOCUMENTO");
            rs = st.executeQuery();
            reportesTipoDocumento = new ArrayList();
            while(rs.next()){
                TipoDocumento Tra = new TipoDocumento();
                Tra.setIdTipoDocumento(rs.getInt("idTipoDocumento"));
                Tra.setDescripcionDocumento(rs.getString("descripcionDocumento"));
                reportesTipoDocumento.add(Tra);
            }
        }
        catch (Exception e){
            throw e;
        }
        finally{
            this.Desconectar();
        }
        return reportesTipoDocumento;
    }
    
}