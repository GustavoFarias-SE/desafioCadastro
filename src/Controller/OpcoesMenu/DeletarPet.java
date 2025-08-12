package Controller.OpcoesMenu;

import java.io.File;
import java.util.Scanner;

public class DeletarPet {

    public static void deletarPet(){

        //Possivel MERDA que vai dar aqui, qualquer Coisa coloca no método
        File petArquivo = BuscaPet.buscarPet();

        if (petArquivo != null){
            System.out.println("Você escolheu: " + petArquivo.getName());

            Scanner sc = new Scanner(System.in);

            System.out.println("Tem certeza que deseja apagar o arquivo? (SIM/NÃO): ");
            String confirmed = sc.nextLine().trim().toUpperCase();

            if (confirmed.equals("SIM")) {
                if (petArquivo.delete()){
                    System.out.println("Pet deletado com sucesso!! ");
                } else {
                    System.out.println("Não foi possivel deletar o pet ");
                }
            } else {
                System.out.println("Operação cancelada");
            }
        } else {
            System.out.println("Nenhum pet encontrado");
        }

    }
}
