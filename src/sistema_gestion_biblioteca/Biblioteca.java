/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema_gestion_biblioteca;

import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class Biblioteca {
    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    private ArrayList<MaterialBiblioteca> listaMateriales = new ArrayList<>();
    private ArrayList<Prestamo> listaPrestamos = new ArrayList<>();

    public Biblioteca() {
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public ArrayList<MaterialBiblioteca> getListaMateriales() {
        return listaMateriales;
    }

    public ArrayList<Prestamo> getListaPrestamos() {
        return listaPrestamos;
    }
    
    public void agregarUsuario(Usuario usuario){
        listaUsuarios.add(usuario);
    }
    public void agregarMaterial(MaterialBiblioteca material){
        listaMateriales.add(material);
    }

    public void prestarMaterial(Prestamo prestamo) throws Exception {
        if (prestamo.getUsuario() == null) {
            throw new Exception("Usuario no encontrado.");
        }

        MaterialBiblioteca materialBuscado = prestamo.getMaterial();

        if (materialBuscado == null || !materialBuscado.disponible.equalsIgnoreCase("si")) {
            throw new Exception("No se puede prestar un material no disponible.");
        }

        String nombreUsuario = prestamo.getUsuario().getNombres();
        int contador = 0;
        for (Prestamo p : listaPrestamos) {
            if (p.getUsuario().getNombres().equalsIgnoreCase(nombreUsuario)) {
                contador++;
            }
        }
        if (contador >= 3) {
            throw new Exception("Limite de prestamos excedido......");
        }

        materialBuscado.disponible = "no";
        listaPrestamos.add(prestamo);
        System.out.println("Material Prestado con exito.....");
    }
    public void devolverMaterial(String nombreUsuario, int codigoMaterial, int diasRetraso) throws Exception {
        Prestamo encontrado = null;

        for (Prestamo p : listaPrestamos) {
            if (p.getUsuario().getNombres().equalsIgnoreCase(nombreUsuario)
                    && p.getMaterial().codigo == codigoMaterial) {
                encontrado = p;
                break;
            }
        }

        if (encontrado == null) {
            throw new Exception("No hay un prestamo a nombre de esta persona !.");
        }

        double multa = encontrado.getMaterial().calcularMulta(diasRetraso);
        encontrado.setMulta(multa);

        encontrado.getMaterial().disponible = "si";
        System.out.println("Material devuelto con exito.....");
    }
    public void mostrarUsuarios(){
        System.out.println("--------DATOS USUARIOS-------- ");
        if(listaUsuarios != null){
            for(Usuario u: listaUsuarios){
                u.mostrarDatos();
                System.out.println("------------------------");
            }
        }else{
            System.out.println("No hay usuarios ingreados al sistema !!");
        }
    }
    public void mostrarMateriales(){
        System.out.println("--------DATOS MATERIALES-------- ");
        if(listaMateriales != null){
            for(MaterialBiblioteca m: listaMateriales){
                m.mostrarInformacion();
                System.out.println("------------------------");
            }
        }else{
            System.out.println("No hay usuarios ingreados al sistema !!");
        }
    }
    public void mostrarPrestamos(){
        System.out.println("-------DATOS PRESTAMOS-------");
        if(listaPrestamos != null){
            for(Prestamo p: listaPrestamos){
                p.mostrarDatos();
                System.out.println("-------------------------");
            }
        }
    }
    public boolean validarUsuario(String nombreUsuario) throws Exception {
        for (Usuario u : listaUsuarios) {
            if (u.getNombres().equalsIgnoreCase(nombreUsuario)) {
                return true;
            }
        }
        throw new Exception("Usuario no encontrado !");
    }
    public boolean validarCodigoMaterial(int codigoMaterial) throws Exception {
        for (MaterialBiblioteca m : listaMateriales) {
            if (m.codigo == codigoMaterial) {
                return true;
            }
        }
        throw new Exception("Codigo de material no encontrado !");
    }
    
    
}
