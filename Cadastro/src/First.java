package br.pucpr.poo.cadastro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class First {

    static Scanner input = new Scanner(System.in);

    public static void menu() {

        List<User> users = new ArrayList<>();

        while (true) {
            System.out.println("*** Sistema de Cadastro ***");
            System.out.println("1. Cadastrar usuário");
            System.out.println("2. Editar dados do usuário");
            System.out.println("3. Excluir usuário");
            System.out.println("4. Listar");
            System.out.println("5. Limpar dados");
            System.out.println("6. Sair\n");
            System.out.print("Digite a opção que deseja: ");

            int op = Integer.parseInt(input.nextLine());
            switch (op) {
                case 1:
                    if (add_user(users)) {

                        System.out.println("Usuário cadastrado com sucesso!!!");
                    }
                    else {

                        System.out.println("Problemas ao tentar cadastrar o usuário");
                    }
                    break;
                case 2:
                    if (edit_user(users)) {

                        System.out.println("Usuário editado com sucesso!!!");
                    }
                    else {

                        System.out.println("Problemas ao tentar editar o usuário");
                    }
                    break;
                case 3:
                    if (del_user(users)) {

                        System.out.println("Usuário excluído com sucesso!!!");
                    }
                    else {

                        System.out.println("Problemas ao tentar excluir o usuário");
                    }
                    break;
                case 4:
                    list_data(users);
                    break;
                case 5:
                    clean_data(users);
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }

    public static boolean add_user(List<User> users) {

        System.out.print("Digite o cpf do usuário: ");
        String cpf = input.nextLine();
        User findUser = find_user(users, cpf);
        if (findUser != null) {

            System.out.println("Usuário já cadastrado: " + findUser.name);
            return false;
        }
        System.out.print("Digite o nome do usuário: ");
        String name = input.nextLine();
        System.out.print("Digite a idade do usuário: ");
        int age = Integer.parseInt(input.nextLine());

        User user = new User();
        user.cpf = cpf;
        user.name = name;
        user.age = age;

        return users.add(user);
    }

    public static User find_user(List<User> users, String cpf) {

        for (User user : users) {

            if (user.cpf.equalsIgnoreCase(cpf)) {

                return user;
            }
        }

        return null;
    }

    public static boolean edit_user(List<User> users) {

        System.out.print("Digite o cpf do usuário: ");
        String cpf = input.nextLine();
        User findUser = find_user(users, cpf);
        if (findUser == null) {

            System.out.println("Usuário não localizado!");

            return false;
        }
        else {

            System.out.print("Digite o nome do usuário: ");
            String name = input.nextLine();
            System.out.print("Digite a idade do usuário: ");
            int age = Integer.parseInt(input.nextLine());
            findUser.name = name;
            findUser.age = age;

            return true;
        }
    }

    public static boolean del_user(List<User> users) {

        System.out.print("Digite o cpf do usuário: ");
        String cpf = input.nextLine();
        User findUser = find_user(users, cpf);
        if (findUser == null) {

            System.out.println("Usuário não localizado!");

            return false;
        }
        else {

            users.remove(findUser);

            return true;
        }
    }

    public static void list_data(List<User> users) {

        System.out.println("*** Listando Usuários ***");
        for (User user : users) {

            System.out.println("Usuário: " + user.name + "(" + user.cpf + ") - Idade: " + user.age);
        }
        System.out.println("*** Fim da listagem ***\n");
    }

    public static void clean_data(List<User> users) {

        System.out.print("Tem certeza que deseja limpar a lista? (s/n)");
        String resp = input.nextLine();
        if (resp.equalsIgnoreCase("s") || resp.equalsIgnoreCase("sim")) {

            users.clear();
            System.out.println("Itens excluídos com sucesso!!! A lista está vazia!!!");
        }
    }

    public static void main(String[] args) {

        menu();
    }
}
