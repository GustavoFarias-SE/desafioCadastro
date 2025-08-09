package Controller.OpcoesMenu;

import Controller.EnumUtils.EnumUtils;
import Controller.Files.FileRepository;
import Controller.Files.PetWriter;
import model.Pet;

import java.util.Scanner;

public class CadastrarPet {
   public void cadastrar() {
        Scanner input = new Scanner(System.in);
        FileRepository fileRepository = new FileRepository();
        Pet pet = new Pet();

        //Opção n1
       System.out.println(FileRepository.readSpecifyLine(1));

       while (true) {
           String resposta = input.nextLine();
           try {
               pet.setNome(resposta);
               break;
           } catch (IllegalArgumentException e) {
               System.out.println("Erro: " + e.getMessage());
           }
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
       if (numeroCasa.isBlank()) numeroCasa = Pet.naoInformado;

       System.out.println("Digite a rua: ");
       String rua = input.nextLine();
       if (rua.isBlank()) rua = Pet.naoInformado;

       System.out.println("Digite o nome da cidade: ");
       String cidade = input.nextLine();
       if (cidade.isBlank()) rua = Pet.naoInformado;

       String endCompleto = "Rua " + rua + ", Numero da casa " + numeroCasa + ", Cidade: " + cidade;
       pet.setEndereco(endCompleto);

       //Opção n5
       System.out.println(FileRepository.readSpecifyLine(5));

       while (true){
           String idadePet = input.nextLine().replace(",", ".");
           if (idadePet.isBlank()){
               idadePet = Pet.naoInformado;
               break;
           }

           try {
               double idade = Double.parseDouble(idadePet);

               if (idade > 20) throw new IllegalArgumentException("Idade inválida maior que 20 anos");
               pet.setIdade((int) idade);
               break;

           } catch (IllegalArgumentException e){
               System.out.println("Digite um numero válido (0.5 ou 3)");
           }
       }

       //Opção n6
       System.out.println(FileRepository.readSpecifyLine(6));

       while (true){
           String peso = input.nextLine().replace(",", ".").trim();

           if (peso.isBlank()){
               peso = Pet.naoInformado;
               break;
           }

           try {
               double pesoD = Double.parseDouble(peso);

               if (pesoD < 0.5 || pesoD > 60) throw new IllegalArgumentException("O peso deve estar entre 0.5Kg e 60Kg");

               pet.setPeso(pesoD);
               break;
           } catch (IllegalArgumentException e){
               System.out.println(e.getMessage());
           }
       }

       //Opção n7
       System.out.println(FileRepository.readSpecifyLine(7));

       while (true){
           String raca = input.nextLine().trim();

           if (raca.isBlank()){
               pet.setRaca(Pet.naoInformado);
               break;
           } else if (!raca.matches("[A-Za-zÀ-ÿ\\s]+")) {
               System.out.println("Raça inválida. Digite apenas letras (sem números ou símbolos)");
               
           } else {
               pet.setRaca(raca);
               break;
           }
       }

       System.out.println("Pet cadastrado com sucesso");
       System.out.println(pet);
       PetWriter.salvarPetEmArquivo(pet);
   }




}
