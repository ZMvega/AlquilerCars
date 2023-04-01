/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dbController.conexionDB;
import entity.Automovil;
import entity.Cliente;
import java.sql.SQLException;

public class clientes {
    
    public Boolean insertClientes(Cliente cliente) throws ClassNotFoundException, SQLException
    {
        conexionDB con = new conexionDB();
        return con.insertDbClientes(cliente);
    }
    
    public void consultarClientes() throws ClassNotFoundException, SQLException
    {
        conexionDB con = new conexionDB();
       con.consultarCliente();
    }
    
}
