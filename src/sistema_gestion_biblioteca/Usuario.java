/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema_gestion_biblioteca;

/**
 *
 * @author HP
 */
public class Usuario {
    private String id, cedula, nombres, direccionDomicilio;
    private int edad;

    public Usuario() {
    }

    public Usuario(String id, String cedula, String nombres, String direccionDomicilio, int edad) {
        this.id = id;
        this.cedula = cedula;
        this.nombres = nombres;
        this.direccionDomicilio = direccionDomicilio;
        this.edad = edad;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
   
    
    public void consultarMateriales(){
        
    }
    public void solicitarPrestamos(){
        
    }
    public void mostrarDatos(){
        System.out.println("ID: "+ id);
        System.out.println("Cedula: "+ cedula);
        System.out.println("Nombres: "+ nombres);
        System.out.println("Edad: "+ edad);
        System.out.println("Direccion de Domicilio: "+ direccionDomicilio);
    }
}
