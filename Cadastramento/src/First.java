package br.pucpr.aula02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class First {

    static Scanner input=new Scanner(System.in);

    public static void menu(){

        List<User> users=new ArrayList<>();

        while (true) {
            System.out.println("*** Sistema de Cadastro ***");
            System.out.println("1. Cadastrar usuário");
            System.out.println("2. Editar dados do usuário");
            System.out.println("3. Excluir usuário");
            System.out.println("4. Listar");
            System.out.println("5. Limpar dados");
            System.out.println("6. Sair\n");
            System.out.print("Digite a opção que deseja: ");

            int op=input.nextInt();
            switch (op) {
                case 1:
                    if (add_user(users)) {
                        System.out.println("Usuário cadastrado com sucesso!");
                    }
                    else {
                        System.out.println("Problemas ao tentar cadastrar usuário.");
                    }
                    break;
                case 2:
                    edit_user();
                    break;
                case 3:
                    del_user();
                    break;
                case 4:
                    list_data(users);
                    break;
                case 5:
                    clean_data();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }

    public static boolean add_user(List<User> users){

        System.out.print("Digite o CPF do usuário: ");
        String cpf=input.next();
        User findUser=find_user(users, cpf);
        if (findUser != null){

            System.out.println("Usuário já cadastrado: "+findUser.name);
            return false;
        }
        System.out.print("Digite o nome do usuário: ");
        String name=input.next();
        System.out.print("Digite a idade do usuário: ");
        int age= input.nextInt();

        User user=new User();
        user.cpf=cpf;
        user.name=name;
        user.age=age;

        return users.add(user);
    }

    public static User find_user(List<User> users, String cpf){

        for (User user:users){

            if (user.cpf.equalsIgnoreCase(cpf)){

                return user;
            }
        }

        return null;
    }

    public static void edit_user(){


    }

    public static void del_user(){


    }

    public static void list_data(List<User> users){

        System.out.println("*** Listando usuários ***");
        for (User user:users) {

            System.out.println("Usuário: " +user.name+ "(" +user.cpf+ ") - Idade: " +user.age);
        }
        System.out.println("*** Fim da listagem ***\n");
    }

    public static void clean_data(){


    }

    public static void main(String[] args) {

        menu();
    }
}



