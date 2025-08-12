package Controller.OpcoesMenu;

import java.io.*;
import java.util.Scanner;

public class AlterarPet{

    private static final String Pasta_pets = "petsCadastrados";

    public static void alterarPet(File petArquivo){

        if (petArquivo == null) return;

        try {
            BufferedReader br = new BufferedReader(new FileReader(petArquivo));
            String nome = br.readLine();
            String tipo = br.readLine();
            String sexo = br.readLine();
            String endereco = br.readLine();
            String idade = br.readLine();
            String peso = br.readLine();
            String raca = br.readLine();
            br.close();

            Scanner sc = new Scanner(System.in);

            System.out.println("=== Alterando pet: " + nome + " ===");
            System.out.println("Tipo: " + tipo + " (não pode alterar)");
            System.out.println("Sexo: " + sexo + " (não pode alterar)");

            System.out.println("Novo nome (" + nome + "): ");
            String novoNome = sc.nextLine().trim();
            if (novoNome.isEmpty()) novoNome = nome;

            System.out.println("Novo endereço (" + endereco + "): ");
            String novoEndereco = sc.nextLine().trim();
            if (novoEndereco.isEmpty()) novoEndereco = endereco;

            System.out.println("Nova idade (" + idade + "): ");
            String novaIdade = sc.nextLine().trim();
            if (novaIdade.isEmpty()) novaIdade = idade;

            System.out.println("Novo peso (" + peso + "): ");
            String novoPeso = sc.nextLine().trim();
            if (novoPeso.isEmpty()) novoPeso = peso;

            System.out.println("Nova raça (" + raca + "): ");
            String novaRaca = sc.nextLine().trim();
            if (novaRaca.isEmpty()) novaRaca = raca;

            BufferedWriter bw =new BufferedWriter(new FileWriter(petArquivo, false));
            bw.write(novoNome + "\n");
            bw.write(tipo + "\n");
            bw.write(sexo + "\n");
            bw.write(novoEndereco + "\n");
            bw.write(novaIdade + "\n");
            bw.write(novoPeso + "\n");
            bw.write(novaRaca + "\n");
            bw.close();

            System.out.println("Pet Alterado com sucesso " + "\n");

        } catch (IOException e) {
            System.out.println("Erro ao alterar pet: " + e.getMessage());
        }
    }

}
