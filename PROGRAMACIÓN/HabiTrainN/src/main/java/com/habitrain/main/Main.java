package com.habitrain.main;

import com.habitrain.dao.HabitosDAO;
import com.habitrain.dao.RegistroHabitos;
import com.habitrain.dao.UsuarioDAO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
            System.out.println("9.Salir");
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
                    HabitosDAO.listarporUsuario(idUver);
                    break;
                case 6:
                    System.out.println("ID del hábito a eliminar");
                    int idH=scanner.nextInt();
                    HabitosDAO.eliminar(idH);
                    break;
                case 7:
                    System.out.println("ID del Hábito que has hecho");
                    int idHreg=scanner.nextInt();
                    System.out.println("Estado (1. COMPLETADO, 2.PENDIENTE, 3.FALLIDO" );
                    int estOp=scanner.nextInt();
                    String estado=(estOp ==1) ? "COMPLETADO": (estOp==2) ?"PENDIENTE" : "FALLIDO";
                    RegistroHabitos.registrar(idHreg,estado);
                    break;
                case 8:
                    RegistroHabitos.listar();
                    break;
                case 9:
                    System.out.print("saliendo de HabiTrain... ¡Hasta pronto!");
                    break;

                default:
                    System.out.println("opción no válida");
            }
        }while (op !=9);
        scanner.close();
    }
}
