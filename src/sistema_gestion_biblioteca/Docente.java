/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema_gestion_biblioteca;

/**
 *
 * @author HP
 */
public class Docente extends Usuario{
    private String departamento, especialidad;

    public Docente() {
    }

    public Docente(String departamento, String especialidad, String id, String cedula, String nombres, String direccionDomicilio, int edad) {
        super(id, cedula, nombres, direccionDomicilio, edad);
        this.departamento = departamento;
        this.especialidad = especialidad;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos(); 
        System.out.println("Departamento: "+ departamento);
        System.out.println("Especialidad: "+ especialidad);
    }
    
    
}
