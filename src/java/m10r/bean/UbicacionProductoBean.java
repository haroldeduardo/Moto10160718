
package m10r.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import m10r.dao.UbicacionProductoAbdA;
import m10r.model.UbicacionProducto;

/*
 * @author CSR
 */

@ManagedBean

@ViewScoped

public class UbicacionProductoBean {
    
    private UbicacionProducto ubicacionProducto = new UbicacionProducto();
    private List<UbicacionProducto> lstUbicacionesProducto;
    
    public List<UbicacionProducto> getLstUbicacionesProducto() {
        return lstUbicacionesProducto;
    }

    public void setLstUbicacionesProducto(List<UbicacionProducto> lstUbicacionesProducto) {
        this.lstUbicacionesProducto = lstUbicacionesProducto;
    }
    
    public UbicacionProducto getUbicacionProducto() {
        return ubicacionProducto;
    }

    public void setUbicacionProducto(UbicacionProducto ubicacionProducto) {
        this.ubicacionProducto = ubicacionProducto;
    }
    
    public void reporteUbicacionesProducto() throws Exception {
        
        UbicacionProductoAbdA Dao;
        
        try{
            Dao = new UbicacionProductoAbdA();
            lstUbicacionesProducto = Dao.reporteUbicacionesProducto();
        }
        catch(Exception e){
        throw e;
        }
    }
    
}