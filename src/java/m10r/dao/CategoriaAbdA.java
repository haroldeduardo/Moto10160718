
package m10r.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import m10r.model.Categoria;

/*
 * @author CSR
 */

public class CategoriaAbdA extends AbdA{
 
    public void ingresarCategoria (Categoria Cat) throws Exception{
    
        try{
            this.Conectar();
            PreparedStatement st = this.getCnt().prepareStatement("INSERT INTO CATEGORIA (nombreCategoria, descripcionCategoria) VALUES (?,?)");
            st.setString(1, Cat.getNombreCategoria());
            st.setString(2, Cat.getDescripcionCategoria());
            st.executeUpdate();
        }
        catch (Exception e){
            throw e;   
        }
        finally{
            this.Desconectar();
        }
    }
     
    public Categoria buscarCategoria(Categoria Cat) throws Exception{
    
        Categoria cats = null;
        ResultSet rs;
        
        try{
            this.Conectar();
            PreparedStatement st = this.getCnt().prepareStatement("SELECT idCategoria, nombreCategoria, descripcionCategoria FROM CATEGORIA WHERE idCategoria = ?");
            st.setInt(1, Cat.getIdCategoria());
            rs = st.executeQuery();
            while(rs.next()){
                cats = new Categoria();
                cats.setIdCategoria(rs.getInt("idCategoria"));
                cats.setNombreCategoria(rs.getString("nombreCategoria"));
                cats.setDescripcionCategoria(rs.getString("descripcionCategoria"));
            }
        }
        catch (Exception e){
            throw e;   
        }
        finally{
            this.Desconectar();
        }
        return cats;
    }
    
    public void modificarCategoria (Categoria Cat) throws Exception{
    
        try{
            this.Conectar();
            PreparedStatement st = this.getCnt().prepareStatement("UPDATE CATEGORIA SET nombreCategoria = ?, descripcionCategoria = ? WHERE idCategoria = ?");
            st.setString(1, Cat.getNombreCategoria());
            st.setString(2, Cat.getDescripcionCategoria());
            st.setInt(3, Cat.getIdCategoria());
            st.executeUpdate();
        }
        catch (Exception e){
            throw e;   
        }
        finally{
            this.Desconectar();
        }
    }
    
    public void eliminarCategoria (Categoria Cat) throws Exception{
    
        try{
            this.Conectar();
            PreparedStatement st = this.getCnt().prepareStatement("DELETE FROM CATEGORIA WHERE idCategoria = ?");
            st.setInt(1, Cat.getIdCategoria());
            st.executeUpdate();
        }
        catch (Exception e){
            throw e;   
        }
        finally{
            this.Desconectar();
        }
    }
    
    public List<Categoria> reporteCategorias() throws Exception{
        
        List<Categoria> reportesCategoria;
        ResultSet rs;
        
        try{
            this.Conectar();
            PreparedStatement st = this.getCnt().prepareCall("SELECT idCategoria, nombreCategoria, descripcionCategoria FROM CATEGORIA");
            rs = st.executeQuery();
            reportesCategoria = new ArrayList();
            while(rs.next()){
                Categoria Cat = new Categoria();
                Cat.setIdCategoria(rs.getInt("idCategoria"));
                Cat.setNombreCategoria(rs.getString("nombreCategoria"));
                Cat.setDescripcionCategoria(rs.getString("descripcionCategoria"));
                reportesCategoria.add(Cat);
            }
        }
        catch (Exception e){
            throw e;
        }
        finally{
            this.Desconectar();
        }
        return reportesCategoria;
    }
    
}