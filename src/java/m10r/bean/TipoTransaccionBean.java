
package m10r.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import m10r.model.TipoTransaccion;
import m10r.dao.TipoTransaccionAbdA;

/*
 * @author CSR
 */

@ManagedBean

@ViewScoped

public class TipoTransaccionBean{
    
    private TipoTransaccion tipoTransaccion = new TipoTransaccion();
    private List<TipoTransaccion> lstTipoTransacciones;
    
    public List<TipoTransaccion> getLstTipoTransacciones() {
        return lstTipoTransacciones;
    }

    public void setLstTipoTransacciones(List<TipoTransaccion> lstTipoTransacciones) {
        this.lstTipoTransacciones = lstTipoTransacciones;
    }
    
    public TipoTransaccion getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }
    
    public void reporteTipoTransacciones() throws Exception {
        
        TipoTransaccionAbdA Dao;
        
        try{
            Dao = new TipoTransaccionAbdA();
            lstTipoTransacciones = Dao.reporteTipoTransacciones();
        }
        catch(Exception e){
        throw e;
        }
    }
    
}