package view;

import Controller.OpcoesMenu.AlterarPet;
import Controller.OpcoesMenu.BuscaPet;
import Controller.OpcoesMenu.CadastrarPet;

import java.io.File;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        CadastrarPet cadastrarPet = new CadastrarPet();
        Scanner input = new Scanner(System.in);
        int opcao;

        do{
            System.out.println("==== Menu principal ====");
            System.out.println("1. Cadastrar pet");
            System.out.println("2. Alterar os dados do pet cadastrado");
            System.out.println("3. Deletar um pet cadastrado");
            System.out.println("4. Listar todos os pets cadastrados");
            System.out.println("5. Listar pets por algum critério");
            System.out.println("6. Sair");
            opcao = input.nextInt();
            input.nextLine();

            switch (opcao){
                case 1:
                    cadastrarPet.cadastrar();
                    break;

                case 2:
                    File petArquivo = BuscaPet.buscarPet();
                    if (petArquivo != null) {
                        AlterarPet.alterarPet(petArquivo);
                        System.out.println("Você escolheu: " + petArquivo.getName());
                    }
            }
        } while (opcao != 6);

        input.close();

    }
}