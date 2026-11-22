/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema_gestion_biblioteca;

/**
 *
 * @author HP
 */
public class Prestamo {
    private Usuario usuario;
    private MaterialBiblioteca material;
    private String fechaPrestamo;
    private String fechaDevolucion;
    private double multa;

    public Prestamo() {
    }

    public Prestamo(Usuario usuario, MaterialBiblioteca material, String fechaPrestamo, String fechaDevolucion, double multa) {
        this.usuario = usuario;
        this.material = material;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.multa = multa;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public MaterialBiblioteca getMaterial() {
        return material;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }

    
    
    public void mostrarDatos(){
        System.out.println("Usuario: " + usuario.getNombres());
        System.out.println("Codigo: " + material.codigo);
        System.out.println("Titulo: " + material.titulo);
        System.out.println("Fecha Prestamo: " + fechaPrestamo);
        System.out.println("Fecha Devolucion: " + fechaDevolucion);
        System.out.println("Multa: "+ multa );

    }
    
    
}
