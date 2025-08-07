package Controller;

import java.util.Scanner;

public class MenuInicial {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (true) {
            // Menu Inicial
            System.out.println("=== Menu Pet ===");
            System.out.println("1. Cadastrar um novo Pet");
            System.out.println("2. Alterar os dados do pet cadastrado");
            System.out.println("3. Deletar um pet cadastrado");
            System.out.println("4. Listar todos os pets cadastrados");
            System.out.println("5. Listar pets por algum critério");
            System.out.println("6. Sair");

            String escolha = scanner.nextLine();

            //Verificar se o usuário está digitando numeros
            if (!escolha.matches("\\d+")){
                System.out.println("Entrada Inválida! Digite apenas números positivos");
                continue;
            }

            opcao = Integer.parseInt(escolha);

            //Verificação dos numeros corretos
            if (opcao < 1 || opcao > 6){
                System.out.println("Opção inválida, tente novamente");
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.println("Escolha: cadastrar novo pet");
                    break;
                case 2:
                    System.out.println("Escolha: Alterar os dados do pet cadastrado");
                    break;
                case 3:
                    System.out.println("Escolha: Deletar um pet cadastrado");
                    break;
                case 4:
                    System.out.println("Escolha: Listar todos os pets cadastrados");
                    break;
                case 5:
                    System.out.println("Escolha: Listar pets por algum critério");
                    break;
                case 6:
                    System.out.println("Saindo...");
                return;
            }

        }
    }
}
