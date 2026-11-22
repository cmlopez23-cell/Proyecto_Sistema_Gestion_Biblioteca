/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema_gestion_biblioteca;

/**
 *
 * @author HP
 */
public class Revista extends MaterialBiblioteca implements IPrestamo{
    private int numeroEdicion;
    private String categoria;

    public Revista() {
    }

    public Revista(int numeroEdicion, String categoria, int codigo, int anioPublicacion, String titulo, String autor) {
        super(codigo, anioPublicacion, titulo, autor);
        this.numeroEdicion = numeroEdicion;
        this.categoria = categoria;
    }
   

    @Override
    protected double calcularMulta(int diasRetraso) throws Exception{
        if (diasRetraso < 0) {
            throw new Exception("Los dias de retraso no pueden ser negativos.");
        }
        return diasRetraso * 1.00;
    }

    @Override
    public void prestar() {
        if(disponible.equalsIgnoreCase("si")){
            disponible = "no";
            System.out.println("Libro Prestado con exito.....");
        }else{
            System.out.println("Libro no disponible !");
        }
    }

    @Override
    public void devolver() {
        if(disponible.equalsIgnoreCase("no")){
            disponible = "si";
            System.out.println("Libro Devuelto con exito.....");
        }else{
            System.out.println("Libro Disponible - Nunca fue prestado !");
        }
    }

    @Override
    protected void mostrarInformacion() {
        System.out.println("------DATOS REVISTA----------");
        System.out.println("Codigo: "+ codigo);
        System.out.println("Titulo: "+ titulo);
        System.out.println("Autor: "+ autor);
        System.out.println("Anio Publicacion: "+ anioPublicacion);
        System.out.println("Disponible: "+ disponible);
        System.out.println("Numero de Edicion: "+ numeroEdicion);
        System.out.println("Categoria: "+ categoria);
    }
}
