/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistema_gestion_biblioteca;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileWriter;
/**
 *
 * @author HP
 */
public class Sistema_Gestion_Biblioteca {

    /**
     * @param args the command line arguments
     */
public static boolean validarEntero(int num){
    if(num < 0){
        System.out.println("Error: Ingrese numeros positivos");
        return false;
    }
    return true;
}
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        int op;
        
        do{
            System.out.println("---------SISTEMA DE GESTION BIBLIOTECA ESPE------------");
            System.out.println("1) Registrar Usuarios");
            System.out.println("2) Registrar Materiales");
            System.out.println("3) Consultar Materiales");
            System.out.println("4) Consultar Usuarios");
            System.out.println("5) Consultar Prestamos");
            System.out.println("6) Solicitar Prestamo");
            System.out.println("7) Devolver Material");
            System.out.println("8) Salir");
            System.out.print("Ingrese una opcion: ");
            op = sc.nextInt();
            sc.nextLine();
            switch(op){
                case 1:
                        boolean valorV = false;
                        int edad = 0;
                        System.out.println("-------MENU REGISTRO DE USUARIOS------");
                        System.out.println("1) Registrar Docente");
                        System.out.println("2) Registrar Estudiante");
                        System.out.print("Ingrese una opcion: ");
                        op = sc.nextInt();
                        sc.nextLine();
                        System.out.println("-----DATOS PERSONALES-----");
                        System.out.print("ID: ");
                        String id = sc.nextLine();
                        System.out.print("Cedula: ");
                        String cedula = sc.nextLine();
                        System.out.print("Nombres: ");
                        String nombres = sc.nextLine();
                        while(!valorV){
                            try{
                               System.out.print("Edad: ");
                               edad = sc.nextInt();
                               valorV = validarEntero(edad);
                            }catch(InputMismatchException e){
                                System.out.println("Error: solo ingrese numeros!!");
                                sc.nextLine();
                            }
                        }
                        sc.nextLine();
                        System.out.print("Direccion: ");
                        String direccionDomicilio = sc.nextLine();
                        if(op == 1){
                            System.out.print("Departamento: ");
                            String departamento = sc.nextLine();
                            System.out.print("Especialidad: ");
                            String especialidad = sc.nextLine();
                            biblioteca.agregarUsuario(new Docente(departamento, especialidad,  id, cedula,  nombres, direccionDomicilio, edad));
                            System.out.println("Docente Registrado con exito.....");
                        }if(op == 2){
                            System.out.print("Carrera: ");
                            String carrera = sc.nextLine();
                            System.out.print("Semestre: ");
                            String semestre = sc.nextLine();
                            biblioteca.agregarUsuario(new Estudiante(carrera, semestre,  id, cedula,  nombres, direccionDomicilio, edad));
                            System.out.println("Estudiante Registrado con exito.......");
                        }
                        break;
                case 2:
                        System.out.println("-------MENU REGISTRO DE MATERIALES------");
                        System.out.println("1) Registrar Libro");
                        System.out.println("2) Registrar Revista");
                        System.out.println("3) Registrar Tesis");
                        System.out.print("Ingrese una opcion: ");
                        op = sc.nextInt();
                        System.out.println("----DATOS MATERIAL----");
                        System.out.print("Codigo: ");
                        int codigo = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Titulo: ");
                        String titulo = sc.nextLine();
                        System.out.print("Autor: ");
                        String autor = sc.nextLine();
                        System.out.print("Anio Publicacion: ");
                        int anioPublicacion = sc.nextInt();
                        sc.nextLine();
                        if(op == 1){
                            System.out.print("Genero: ");
                            String genero = sc.nextLine();
                            System.out.print("Numero de Paginas: ");
                            int numeroPaginas = sc.nextInt();
                            sc.nextLine();
                            biblioteca.agregarMaterial(new Libro(genero, numeroPaginas, codigo, anioPublicacion, titulo, autor));
                            System.out.println("Libro registrado con exito.......");
                        }if(op == 2){
                            System.out.print("Numero de Edicion: ");
                            int numeroEdicion = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Categoria: ");
                            String categoria = sc.nextLine();
                            biblioteca.agregarMaterial(new Revista(numeroEdicion, categoria, codigo, anioPublicacion, titulo, autor));
                            System.out.println("Revista registrada con exito......");
                        }if(op == 3){
                            System.out.print("Tema: ");
                            String tema = sc.nextLine();
                            System.out.print("Departamento: ");
                            String departamento = sc.nextLine();
                            biblioteca.agregarMaterial(new Tesis(tema, departamento, codigo, anioPublicacion, titulo, autor));
                            System.out.println("Tesis registrada con exito......");
                        }
                        break;
                case 3:
                    biblioteca.mostrarMateriales();
                    break;
                case 4:
                    biblioteca.mostrarUsuarios();
                    break;
                case 5:
                    biblioteca.mostrarPrestamos();
                    break;
                case 6:
                    System.out.println("-----SOLICITUD PRESTAMO------");
                    boolean prestamoRealizado = false;
                    String nombreUsuario = null;
                    int codigoMaterial = 0;
                    while (!prestamoRealizado) {
                        try {
                            System.out.print("Nombre del usuario: ");
                            nombreUsuario = sc.nextLine();
                            prestamoRealizado = biblioteca.validarUsuario(nombreUsuario);
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }
                    prestamoRealizado = false;
                    Usuario usuarioEncontrado = null;
                    for (Usuario u : biblioteca.getListaUsuarios()) {
                        if (u.getNombres().equalsIgnoreCase(nombreUsuario)) {
                        usuarioEncontrado = u;

                        }
                    }
                    while (!prestamoRealizado) {
                        try{
                            System.out.print("Codigo del material: ");
                            codigoMaterial = sc.nextInt();
                            sc.nextLine();
                            prestamoRealizado = biblioteca.validarCodigoMaterial(codigoMaterial);
                        }catch (InputMismatchException e) {
                            System.out.println("Error: Solo ingrese numeros!!");
                            sc.nextLine();
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }

                   MaterialBiblioteca materialEncontrado = null;
                   for (MaterialBiblioteca m : biblioteca.getListaMateriales()) {
                        if (m.codigo == codigoMaterial) {
                            materialEncontrado = m;
                       }
                    }

                    System.out.print("Fecha Prestamo: ");
                    String fechaPrestamo = sc.nextLine();
                    System.out.print("Fecha Devolucion: ");
                    String fechaDevolucion = sc.nextLine();
                        
                    Prestamo prestamo = new Prestamo(usuarioEncontrado, materialEncontrado, fechaPrestamo, fechaDevolucion, 0);
                    try {
                        biblioteca.prestarMaterial(prestamo);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    try {
                        BufferedWriter bw = new BufferedWriter(
                                new FileWriter("prestamos.txt")
                        );
                        bw.write("---------PRESTAMOS---------");
                        bw.newLine();

                        for (Prestamo p : biblioteca.getListaPrestamos()) {
                            bw.write("Usuario: " + p.getUsuario().getNombres());
                            bw.newLine();
                            bw.write("Codigo Material: " + p.getMaterial().codigo);
                            bw.newLine();
                            bw.write("Material: " + p.getMaterial().titulo);
                            bw.newLine();
                            bw.write("Fecha Prestamo: " + p.getFechaPrestamo());
                            bw.newLine();
                            bw.write("Fecha Devolucion: " + p.getFechaDevolucion());
                            bw.newLine();
                            bw.write("---------------------------");
                            bw.newLine();
                        }
                        bw.close();
                        System.out.println("Prestamo guardado con exito!!");
                    } catch (IOException e) {
                        System.out.println("Error no se puede crear el archivo!!");
                    }
                    break;
                case 7:
                    System.out.println("-----DEVOLUCION MATERIAL------");
                    boolean materialDevuelto = false;
                    String nombreUsuario2 = null;
                    int codigoMaterial2 = 0;
                    while (!materialDevuelto) {
                        try {
                            System.out.print("Nombre del usuario: ");
                            nombreUsuario2 = sc.nextLine();
                            materialDevuelto = biblioteca.validarUsuario(nombreUsuario2);
                        }catch(Exception e){
                            System.out.println("Error: " + e.getMessage());
                        }
                    }
                    materialDevuelto = false;
                    while(!materialDevuelto){
                        try{
                            System.out.print("Codigo del material: ");
                            codigoMaterial2 = sc.nextInt();
                            sc.nextLine();
                            materialDevuelto = biblioteca.validarCodigoMaterial(codigoMaterial2);
                        }catch (InputMismatchException e) {
                            System.out.println("Error: Solo ingrese numeros!!");
                            sc.nextLine();
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }
                    materialDevuelto = false;
                    while(!materialDevuelto){
                        try{
                            System.out.print("Dias de retraso: ");
                            int diasRetraso = sc.nextInt();
                            sc.nextLine();
                            biblioteca.devolverMaterial(nombreUsuario2, codigoMaterial2, diasRetraso);
                            materialDevuelto = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Error: Solo ingrese numeros!!");
                            sc.nextLine();
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Opcion no valida !!");
                    break;
            }
        }while(op != 8);
    }
    
}
