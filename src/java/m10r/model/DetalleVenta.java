
package m10r.model;

/*
 * @author CSR
 */

public class DetalleVenta {
    
    private int idDetalleVenta;
    private Venta venta;
    private Producto producto;
    private float valorVentaProducto;
    private String IVA;
///    private float descuentoProducto;
    private int unidadesVendidas;

    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

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

    public float getValorVentaProducto() {
        return valorVentaProducto;
    }

    public void setValorVentaProducto(float valorVentaProducto) {
        this.valorVentaProducto = valorVentaProducto;
    }

    public String getIVA() {
        return IVA;
    }

    public void setIVA(String IVA) {
        this.IVA = IVA;
    }

//    public float getDescuentoProducto() {
//        return descuentoProducto;
//    }
//
//    public void setDescuentoProducto(float descuentoProducto) {
//        this.descuentoProducto = descuentoProducto;
//    }

    public int getUnidadesVendidas() {
        return unidadesVendidas;
    }

    public void setUnidadesVendidas(int unidadesVendidas) {
        this.unidadesVendidas = unidadesVendidas;
    }

}