
package m10r.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import m10r.model.DetalleVenta;
import m10r.model.Venta;

/*
 * @author CSR
 */

public class VentaAbdA extends AbdA {

    public void ingresarVenta(Venta Ven, List<DetalleVenta> listaDV) throws Exception {

        try {
            this.Conectar();
            this.getCnt().setAutoCommit(false);
            PreparedStatement st1 = this.getCnt().prepareStatement("INSERT INTO VENTA (idEmpleado, idPersona, idTipoTransaccion, totalVenta, totalDescuentoVenta) VALUES (?,?,?,?,?)");
            st1.setInt(1, Ven.getEmpleado().getIdEmpleado());
            st1.setInt(2, Ven.getPersona().getIdPersona());
            st1.setInt(3, Ven.getTipoTransaccion().getIdTipoTransaccion());
            st1.setFloat(4, Ven.getTotalVenta());
            st1.setFloat(5, Ven.getTotalDescuentoVenta());
            ///st1.setDate(6, Ven.getFechaVenta());
            st1.executeUpdate();
            st1.close();

            PreparedStatement st2 = this.getCnt().prepareStatement("SELECT idVenta FROM Venta ORDER BY idVenta DESC LIMIT 1");
            ResultSet rs;
            int idVentaLast = 0;
            rs = st2.executeQuery();

            while (rs.next()) {
                idVentaLast = rs.getInt(1);
            }
            rs.close();
            
            for (DetalleVenta detVen : listaDV) {

                PreparedStatement st3 = this.getCnt().prepareStatement("INSERT INTO DETALLEVENTA (idVenta, idProducto, valorVentaProducto, IVA, unidadesVendidas) VALUES (?,?,?,?,?)");
                st3.setInt(1, idVentaLast);
                st3.setInt(2, detVen.getProducto().getIdProducto());
                st3.setFloat(3, detVen.getProducto().getValorVentaProducto());
                st3.setString(4, detVen.getProducto().getIVA());
                st3.setInt(5, detVen.getUnidadesVendidas());
                st3.executeUpdate();
                st3.close();
                
            }
            this.getCnt().commit();
        } catch (Exception e) {
            this.getCnt().rollback();
            throw e;
        } finally {
            this.Desconectar();
        }
    }

}