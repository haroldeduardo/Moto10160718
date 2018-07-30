
package m10r.bean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import m10r.model.Compra;
import m10r.dao.CompraAbdA;
import m10r.model.DetalleCompra;
import m10r.model.Producto;

/*
 * @author CSR
 */

@ManagedBean

@ViewScoped

public class CompraBean {

    private Compra compra = new Compra();
    private Producto producto = new Producto();
    private List<DetalleCompra> listaDC = new ArrayList();
    private int unidadesCom;
    
    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }
    
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<DetalleCompra> getListaDC() {
        return listaDC;
    }

    public void setListaDC(List<DetalleCompra> listaDC) {
        this.listaDC = listaDC;
    }
    
    public int getUnidadesCom() {
        return unidadesCom;
    }

    public void setUnidadesCom(int unidadesCom) {
        this.unidadesCom = unidadesCom;
    }
    
    public void agregarProducto(){
    
        DetalleCompra detVen = new DetalleCompra();
        detVen.setUnidadesCompradas(unidadesCom);
        detVen.setProducto(producto);
        this.listaDC.add(detVen);
    
    }
    
    public void ingresarCompra() throws Exception{
    
        CompraAbdA daoCompra;
        float totalCompra = 0;
        
        try{
            for(DetalleCompra detVen : listaDC){
                totalCompra += detVen.getProducto().getValorCompraProducto();
            }
            daoCompra = new CompraAbdA();
            compra.setTotalCompra(totalCompra);
            ///compra.setFechaCompra()
            daoCompra.ingresarCompra(compra, listaDC);
        }
        catch (Exception e){
            throw e;
        }
    }
    
}