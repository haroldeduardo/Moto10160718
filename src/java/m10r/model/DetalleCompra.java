
package m10r.model;

/*
 * @author CSR
 */

public class DetalleCompra {
    
    private int idDetalleCompra;
    private Compra venta;
    private Producto producto;
    private float valorCompraPdcto;
    private float valorVentaPdcto;
    private int unidadesCompradas;

    public int getIdDetalleCompra() {
        return idDetalleCompra;
    }

    public void setIdDetalleCompra(int idDetalleCompra) {
        this.idDetalleCompra = idDetalleCompra;
    }

    public Compra getVenta() {
        return venta;
    }

    public void setVenta(Compra venta) {
        this.venta = venta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public float getValorCompraPdcto() {
        return valorCompraPdcto;
    }

    public void setValorCompraPdcto(float valorCompraPdcto) {
        this.valorCompraPdcto = valorCompraPdcto;
    }

    public float getValorVentaPdcto() {
        return valorVentaPdcto;
    }

    public void setValorVentaPdcto(float valorVentaPdcto) {
        this.valorVentaPdcto = valorVentaPdcto;
    }

    public int getUnidadesCompradas() {
        return unidadesCompradas;
    }

    public void setUnidadesCompradas(int unidadesCompradas) {
        this.unidadesCompradas = unidadesCompradas;
    }

}