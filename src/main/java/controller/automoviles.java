/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dbController.conexionDB;
import entity.Automovil;

public class automoviles {
    
    public Boolean insertAutomoviles(Automovil automovil) throws ClassNotFoundException
    {
        conexionDB con = new conexionDB();
        return con.insertDbAutomovil(automovil);
    }
    
    public void consultarAutomoviles() throws ClassNotFoundException{
        conexionDB con = new conexionDB();
        con.consultarAutomoviles();
    }
    
}
