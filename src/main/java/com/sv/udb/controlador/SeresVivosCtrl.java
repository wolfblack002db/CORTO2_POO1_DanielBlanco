/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;
import com.sv.udb.modelo.ModeloSeres;
import com.sv.udb.recursos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Estudiante
 */
public class SeresVivosCtrl {
    private Connection conn;

    public SeresVivosCtrl() {
    }
    
    public boolean guar(String nomb_sere, String desc_sere, ModeloSeres codi_refe_sere)
    {
        boolean resp = false;
        this.conn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = this.conn.prepareStatement("INSERT INTO seresvivos VALUES(NULL,?,?,?)");
            cmd.setString(1, nomb_sere);
            cmd.setString(2, desc_sere);
            cmd.setInt(3, codi_refe_sere.getCodi_sere());
            cmd.executeUpdate();
            resp=true;
        }
        catch (SQLException ex)
        {
            System.err.println("Error al guardar Seres Vivos " + ex.getMessage());
        }
        finally
        {
            try
            {
                if(this.conn != null)
                {
                    if(!this.conn.isClosed())
                    {
                        this.conn.close();
                    }
                }
            }
            catch(SQLException ex)
            {
                System.err.println("Error al cerrar la conexión");
            }
        }
        return resp;
    }
    
    public List<ModeloSeres> consTodo()
    {
       List<ModeloSeres> resp = new ArrayList<>();
       this.conn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = this.conn.prepareStatement("SELECT j.codi_sere, j.nomb_sere, "
                    + "j.desc_sere, e.* FROM seresvivos j INNER JOIN seresvivos e "
                    + "ON j.codi_sere = e.codi_refe_sere");
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                resp.add(new ModeloSeres(rs.getInt(4), rs.getString(5),rs.getString(6),
                        new ModeloSeres(rs.getInt(1),rs.getString(2), rs.getString(3))));
            }
        }
        catch(SQLException ex)
        {
            System.err.println("Error al consultar Seres vivos " + ex.getMessage());
        }
        finally
        {
            try
            {
                if(this.conn != null)
                {
                    if(!this.conn.isClosed())
                    {
                        this.conn.close();
                    }
                }
            }
            catch(SQLException ex)
            {
                System.err.println("Error al cerrar la conexión");
            }
        }
        return resp;
    }
    
    public List<ModeloSeres> obtenerTodo(){
        List<ModeloSeres> resp = new ArrayList<>();
        this.conn = new Conexion().getConn();
        try {
            PreparedStatement cmd = this.conn.prepareStatement("SELECT * FROM seresvivos");
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                resp.add(new ModeloSeres(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al consultar: " + ex.getMessage());
        } finally {
            try {
                if (this.conn != null) {
                    if (!this.conn.isClosed()) {
                        this.conn.close();
                    }
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión");
            }
        }
        return resp;
    }
    
    public boolean modificar(int id_sere, String nomb, String desc, ModeloSeres id_sere_refe){
        boolean resp = false;
        
        try {
            PreparedStatement cmd = this.conn.prepareStatement("UPDATE seresvivos SET nomb_sere = ?, desc_sere=?, codi_refe_sere=? WHERE codi_sere=?");
            cmd.setString(1, nomb);
            cmd.setString(2, desc);
            cmd.setInt(3, id_sere_refe.getCodi_sere());
            cmd.setInt(3, id_sere);
            cmd.executeUpdate();
            resp = true;
        } catch (Exception ex) {
            System.err.println("Error al modificar seres vivos" + ex.getMessage());
        } finally {
            try {
                if (this.conn != null) {
                    if (!this.conn.isClosed()) {
                        this.conn.close();
                    }
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexion en equipos: " + e.getMessage());
            }
        }
        
        return resp;
    }
    
    public boolean eliminar(int id){
        boolean resp = false;
        
        try {
            PreparedStatement cmd = this.conn.prepareStatement("DELETE FROM equipos WHERE codi_equi = ?");
            cmd.setInt(1, id);
            cmd.executeUpdate();
            resp = true;
        } catch (Exception ex) {
            System.err.println("Error al eliminar equipos" + ex.getMessage());
        } finally {
            try {
                if (this.conn != null) {
                    if (!this.conn.isClosed()) {
                        this.conn.close();
                    }
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexion en equipos: " + e.getMessage());
            }
        }
        
        return resp;
    }
}
