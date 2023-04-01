/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dbController.conexionDB;
import entity.Alquiler;

public class alquilerController {
    
    public Boolean insertarAlquiler(Alquiler alquiler) throws ClassNotFoundException{
        conexionDB con = new conexionDB();
        return con.insertDbAlquiler(alquiler);
    }
    public void consultarAlquiler() throws ClassNotFoundException{
        conexionDB con = new conexionDB();
        con.consultarAlquiler();
    }
    public void consultarAlquilerPorDocumento(int numeroDocumento) throws ClassNotFoundException{
        conexionDB con = new conexionDB();
        con.consultarAlquilerPorCliente(numeroDocumento);
    }
}
