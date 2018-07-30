
package m10r.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import m10r.model.Producto;

/*
 * @author CSR
 */

public class ProductoAbdA extends AbdA{
 
    public void ingresarProducto (Producto Pro) throws Exception{
    
        try{
            this.Conectar();
            PreparedStatement st = this.getCnt().prepareStatement("INSERT INTO PRODUCTO (codigoProducto, nombreProducto, descripcionProducto, stockProducto, valorCompraProducto, valorVentaProducto, IVA, idCategoria, idPresentacionProducto, idUbicacionProducto) VALUES (?,?,?,?,?,?,?,?,?,?)");
            st.setString(1, Pro.getCodigoProducto());
            st.setString(2, Pro.getNombreProducto());
            st.setString(3, Pro.getDescripcionProducto());
            st.setInt(4, Pro.getStockProducto());
            st.setFloat(5, Pro.getValorCompraProducto());
            st.setFloat(6, Pro.getValorVentaProducto());
            st.setString(7, Pro.getIVA());
            st.setInt(8, Pro.getIdCategoria());
            st.setInt(9, Pro.getIdPresentacionProducto());
            st.setInt(10, Pro.getIdUbicacionProducto());
            st.executeUpdate();
        }
        catch (Exception e){
            throw e;   
        }
        finally{
            this.Desconectar();
        }
    }
    
    public Producto buscarProducto(Producto Pro) throws Exception{
    
        Producto pros = null;
        ResultSet rs;
        
        try{
            this.Conectar();
            PreparedStatement st = this.getCnt().prepareStatement("SELECT idProducto, codigoProducto, nombreProducto, descripcionProducto, stockProducto, valorCompraProducto, valorVentaProducto, IVA, idCategoria, idPresentacionProducto, idUbicacionProducto FROM PRODUCTO WHERE idProducto = ?");
            st.setInt(1, Pro.getIdProducto());
            rs = st.executeQuery();
            while(rs.next()){
                pros = new Producto();
                pros.setIdProducto(rs.getInt("idProducto"));
                pros.setCodigoProducto(rs.getString("codigoProducto"));
                pros.setNombreProducto(rs.getString("nombreProducto"));
                pros.setDescripcionProducto(rs.getString("descripcionProducto"));
                pros.setStockProducto(rs.getInt("stockProducto"));
                pros.setValorCompraProducto(rs.getFloat("valorCompraProducto"));
                pros.setValorVentaProducto(rs.getFloat("valorVentaProducto"));
                pros.setIVA(rs.getString("IVA"));
                pros.setIdCategoria(rs.getInt("idCategoria"));
                pros.setIdPresentacionProducto(rs.getInt("idPresentacionProducto"));
                pros.setIdUbicacionProducto(rs.getInt("idUbicacionProducto"));
            }
        }
        catch (Exception e){
            throw e;   
        }
        finally{
            this.Desconectar();
        }
        return pros;
    }
    
    public void modificarProducto (Producto Pro) throws Exception{
    
        try{
            this.Conectar();
            PreparedStatement st = this.getCnt().prepareStatement("UPDATE PRODUCTO SET codigoProducto = ?, nombreProducto = ?, descripcionProducto = ?, stockProducto = ?, valorCompraProducto = ?, valorVentaProducto = ?, IVA = ?, idCategoria = ?, idPresentacionProducto = ?, idUbicacionProducto = ? WHERE idProducto = ?");
            st.setString(1, Pro.getCodigoProducto());
            st.setString(2, Pro.getNombreProducto());
            st.setString(3, Pro.getDescripcionProducto());
            st.setInt(4, Pro.getStockProducto());
            st.setFloat(5, Pro.getValorCompraProducto());
            st.setFloat(6, Pro.getValorVentaProducto());
            st.setString(7, Pro.getIVA());
            st.setInt(8, Pro.getIdCategoria());
            st.setInt(9, Pro.getIdPresentacionProducto());
            st.setInt(10, Pro.getIdUbicacionProducto());
            st.setInt(11, Pro.getIdProducto());
            st.executeUpdate();
        }
        
        catch (Exception e){
            throw e;   
        }
        finally{
            this.Desconectar();
        }
    }
    
    public void eliminarProducto (Producto Pro) throws Exception{
    
        try{
            this.Conectar();
            PreparedStatement st = this.getCnt().prepareStatement("DELETE FROM PRODUCTO WHERE idProducto = ?");
            st.setInt(1, Pro.getIdProducto());
            st.executeUpdate();
        }
        catch (Exception e){
            throw e;   
        }
        finally{
            this.Desconectar();
        }
    }
    
    public List<Producto> reporteProductos() throws Exception{
        
        List<Producto> reportesProducto;
        ResultSet rs;
        
        try{
            this.Conectar();
            PreparedStatement st = this.getCnt().prepareCall("SELECT idProducto, codigoProducto, nombreProducto, descripcionProducto, stockProducto, valorCompraProducto, valorVentaProducto, IVA, idCategoria, idPresentacionProducto, idUbicacionProducto FROM PRODUCTO");
            rs = st.executeQuery();
            reportesProducto = new ArrayList();
            while(rs.next()){
                Producto Pro = new Producto();
                Pro.setIdProducto(rs.getInt("idProducto"));
                Pro.setCodigoProducto(rs.getString("codigoProducto"));
                Pro.setNombreProducto(rs.getString("nombreProducto"));
                Pro.setDescripcionProducto(rs.getString("descripcionProducto"));
                Pro.setStockProducto(rs.getInt("stockProducto"));
                Pro.setValorCompraProducto(rs.getFloat("valorCompraProducto"));
                Pro.setValorVentaProducto(rs.getFloat("valorVentaProducto"));
                Pro.setIVA(rs.getString("IVA"));
                Pro.setIdCategoria(rs.getInt("idCategoria"));
                Pro.setIdPresentacionProducto(rs.getInt("idPresentacionProducto"));
                Pro.setIdUbicacionProducto(rs.getInt("idUbicacionProducto"));
                reportesProducto.add(Pro);
            }
        }
        catch (Exception e){
            throw e;
        }
        finally{
            this.Desconectar();
        }
        return reportesProducto;
    }
    
}