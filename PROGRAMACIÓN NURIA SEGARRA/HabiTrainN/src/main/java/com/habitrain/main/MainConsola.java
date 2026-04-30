package com.habitrain.main;

import com.habitrain.dao.*;
import com.habitrain.model.Ejercicios;

import java.util.List;
import java.util.Scanner;

import com.habitrain.model.Usuario;
import com.habitrain.service.HabitosService;
import com.habitrain.service.EntrenamientosService;
import  com.habitrain.service.EjerciciosService;
import  com.habitrain.service.RegistrosHabitosService;
import  com.habitrain.service.EntrenamientoEjercicioService;

public class MainConsola {
    public static void main(String[] args) {

       Scanner scanner=new Scanner(System.in);
       System.out.println("///=====LOGIN HabiTrain====/// ");

       System.out.println("Email:  ");
       String email= scanner.nextLine();
       System.out.println("Contraseña:  ");
       String contra= scanner.nextLine();
        Usuario usuarioLogueado= UsuarioDAO.login(email,contra);

        if (usuarioLogueado==null){
            System.out.println("Usuario o contraseña incorrectos");
            return;
        }
        String rolUsuario=  usuarioLogueado.getRol();
        int idUsuarioLogueado= usuarioLogueado.getId_usuario();
        System.out.println("Bienvenido" + rolUsuario);
        int op;
        do {
            System.out.println("\n--HabiTrain----");
            System.out.println("Usuario: " + rolUsuario);
            System.out.println("1.Ver Usuario");
            if  ("ADMIN".equals(rolUsuario)) {
                System.out.println("2.insertar Usuario");
                System.out.println("3.Eliminar Usuario");
            }

            System.out.println("4.Crear hábito");
            System.out.println("5.ver hábitos de un Usuario");
            System.out.println("6.Eliminar hábito");
            System.out.println("7. Registrar progreso hábito");
            System.out.println("8.ver registros");
            System.out.println("9.Crear entrenamiento");
            System.out.println("10. ver entrenamiento");
            System.out.println("11. Crear ejercicio");
            System.out.println("12.Ver ejercicio");
            System.out.println("13. Añadir ejercicio a entrenamiento");
            System.out.println("14.Salir");
            System.out.println("Selecciona una opción: ");
            op=scanner.nextInt();
            switch (op){
                case 1:
                    if (!"ADMIN".equals(rolUsuario)){
                        System.out.println("NO tienes permisos");
                        break;
                    }
                    UsuarioDAO.listar();
                    break;
                case 2:
                    if (!"ADMIN".equals(rolUsuario)){
                        System.out.println("no tienes permisos");
                        break;
                    }
                    scanner.nextLine();
                    System.out.print("Nombre: ");
                    String n = scanner.nextLine();
                    System.out.print("Apellido: ");
                    String a = scanner.nextLine();
                    System.out.print("Contraseña: ");
                    String c = scanner.nextLine();
                    System.out.print("Email: ");
                    String e = scanner.nextLine();


                    UsuarioDAO.insertar(n,a,c,e);
                    break;

                case 3:
                    if (!"ADMIN".equals(rolUsuario)){
                        System.out.println("no tienes permisos");
                        break;
                    }
                    System.out.print("ID del usuario a eliminar: ");
                    int id = scanner.nextInt();
                    UsuarioDAO.eliminar(id);
                    break;
                case 4:

                    scanner.nextLine();

                    System.out.println("Nombre del hábito:");
                    String h = scanner.nextLine();

                    System.out.println("Meta diaria:");
                    int m = scanner.nextInt();

                    int idU;

                    if (!"ADMIN".equals(rolUsuario)) {
                        System.out.println("ID Usuario:");
                        idU = scanner.nextInt();
                    } else {
                        idU = idUsuarioLogueado;
                    }

                    HabitosService.crearHabito(idU, h, m);
                    break;
                case 5:
                    int idVer;
                    if ("ADMIN".equals(rolUsuario)) {
                        System.out.print("ID usuario: ");
                        idVer = scanner.nextInt();
                    } else {
                        idVer = idUsuarioLogueado;
                    }
                    HabitosService.listarPorUsuario(idVer);
                    break;
                case 6:
                    System.out.println("ID del hábito a eliminar");
                    int idH=scanner.nextInt();
                    HabitosService.eliminar(idH);
                    break;
                case 7:

                    int idRegUser;
                    if ("ADMIN".equals(rolUsuario)){
                        System.out.println("ID usuario:  ");
                        idRegUser= scanner.nextInt();
                    }else{
                        idRegUser=idUsuarioLogueado;
                    }
                    System.out.println("ID Habito:  ");
                    int idHabito=scanner.nextInt();
                    System.out.println("Estado (1. COMPLETADO, 2.PENDIENTE, 3.FALLIDO)" );
                    int estOp=scanner.nextInt();
                    String estado= switch (estOp){
                        case 1-> "COMPLETADO";
                        case 2-> "PENDIENTE";
                        case 3-> "FALLIDO";
                        default -> "pendiente";
                    };
                    RegistrosHabitosService.registrar(idRegUser,estado,idHabito);
                    break;

                case 8:
                    RegistrosHabitosService.listar();
                    break;
                case 9:
                    System.out.println("ID usuario: ");
                    int idUserEntre=scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Nombre del entrenamiento: ");
                    String nombreEntre=scanner.nextLine();
                    EntrenamientosService.crearEntrenamiento(idUserEntre,nombreEntre);
                    break;

                case 10:
                    System.out.println("ID usuario:");
                    int idUserList= scanner.nextInt();
                    var listaEntr= EntrenamientosService.listarPorUsuario(idUserList);
                    if (listaEntr.isEmpty()){
                        System.out.println("NO hay entrenamientos");
                        break;
                    }
                    for (var e1:listaEntr){
                        System.out.println(e1);
                    }
                    break;

                case 11:
                    scanner.nextLine();
                    System.out.println("Nombre ejercicio: ");
                    String nomEj=scanner.nextLine();
                    System.out.println("Grupo muscular: ");
                    String grupo=scanner.nextLine();
                    EjerciciosService.insertar(nomEj,grupo);
                    break;

                case 12:
                    List<Ejercicios>ejercicios=EjerciciosService.listar();
                    for (Ejercicios ej:ejercicios){
                        System.out.println(ej);
                    }
                    break;

                case 13:
                    List<Ejercicios>ejerciciosList=EjerciciosService.listar();

                    System.out.println("\n--EJERCICIOS---");
                    for (Ejercicios ejercicios1 : ejerciciosList){
                        System.out.println(ejercicios1);

                    }
                    System.out.println("\nID entrenamiento: ");
                    int idEnt=scanner.nextInt();
                    System.out.println("ID ejercicio: ");
                    int idEj= scanner.nextInt();
                    System.out.println("Series: ");
                    int series= scanner.nextInt();
                    System.out.println("Repeticiones");
                    int reps= scanner.nextInt();
                    EntrenamientoEjercicioService.agregar(idEnt,idEj,series,reps);
                    break;

                case 14:
                    System.out.print("Saliendo de HabiTrain... ¡Hasta pronto!");
                    break;

                default:
                    System.out.println("opción no válida");
            }
        }while (op !=14);
        scanner.close();
    }
}
