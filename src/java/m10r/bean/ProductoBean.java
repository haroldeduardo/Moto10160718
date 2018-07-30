
package m10r.bean;

import java.util.List;
import m10r.model.Producto;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import m10r.dao.ProductoAbdA;

/*
 * @author CSR
 */

@ManagedBean

@ViewScoped

public class ProductoBean {
    
    private Producto producto = new Producto();
    private List<Producto> lstProductos;
    private String accionBotonProducto;

    public String getAccionBotonProducto() {
        return accionBotonProducto;
    }

    public void setAccionBotonProducto(String accionBotonProducto) {
        this.cleanProducto();
        this.accionBotonProducto = accionBotonProducto;
    }
    
    public List<Producto> getLstProductos() {
        return lstProductos;
    }

    public void setLstProductos(List<Producto> lstProductos) {
        this.lstProductos = lstProductos;
    }
    
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    private boolean isPostBack() {

        boolean rpta;
        rpta = FacesContext.getCurrentInstance().isPostback();
        return rpta;
    }
    
    public void ingresarProducto() throws Exception {
        ProductoAbdA Dao;
        
        try{
            Dao = new ProductoAbdA();
            Dao.ingresarProducto(producto);
            this.reporteProductos("V");
        }
        catch(Exception e){
        throw e;
        }
    }
    
    public void buscarProducto(Producto Pro) throws Exception{
        
        ProductoAbdA Dao;
        Producto temp;
        
        try{
            Dao = new ProductoAbdA();
            temp = Dao.buscarProducto(Pro);
            
            if (temp != null){
                this.producto = temp;
                this.accionBotonProducto = "Modificar";
            }
        }
        catch(Exception e){
        throw e;
        }
    }
    
    public void modificarProducto() throws Exception {
        ProductoAbdA Dao;
        
        try{
            Dao = new ProductoAbdA();
            Dao.modificarProducto(producto);
            this.reporteProductos("V");
        }
        catch(Exception e){
        throw e;
        }
    }
    
    public void eliminarProducto(Producto Pro) throws Exception {
        ProductoAbdA Dao;
        
        try{
            Dao = new ProductoAbdA();
            Dao.eliminarProducto(Pro);
            this.reporteProductos("V");
        }
        catch(Exception e){
        throw e;
        }
    }
    
    public void reporteProductos(String Valor) throws Exception {

        ProductoAbdA Dao;

        try {
            if (Valor.equals("F")) {
                if (isPostBack() == false) {
                    Dao = new ProductoAbdA();
                    lstProductos = Dao.reporteProductos();
                }

            } else {
                Dao = new ProductoAbdA();
                lstProductos = Dao.reporteProductos();
            }

        } catch (Exception e) {
            throw e;
        }
    }
    
    public void operarAccionBotonProducto() throws Exception{
    
        switch (accionBotonProducto){
        
            case "Guardar":
                this.ingresarProducto();
                this.cleanProducto();
                break;
            case "Modificar":
                this.modificarProducto();
                this.cleanProducto();
                break;
        }
    }
    
    public void cleanProducto(){
        
        this.producto.setIdProducto(0);
        this.producto.setCodigoProducto("");
        this.producto.setNombreProducto("");
        this.producto.setDescripcionProducto("");
        this.producto.setStockProducto(0);
        this.producto.setValorCompraProducto(0);
        this.producto.setValorVentaProducto(0);
        this.producto.setIVA("");
        this.producto.setIdCategoria(0);
        this.producto.setIdPresentacionProducto(0);
        this.producto.setIdUbicacionProducto(0);
    }
    
}