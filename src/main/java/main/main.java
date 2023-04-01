/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.alquilerController;
import controller.automoviles;
import controller.clientes;
import entity.Alquiler;
import entity.Automovil;
import entity.Cliente;
import java.sql.SQLException;
import java.util.Scanner;

public class main {
    public static void main(String args[]) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{  
        
        int opcion;
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Scanner sc3 = new Scanner(System.in);
        
        Scanner c1 = new Scanner(System.in);
        Scanner c2 = new Scanner(System.in);
        Scanner c3 = new Scanner(System.in);
        Scanner c4 = new Scanner(System.in);
        Scanner c5 = new Scanner(System.in);
        
        Scanner a1 = new Scanner(System.in);
        Scanner a2 = new Scanner(System.in);
        
        Scanner alquileroPorDocumento = new Scanner(System.in);

        do{
            System.out.println(" 1. ingreso de automoviles");
            System.out.println(" 2. ingreso de clientes");
            System.out.println(" 3. registro de alquiler");
            System.out.println(" 4. consultar automoviles");
            System.out.println(" 5. consultar clientes");
            System.out.println(" 6. consultar alquileres");
            System.out.println(" 7. consultar alquileres por cliente");
            System.out.println(" 8. salir");

            opcion = sc.nextInt();
            switch(opcion) {
                case 1:
                    System.out.println("1. ingreso de automoviles");
                    Automovil automovil = new Automovil();

                    System.out.println("1. Ingrese la marca");
                    String marca = sc1.nextLine();
                    System.out.println("1. Ingrese la linea");
                    String linea = sc2.nextLine();
                    System.out.println("1. Ingrese la placa");
                    String placa = sc3.nextLine();


                    automovil.setMarca(marca);
                    automovil.setLinea(linea);
                    automovil.setPlaca(placa);

                    automoviles automoviles = new automoviles();
                    if (automoviles.insertAutomoviles(automovil)) {
                        System.out.println("Se agrego el automovil");
                    }
                    break;
                case 2:
                    System.out.println("2. ingreso de clientes");
                    System.out.println("Ingrese numero de documento: ");
                    int numeroDocumento = c1.nextInt();
                    System.out.println("Ingrese los Nombres: ");
                    String nombres = c2.nextLine();
                    System.out.println("Ingrese los Apellidos: ");
                    String apellidos = c3.nextLine();
                    System.out.println("Ingrese numero de contacto");
                    String numeroContacto = c4.nextLine();
                    System.out.println("Ingrese la dirección");
                    String direccion = c5.nextLine();

                    Cliente cliente = new Cliente();

                    cliente.setNumeroDocumento(numeroDocumento);
                    cliente.setNombre(nombres);
                    cliente.setApellido(apellidos);
                    cliente.setNumeroContacto(numeroContacto);
                    cliente.setDireccion(direccion);

                    clientes clientes = new clientes();
                    if (clientes.insertClientes(cliente)) {
                        System.out.println("Se agrego el cliente");
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el Id del Cliente");
                    int idCLiente = c1.nextInt();
                    System.out.println("Ingrese el Id del automovil");
                    int idAutomoviles = c2.nextInt();

                    Alquiler alquiler = new Alquiler();

                    alquiler.setIdCliente(idCLiente);
                    alquiler.setIdAutomoviles(idAutomoviles);

                    alquilerController alquilerController = new alquilerController();
                    if (alquilerController.insertarAlquiler(alquiler)) {
                        System.out.println("Se agrego el cliente");
                    }
                    break;
                case 4:
                    automoviles automoviles1 = new automoviles();
                    automoviles1.consultarAutomoviles();
                    break;
                case 5:
                    clientes clientes1 = new clientes();
                    clientes1.consultarClientes();
                    break;
                case 6:
                    alquilerController alquilerController1 = new alquilerController();
                    alquilerController1.consultarAlquiler();
                    break;
                case 7:
                    alquilerController alquilerController2 = new alquilerController();
                    System.out.println("Ingrese el documento: ");
                    int numeroDocumento1 = alquileroPorDocumento.nextInt();
                    alquilerController2.consultarAlquilerPorDocumento(numeroDocumento1);
                    break;
                case 8:
                    opcion = 8;
                    System.out.println("8. salir");
                    break;
            }
        }while(opcion != 8);
        
    }  
}
