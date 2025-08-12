package Controller.OpcoesMenu;

import java.io.*;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BuscaPet {


    public static File buscarPet(){
        Scanner sc = new Scanner(System.in);
        File pasta = new File("petsCadastrados");
        File[] arquivos = pasta.listFiles(((dir, name) -> name.endsWith(".txt")));

        if (arquivos == null || arquivos.length == 0){
            System.out.println("Nenhum pet está cadastrado");
            return null;
        }

        while (true){
            System.out.println("Digite um critério de busca (nome, raça, etc.):");
            String termoBusca = sc.nextLine().trim();
            String termoNormalizado = normalizar(termoBusca);

            List<File> resultados = new ArrayList<>();

            for (File arquivo: arquivos){
                try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
                    String linha;
                    while ((linha = br.readLine()) != null){
                        if (normalizar(linha).contains(termoNormalizado)){
                            resultados.add(arquivo);
                            break;
                        }
                    }
                } catch (IOException e){
                    e.printStackTrace();
                }
            }

            if (resultados.isEmpty()){
                System.out.println("Nenhum pet encontrado. tente Novamente");
                continue;
            }

            System.out.println("=== Resultados da busca ===");
            for (int i = 0; i < resultados.size(); i++){
                System.out.println((i + 1) + " - " + resultados.get(i). getName());
            }

            System.out.println("Digite o número do pet para selecionar: ");
            try {
                int escolha =  Integer.parseInt(sc.nextLine());
                if (escolha >= 1 && escolha <= resultados.size()) {
                    return resultados.get(escolha - 1);
                } else {
                    System.out.println("Número inválido. Tente novamente.");
                }
            } catch (NumberFormatException e){
                System.out.println("Entrada inválida, tente novamente " + e.getMessage());
            }
        }

    }

    public static String normalizar(String texto){
        return Normalizer
                .normalize(texto, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "")
                .toLowerCase();
    }
}
