/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema_gestion_biblioteca;

/**
 *
 * @author HP
 */
public abstract class MaterialBiblioteca {
    protected int codigo, anioPublicacion;
    protected String titulo, autor;
    protected String disponible = "si";

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    
    public MaterialBiblioteca() {
    }

    public MaterialBiblioteca(int codigo, int anioPublicacion, String titulo, String autor) {
        this.codigo = codigo;
        this.anioPublicacion = anioPublicacion;
        this.titulo = titulo;
        this.autor = autor;
    }
    
    protected abstract double calcularMulta(int diasRetraso) throws Exception;
    protected abstract void mostrarInformacion();
    
}
