
package m10r.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import m10r.dao.PresentacionProductoAbdA;
import m10r.model.PresentacionProducto;

/*
 *@author CSR
 */

@ManagedBean

@ViewScoped

public class PresentacionProductoBean {
    
    private PresentacionProducto presentacionProducto = new PresentacionProducto();
    private List<PresentacionProducto> lstPresentacionesProducto;
    
    public List<PresentacionProducto> getLstPresentacionesProducto() {
        return lstPresentacionesProducto;
    }

    public void setLstPresentacionesProducto(List<PresentacionProducto> lstPresentacionesProducto) {
        this.lstPresentacionesProducto = lstPresentacionesProducto;
    }
    
    public PresentacionProducto getPresentacionProducto() {
        return presentacionProducto;
    }

    public void setPresentacionProducto(PresentacionProducto presentacionProducto) {
        this.presentacionProducto = presentacionProducto;
    }
    
    public void reportePresentacionesProducto() throws Exception {
        
        PresentacionProductoAbdA Dao;
        
        try{
            Dao = new PresentacionProductoAbdA();
            lstPresentacionesProducto = Dao.reportePresentacionesProducto();
        }
        catch(Exception e){
        throw e;
        }
    }
    
}