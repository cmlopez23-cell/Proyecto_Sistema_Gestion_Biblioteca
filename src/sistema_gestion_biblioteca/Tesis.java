/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema_gestion_biblioteca;

/**
 *
 * @author HP
 */
public class Tesis extends MaterialBiblioteca{
    private String tema, departamento;

    public Tesis() {
    }

    public Tesis(String tema, String departamento, int codigo, int anioPublicacion, String titulo, String autor) {
        super(codigo, anioPublicacion, titulo, autor);
        this.tema = tema;
        this.departamento = departamento;
    }
    

    @Override
    protected double calcularMulta(int diasRetraso) {
        return diasRetraso * 0.50;
    }

    @Override
    protected void mostrarInformacion() {
        System.out.println("------DATOS TESIS----------");
        System.out.println("Codigo: "+ codigo);
        System.out.println("Titulo: "+ titulo);
        System.out.println("Autor: "+ autor);
        System.out.println("Anio Publicacion: "+ anioPublicacion);
        System.out.println("Disponible: "+ disponible);
        System.out.println("Tema: "+ tema);
        System.out.println("Departamento: "+ departamento);
    }
    
}
