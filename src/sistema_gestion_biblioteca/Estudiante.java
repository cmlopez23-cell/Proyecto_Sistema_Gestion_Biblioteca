/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema_gestion_biblioteca;

/**
 *
 * @author HP
 */
public class Estudiante extends Usuario{
    private String carrera, semestre;

    public Estudiante() {
    }

    public Estudiante(String carrera, String semestre, String id, String cedula, String nombres, String direccionDomicilio, int edad) {
        super(id, cedula, nombres, direccionDomicilio, edad);
        this.carrera = carrera;
        this.semestre = semestre;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Carrera: "+ carrera);
        System.out.println("Semestre: "+ semestre);
    }
    
    
}
