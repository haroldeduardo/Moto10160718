
package m10r.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import m10r.dao.CiudadAbdA;
import m10r.model.Ciudad;

/*
 * @author CSR
 */

@ManagedBean

@ViewScoped

public class CiudadBean{
    
    private Ciudad ciudad = new Ciudad();
    private List<Ciudad> lstCiudades;
    
    public List<Ciudad> getLstCiudades() {
        return lstCiudades;
    }

    public void setLstCiudades(List<Ciudad> lstCiudades) {
        this.lstCiudades = lstCiudades;
    }
    
    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
    
    public void reporteCiudades() throws Exception {
        
        CiudadAbdA Dao;
        
        try{
            Dao = new CiudadAbdA();
            lstCiudades = Dao.reporteCiudades();
        }
        catch(Exception e){
        throw e;
        }
    }
    
}