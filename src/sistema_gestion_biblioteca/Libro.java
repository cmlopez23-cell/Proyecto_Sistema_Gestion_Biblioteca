/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema_gestion_biblioteca;

/**
 *
 * @author HP
 */
public class Libro extends MaterialBiblioteca implements IPrestamo{
    private String genero;
    private int numeroPaginas;

    public Libro() {
    }

    public Libro(String genero, int numeroPaginas, int codigo, int anioPublicacion, String titulo, String autor) {
        super(codigo, anioPublicacion, titulo, autor);
        this.genero = genero;
        this.numeroPaginas = numeroPaginas;
    }
   

    @Override
    protected double calcularMulta(int diasRetraso) throws Exception{
        if (diasRetraso < 0) {
            throw new Exception("Los dias de retraso no pueden ser negativos.");
        }
        return diasRetraso * 0.50;
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
        System.out.println("------DATOS LIBRO----------");
        System.out.println("Codigo: "+ codigo);
        System.out.println("Titulo: "+ titulo);
        System.out.println("Autor: "+ autor);
        System.out.println("Anio Publicacion: "+ anioPublicacion);
        System.out.println("Disponible: "+ disponible);
        System.out.println("Genero: "+ genero);
        System.out.println("Numero de Paginas: "+ numeroPaginas);
    }


    
}
