package Controller;

import Controller.EnumUtils.EnumUtils;
import model.Pet;

import java.util.Scanner;

public class CadastrarPet {
   public void cadastrar() {
        Scanner input = new Scanner(System.in);
        FileRepository fileRepository = new FileRepository();
        Pet pet = new Pet();

        //Opção n1
        System.out.println(FileRepository.readSpecifyLine(1));

        String resposta = input.nextLine();

        try {
            pet.setNome(resposta);
        } catch (IllegalArgumentException e){

            System.out.println("Erro: " + e.getMessage());
        }


        // Opção n2
        System.out.println(FileRepository.readSpecifyLine(2));
        Pet.TipoPet tipoPet = null;
        while (tipoPet == null){
            try {
                tipoPet = EnumUtils.parseTipoPet(input.nextLine());
                pet.setTipoPet(tipoPet);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

       //Opção n3
       System.out.println(FileRepository.readSpecifyLine(3));
       Pet.SexoPet sexoPet = null;
       while (sexoPet == null){
           try {
               sexoPet = EnumUtils.parseSexoPet(input.nextLine());
               pet.setSexoPet(sexoPet);

           } catch (IllegalArgumentException e){
               System.out.println(e.getMessage());
           }
       }

       //Opção n4
       System.out.println(FileRepository.readSpecifyLine(4));

       System.out.println("Digite o numero da casa: ");
       String numeroCasa = input.nextLine();
       if (numeroCasa.isBlank()) numeroCasa = "Não informado";

       System.out.println("Digite a rua: ");
       String rua = input.nextLine();
       if (rua.isBlank()) rua = "Não informada";

       System.out.println("Digite o nome da cidade: ");
       String cidade = input.nextLine();
       if (cidade.isBlank()) rua = "Não informada";

       String endCompleto = "Rua " + rua + "Numero da casa " + numeroCasa + "Cidade: " + cidade;
       pet.setEndereco(endCompleto);

       //Opção n5
       System.out.println(FileRepository.readSpecifyLine(5));

       while (true){
           String idadePet = input.nextLine().replace(",", ".");
           if (idadePet.isBlank()){
               idadePet = "Idade Não informada";
               break;
           }

           try {
               double idade = Double.parseDouble(idadePet);

               if (idade > 20) throw new IllegalArgumentException("Idade inválida maior que 20 anos");
               pet.setIdade(idade < 1 ? (int) idade : (int) idade);
               break;

           } catch (IllegalArgumentException e){
               System.out.println("Digite um numero válido (0.5 ou 3)");
           }
       }

       //Opção n6
   }




}
