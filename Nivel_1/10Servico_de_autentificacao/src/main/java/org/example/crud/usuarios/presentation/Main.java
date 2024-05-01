package org.example.crud.usuarios.presentation;

import static org.example.crud.usuarios.presentation.UserCrudApp.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            printMenu();
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Escolha inválida. Por favor, escolha um numero de 1 a 6.");
                scanner.nextLine();
                choice = -1;
            }

            switch (choice) {
                case 1:
                    getUserById();
                    break;
                case 2:
                    getAllUsers();
                    break;
                case 3:
                    saveUser();
                    break;
                case 4:
                    updateUser();
                    break;
                case 5:
                    deleteUserApp();
                    break;
                case 6:
                    System.out.println("Encerrando a aplicação...");
                    break;
                default:
                    System.err.println("Escolha invalida.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
