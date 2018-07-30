
package m10r.bean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import m10r.model.Venta;
import m10r.dao.VentaAbdA;
import m10r.model.DetalleVenta;
import m10r.model.Producto;

/*
 * @author CSR
 */

@ManagedBean

@ViewScoped

public class VentaBean {
    
    private Venta venta = new Venta();
    private Producto producto = new Producto();
    private List<DetalleVenta> listaDV = new ArrayList();
    private int unidadesVen;
    
    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
    
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<DetalleVenta> getListaDV() {
        return listaDV;
    }

    public void setListaDV(List<DetalleVenta> listaDV) {
        this.listaDV = listaDV;
    }
    
    public int getUnidadesVen() {
        return unidadesVen;
    }

    public void setUnidadesVen(int unidadesVen) {
        this.unidadesVen = unidadesVen;
    }
    
    public void agregarProducto(){
    
        DetalleVenta detVen = new DetalleVenta();
        detVen.setUnidadesVendidas(unidadesVen);
        detVen.setProducto(producto);
        this.listaDV.add(detVen);
    
    }
    
    public void ingresarVenta() throws Exception{
    
        VentaAbdA daoVenta;
        float totalVenta = 0;
        float totalDescuentoVenta = 0;
        
        try{
            for(DetalleVenta detVen : listaDV){
                totalVenta += detVen.getProducto().getValorVentaProducto();
                totalDescuentoVenta = totalVenta;
            }
            daoVenta = new VentaAbdA();
            venta.setTotalVenta(totalVenta);
            venta.setTotalDescuentoVenta(totalDescuentoVenta);
            ///venta.setFechaVenta()
            daoVenta.ingresarVenta(venta, listaDV);
        }
        catch (Exception e){
            throw e;
        }
    }

}