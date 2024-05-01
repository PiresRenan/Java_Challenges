package org.example.crud.usuarios.presentation;

import org.example.crud.usuarios.model.User;
import org.example.crud.usuarios.repository.UserDAO;
import org.example.crud.usuarios.repository.UserDAOImpl;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserCrudApp {

    private static final UserDAO userDao = new UserDAOImpl();
    private static final Scanner scanner = new Scanner(System.in);

    public static void printMenu() {
        System.out.println("\nAplicação CRUD Usuarios");
        System.out.println("1. Mostre um usuario pelo ID");
        System.out.println("2. Mostre todos os usuarios");
        System.out.println("3. Adicionar um usuario");
        System.out.println("4. Alterar um usuario");
        System.out.println("5. Deletar um usuario");
        System.out.println("6. Sair");
        System.out.print("Digite sua escolha: ");
    }

    public static void getUserById() {
        System.out.print("Digite a ID: ");
        int id = scanner.nextInt();
        User user = userDao.getUserById(id);

        if (user != null) {
            System.out.println(user.toString());
        } else {
            System.err.println("Usuario nao encontrado.");
        }
    }

    public static void getAllUsers() {
        List<User> users = userDao.getAllUsers();
        if (users.isEmpty()) {
            System.err.println("Nenhum usuario encontrado.");
        } else {
            System.out.println("Lista de usuarios:");
            for (User user : users) {
                System.out.println(user.toString());
            }
        }
    }

    public static void saveUser() {
        String name, email, password;
        do {
            System.out.print("Digite o nome do usuario: ");
            name = scanner.nextLine();
        } while (name.isEmpty());

        do {
            System.out.print("Digite o email do usuario: ");
            email = scanner.nextLine();
        } while (email.isEmpty() || !isValidEmail(email));

        do {
            System.out.print("Digite a senha do usuario: ");
            password = scanner.nextLine();
        } while (password.isEmpty());

        User user = new User(0, name, email, password);
        userDao.saveUser(user);
        System.out.println("Usuario criado com sucesso!");
    }

    private static boolean isValidEmail(String email) {
        String regex = "^[\\w-\\.+]+@([\\w-]+\\.)+[\\w-]{2,}$";
        return email.matches(regex);
    }

    public static void updateUser() {
        System.out.print("Digite o email do usuario que deseja atualizar: ");
        String email = scanner.nextLine();

        System.out.println("Opções de atualização:");
        System.out.println("1. Atualizar ID");
        System.out.println("2. Atualizar Name");
        System.out.println("3. Atualizar Email");
        System.out.println("4. Atualizar Password");
        System.out.print("Digite sua escolha: ");

        int updateChoice;
        try {
            updateChoice = Integer.parseInt(scanner.nextLine());
        } catch (InputMismatchException | NumberFormatException e) {
            System.err.println("Opção invalida. Por favor, escolha um numero entre 1 e 4.");
            scanner.nextLine();
            return;
        }

        System.out.print("Digite o novo valor: ");
        String newValue = scanner.nextLine();

        userDao.updateUser(newValue, updateChoice, email);
        System.out.println("Usuario atualizado com sucesso!");
    }

    public static void deleteUserApp() {
        System.out.print("Digite o ID do usuário para deletar: ");
        int id = scanner.nextInt();

        boolean isDeleted = userDao.deleteUser(id);

        if (isDeleted) {
            System.out.println("Usuário deletado com sucesso!");
        } else {
            System.err.println("Erro: Usuário não encontrado com ID: " + id);
        }
    }
}
