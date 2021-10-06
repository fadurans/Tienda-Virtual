/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import persistencia.ConexionBD;

/**
 *
 * @author RICHERD ANGARITA
 */
public class Contacto {
    private int identificacion;
    private String nombre;
    private String apellido;
    private String genero;
    private String tipoIdentificaion;
    private String telefono;
    private String direccion;
    private String correo;
    
 public Contacto(){
 
 } 

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTipoIdentificaion() {
        return tipoIdentificaion;
    }

    public void setTipoIdentificaion(String tipoIdentificaion) {
        this.tipoIdentificaion = tipoIdentificaion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
 public boolean guardarContacto(){
     ConexionBD conexion =new ConexionBD();
     String sentencia= "INSERT INTO contactos(identificacion,nombre,apellido,genero,tipoIdentificacion,telefono,direccion,correo)"
             + "VALUES('"+this.identificacion+"','"+this.nombre+"',"
             + "'"+this.apellido+"','"+this.genero+"','"+this.tipoIdentificaion+"',"
             + "'"+this.telefono+"','"+this.direccion+"','"+this.correo+"'); ";
 if(conexion.setAutoCommitBD(false)){
     if(conexion.insertarBD(sentencia)){
      conexion.commitBD();
      conexion.cerrarConexion();
      return true;
     }else{
      conexion.rollbackBD();
      conexion.cerrarConexion();
      return false;        
     }
 
 }else{
 conexion.cerrarConexion();
 return false;
 }
 }
 
 public boolean borrarContacto(int identificacion){
 String sentencia ="DELETE FROM `contactos` WHERE `identificaion`='"+identificacion+"'";
 ConexionBD conexion = new ConexionBD();
 if(conexion.setAutoCommitBD(false)){
     if(conexion.actualizarBD(sentencia)){
      conexion.commitBD();
      conexion.cerrarConexion();
      return true;
     }else{
      conexion.rollbackBD();
      conexion.cerrarConexion();
      return false;        
     }
 
 }else{
 conexion.cerrarConexion();
 return false;
 }
 }
 
 public boolean actualizarContacto(){
 ConexionBD conexion =new ConexionBD();
     String sentencia= "UPDATE `contactos`SET nombre='"+this.nombre+"',apellido='"+this.apellido+"',genero="
             + "'"+this.genero+"',tipoIdentificacion='"+this.tipoIdentificaion+"',telefono='"+this.telefono+"',direccion="
             + "'"+this.direccion+"',correo='"+this.correo+"' WHERE identificacion="+this.identificacion+"; ";
 if(conexion.setAutoCommitBD(false)){
     if(conexion.actualizarBD(sentencia)){
      conexion.commitBD();
      conexion.cerrarConexion();
      return true;
     }else{
      conexion.rollbackBD();
      conexion.cerrarConexion();
      return false;        
     }
 
 }else{
 conexion.cerrarConexion();
 return false;
 }
 }
 
 public List<Contacto> listarcontactos() throws SQLException{
 ConexionBD conexion =new ConexionBD();
 List<Contacto> listacontactos=new ArrayList<>();
 String sql="select * from contactos ordes by identification asc";
     ResultSet rs=conexion.consultarBD(sql);
     Contacto c;
     while (rs.next()){
     c=new Contacto();
     c.setIdentificacion(rs.getInt("identificacion"));
     c.setNombre(rs.getString("nombre"));
     c.setApellido(rs.getString("apellido"));
     c.setGenero(rs.getString("genero"));
     c.setTipoIdentificaion(rs.getString("tipoIdentificacion"));
     c.setTelefono(rs.getString("telefono"));
     c.setDireccion(rs.getString("direccion"));
     c.setCorreo(rs.getString("correo"));
     listacontactos.add(c);
     }
     conexion.cerrarConexion();
     return listacontactos;
 }
 
 public Contacto getContacto() throws SQLException{
 ConexionBD conexion =new ConexionBD();
 String sql="select * from contactos where identification='"+this.identificacion+"'";
 ResultSet rs =conexion.consultarBD(sql);
 if(rs.next()){
 this.identificacion=(rs.getInt("identificacion"));
     this.nombre=(rs.getString("nombre"));
     this.apellido=(rs.getString("apellido"));
     this.genero=(rs.getString("genero"));
     this.tipoIdentificaion=(rs.getString("tipoIdentificacion"));
     this.telefono=(rs.getString("telefono"));
     this.direccion=(rs.getString("direccion"));
     this.correo=(rs.getString("correo"));
     conexion.cerrarConexion();
     return this;
 }else{
 conexion.cerrarConexion();
 return null;
 }
 }

    @Override
    public String toString() {
        return "Contacto{" + "identificacion=" + identificacion + ", nombre=" + nombre + ", apellido=" + apellido + ", genero=" + genero + ", tipoIdentificaion=" + tipoIdentificaion + ", telefono=" + telefono + ", direccion=" + direccion + ", correo=" + correo + '}';
    }
 
 
 
}
