
package m10r.bean;

import java.util.List;
import m10r.model.Categoria;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import m10r.dao.CategoriaAbdA;

/*
 * @author CSR
 */

@ManagedBean

@ViewScoped

public class CategoriaBean {

    private Categoria categoria = new Categoria();
    private List<Categoria> lstCategorias;
    private String accionBotonCategoria;

    public String getAccionBotonCategoria() {
        return accionBotonCategoria;
    }

    public void setAccionBotonCategoria(String accionBotonCategoria) {
        this.cleanCategoria();
        this.accionBotonCategoria = accionBotonCategoria;
    }

    public List<Categoria> getLstCategorias() {
        return lstCategorias;
    }

    public void setLstCategorias(List<Categoria> lstCategorias) {
        this.lstCategorias = lstCategorias;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    private boolean isPostBack() {

        boolean rpta;
        rpta = FacesContext.getCurrentInstance().isPostback();
        return rpta;
    }

    public void ingresarCategoria() throws Exception {
        CategoriaAbdA Dao;

        try {
            Dao = new CategoriaAbdA();
            Dao.ingresarCategoria(categoria);
            this.reporteCategorias("V");
        } catch (Exception e) {
            throw e;
        }
    }

    public void buscarCategoria(Categoria Cat) throws Exception {

        CategoriaAbdA Dao;
        Categoria temp;

        try {
            Dao = new CategoriaAbdA();
            temp = Dao.buscarCategoria(Cat);

            if (temp != null) {
                this.categoria = temp;
                this.accionBotonCategoria = "Modificar";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarCategoria() throws Exception {
        CategoriaAbdA Dao;

        try {
            Dao = new CategoriaAbdA();
            Dao.modificarCategoria(categoria);
            this.reporteCategorias("V");
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarCategoria(Categoria Cat) throws Exception {
        CategoriaAbdA Dao;

        try {
            Dao = new CategoriaAbdA();
            Dao.eliminarCategoria(Cat);
            this.reporteCategorias("V");
        } catch (Exception e) {
            throw e;
        }
    }

    public void reporteCategorias(String Valor) throws Exception {

        CategoriaAbdA Dao;

        try {
            if (Valor.equals("F")) {
                if (isPostBack() == false) {
                    Dao = new CategoriaAbdA();
                    lstCategorias = Dao.reporteCategorias();
                }

            } else {
                Dao = new CategoriaAbdA();
                lstCategorias = Dao.reporteCategorias();
            }

        } catch (Exception e) {
            throw e;
        }
    }

    public void operarAccionBotonCategoria() throws Exception {

        switch (accionBotonCategoria) {

            case "Guardar":
                this.ingresarCategoria();
                this.cleanCategoria();
                break;
            case "Modificar":
                this.modificarCategoria();
                this.cleanCategoria();
                break;
        }
    }

    public void cleanCategoria() {

        this.categoria.setIdCategoria(0);
        this.categoria.setNombreCategoria("");
        this.categoria.setDescripcionCategoria("");
    }

}
