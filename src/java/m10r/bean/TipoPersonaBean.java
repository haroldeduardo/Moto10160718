
package m10r.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import m10r.dao.TipoPersonaAbdA;
import m10r.model.TipoPersona;

/*
 *@author CSR
 */

@ManagedBean

@ViewScoped

public class TipoPersonaBean{
    
    private TipoPersona tipoPersona = new TipoPersona();
    private List<TipoPersona> lstTipoPersonas;
    
    public List<TipoPersona> getLstTipoPersonas() {
        return lstTipoPersonas;
    }

    public void setLstTipoPersonas(List<TipoPersona> lstTipoPersonas) {
        this.lstTipoPersonas = lstTipoPersonas;
    }
    
    public TipoPersona getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(TipoPersona tipoPersona) {
        this.tipoPersona = tipoPersona;
    }
    
    public void reporteTipoPersonas() throws Exception {
        
        TipoPersonaAbdA Dao;
        
        try{
            Dao = new TipoPersonaAbdA();
            lstTipoPersonas = Dao.reporteTipoPersonas();
        }
        catch(Exception e){
        throw e;
        }
    }
    
}