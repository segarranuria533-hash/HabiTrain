package com.habitrain.main;

import com.habitrain.dao.UsuarioDAO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int op;
        do {
            System.out.println("\n--HabiTrain");
            System.out.println("1.Ver Usuario");
            System.out.println("2.Insetar Usuario");
            System.out.println("3.Elminar Usuario");
            System.out.println("4.Salir");
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
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    UsuarioDAO.eliminar(id);
                    break;
                case 4:
                    System.out.print("saliendo...");
                    break;
            }
        }while (op !=4);
    }
}
