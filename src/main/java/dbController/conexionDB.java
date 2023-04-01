/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbController;

import entity.Alquiler;
import entity.Automovil;
import entity.Cliente;
import java.sql.*;

public class conexionDB {
    
    private static Connection connection = null;
    
    String user = "quisoftc_alquilerAutos";
    String pass = "9EW314zuJ8";
    String url  = "jdbc:mysql://quisoft.com.co/quisoftc_alquilerAutos";
    public void abrirConexcion() throws ClassNotFoundException {
            
            try{
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(url, user,pass);
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
    }
    
    public void cierraConexion() {
        try {
        connection.close();
        }catch(SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
    }
    
    public Boolean insertDbClientes(Cliente cliente) throws SQLException, ClassNotFoundException{
        try {
        abrirConexcion();
        Statement s = connection.createStatement(); 
        String query = "INSERT INTO clientes (numeroDocumento, nombres, apellidos, numeroContacto, direccion) "
                + "VALUES ( " + cliente.getNumeroDocumento() + ",'" + cliente.getNombre()+ "','" +  cliente.getApellido() + "','" + cliente.getNumeroContacto()+ "','" + cliente.getDireccion() + "');";
        s.executeUpdate(query); 
        cierraConexion();
        return true;
        }catch(SQLException sqle) {
            System.out.println(sqle.getMessage());
            return false;
        }
        
    }
    
    public Boolean insertDbAutomovil(Automovil automovil) throws ClassNotFoundException{
        try {
        abrirConexcion();
        Statement s1 = connection.createStatement(); 
        String query = "INSERT INTO automoviles ( marca, linea, placa) VALUES ( '" + automovil.getMarca() + "','" + automovil.getLinea()+ "','" +  automovil.getPlaca() + "');";
        s1.executeUpdate(query);
        connection.close();
        return true;
        }catch(SQLException sqle) {
            System.out.println(sqle.getMessage());
        return false;
        }
    }
    
    public Boolean insertDbAlquiler(Alquiler alquiler) throws ClassNotFoundException{
        try {
        abrirConexcion();
        Statement s1 = connection.createStatement(); 
        String query = "INSERT INTO alquiler ( idcliente, idAutomoviles) VALUES ( " + alquiler.getIdCliente()+ "," + alquiler.getIdAutomoviles()+");";
        s1.executeUpdate(query);
        connection.close();
        return true;
        }catch(SQLException sqle) {
            System.out.println(sqle.getMessage());
        return false;
        }
    }
        
    public void consultarAutomoviles() throws ClassNotFoundException{
        Automovil automovil = new Automovil();
         try {
        abrirConexcion();
        Statement s = connection.createStatement(); 
        String query = "SELECT * FROM automoviles";
        ResultSet r = s.executeQuery(query);
        while(r.next()){
           System.out.println("idAutomovil: " + r.getInt("id") + " Marca: " + r.getString("marca") + " Linea: " + r.getString("linea") + " Placa: " + r.getString("placa"));
        }
        connection.close();
        }catch(SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
    }
    public void consultarCliente() throws ClassNotFoundException {
        try {
        abrirConexcion();
        Statement s = connection.createStatement();
        String query = "select * from clientes";
        ResultSet r = s.executeQuery(query);
        while(r.next()){
            System.out.println("Cliente: " + r.getInt("id") + " Cedula: " + r.getString("numeroDocumento") + " Nombre: " + r.getString("nombres") + " Apellidos: " + r.getString("apellidos") + " Contacto : " + r.getString("numeroContacto"));
        }
        connection.close();
        }catch(SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
    }
    
    public void consultarAlquiler() throws ClassNotFoundException {
        try {
        abrirConexcion();
        Statement s5 = connection.createStatement();
        String query = "SELECT c.nombres, c.apellidos, au.marca, au.placa from alquiler as a JOIN clientes as c on c.id = a.idCliente JOIN automoviles as au on au.id = a.idAutomoviles";
        ResultSet r = s5.executeQuery(query);
        while(r.next()){
            System.out.println("Cliente: " + r.getString("nombres") + " " + r.getString("apellidos") + " Auto: " + r.getString("marca") + " " + r.getString("placa"));
        }
        connection.close();
        }catch(SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
    } 
    
    public void consultarAlquilerPorCliente(int numeroDocumento) throws ClassNotFoundException {
        try {
        abrirConexcion();
        Statement s5 = connection.createStatement();
        String query = "SELECT c.nombres, c.apellidos, c.numeroDocumento , au.marca, au.placa from alquiler as a JOIN clientes as c on c.id = a.idCliente JOIN automoviles as au on au.id = a.idAutomoviles where c.numeroDocumento = '"+ numeroDocumento +"'";
        ResultSet r = s5.executeQuery(query);
        if(r.next()){
            System.out.println("Cliente: " + r.getString("nombres") + " " + r.getString("apellidos") + " " + r.getInt("numeroDocumento")  + " Auto: " + r.getString("marca") + " " + r.getString("placa"));
        }else{
            System.out.println("No se encontro ningun registro !");}
        connection.close();
        }catch(SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
    } 
    
}
