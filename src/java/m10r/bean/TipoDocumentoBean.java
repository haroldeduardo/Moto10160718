/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m10r.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import m10r.dao.TipoDocumentoAbdA;
import m10r.model.TipoDocumento;

/*
 *@author CSR
 */

@ManagedBean

@ViewScoped

public class TipoDocumentoBean{
    
    private TipoDocumento tipoDocumento = new TipoDocumento();
    private List<TipoDocumento> lstTipoDocumentos;
    
    public List<TipoDocumento> getLstTipoDocumentos() {
        return lstTipoDocumentos;
    }

    public void setLstTipoDocumentos(List<TipoDocumento> lstTipoDocumentos) {
        this.lstTipoDocumentos = lstTipoDocumentos;
    }
    
    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
    
    public void reporteTipoDocumentos() throws Exception {
        
        TipoDocumentoAbdA Dao;
        
        try{
            Dao = new TipoDocumentoAbdA();
            lstTipoDocumentos = Dao.reporteTipoDocumentos();
        }
        catch(Exception e){
        throw e;
        }
    }
    
}