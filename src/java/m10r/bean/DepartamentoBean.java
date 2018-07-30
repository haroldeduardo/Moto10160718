
package m10r.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import m10r.dao.DepartamentoAbdA;
import m10r.model.Departamento;

/*
 * @author CSR
 */

@ManagedBean

@ViewScoped

public class DepartamentoBean{
    
    private Departamento departamento = new Departamento();
    private List<Departamento> lstDepartamentos;
    
    public List<Departamento> getLstDepartamentos() {
        return lstDepartamentos;
    }

    public void setLstDepartamentos(List<Departamento> lstDepartamentos) {
        this.lstDepartamentos = lstDepartamentos;
    }
    
    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    
    private boolean isPostBack() {

        boolean rpta;
        rpta = FacesContext.getCurrentInstance().isPostback();
        return rpta;
    }
    
    public void reporteDepartamentos() throws Exception {
        
        DepartamentoAbdA Dao;
        
        try{
            Dao = new DepartamentoAbdA();
            lstDepartamentos = Dao.reporteDepartamentos();
        }
        catch(Exception e){
        throw e;
        }
    }
    
}