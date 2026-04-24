package com.habitrain.main;

import com.habitrain.dao.*;
import com.habitrain.database.Conexion;
import com.habitrain.model.Ejercicios;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Connection connection = Conexion.getConectar();
        Scanner scanner=new Scanner(System.in);
        int op;
        do {
            System.out.println("\n--HabiTrain: Gestión de Hábitos");
            System.out.println("1.Ver Usuario");
            System.out.println("2.Insetar Usuario");
            System.out.println("3.Elminar Usuario");
            System.out.println("4.Crear hábito");
            System.out.println("5.ver hábitos de un Usuario");
            System.out.println("6.Eliminar hábito");
            System.out.println("7. Registrar progreso hábito");
            System.out.println("8.ver registros");
            System.out.println("9.Crear entrenamiento");
            System.out.println("10. ver entrenamiento");
            System.out.println("11. Crear ejercicio");
            System.out.println("12.Ver ejercicio");
            System.out.println("13. Añadir ejercicio o entrenamiento");
            System.out.println("14.Salir");
            System.out.println("Selecciona una opción: ");
            op=scanner.nextInt();
            switch (op){
                case 1:
                    UsuarioDAO.listar();
                    break;
                case 2:
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
                    System.out.print("ID del usuario a eliminar: ");
                    int id = scanner.nextInt();
                    UsuarioDAO.eliminar(id);
                    break;
                case 4:
                    System.out.println("ID Usuario: ");
                    int idU=scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Nombre del hábito:");
                    String h=scanner.nextLine();
                    System.out.println("Meta diaria: ");
                    int m=scanner.nextInt();

                    HabitosDAO.insertar(idU,h,m);
                    break;
                case 5:
                    System.out.println("id del usuario para ver sus hábitos");
                    int idUver=scanner.nextInt();
                    HabitosDAO.listarPorUsuario(idUver);
                    break;
                case 6:
                    System.out.println("ID del hábito a eliminar");
                    int idH=scanner.nextInt();
                    HabitosDAO.eliminar(idH);
                    break;
                case 7:
                    System.out.println("ID Usuario:  ");
                    int idUser=scanner.nextInt();
                    System.out.println("ID del Hábito que has hecho");
                    int idHreg=scanner.nextInt();
                    System.out.println("Estado (1. COMPLETADO, 2.PENDIENTE, 3.FALLIDO)" );
                    int estOp=scanner.nextInt();
                    String estado= switch (estOp){
                        case 1-> "COMPLETADO";
                        case 2-> "PENDIENTE";
                        case 3-> "FALLIDO";
                        default -> "pendiente";
                    };
                    RegistroHabitosDAO.registrar(idHreg,estado,idUser);
                    break;

                case 8:
                    RegistroHabitosDAO.listar();
                    break;
                case 9:
                    System.out.println("ID usuario: ");
                    int idUserEntre=scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Nombre del entrenamiento: ");
                    String nombreEntre=scanner.nextLine();
                    EntrenamientoDAO.insertar(idUserEntre,nombreEntre);
                    break;

                case 10:
                    System.out.println("ID usuario:");
                    int idUserList= scanner.nextInt();
                    var listaEntr= EntrenamientoDAO.listarPorUsuario(idUserList);
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
                    EjerciciosDAO.insertar(nomEj,grupo);
                    break;

                case 12:
                    var listaEj= EjerciciosDAO.listar();
                    for (var ej : listaEj){
                        System.out.println(ej);
                    }
                    break;

                case 13:
                    List<Ejercicios>ejercicios=EjerciciosDAO.listar();
                    System.out.println("\n--EJERCICIOS---");
                    for (Ejercicios ejercicios1 : ejercicios){
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
                    EntrenamientoEjercicioDAO.agregarEjercicio(idEnt,idEj,series,reps);
                    break;

                case 14:
                    System.out.print("saliendo de HabiTrain... ¡Hasta pronto!");
                    break;

                default:
                    System.out.println("opción no válida");
            }
        }while (op !=14);
        scanner.close();
    }
}
