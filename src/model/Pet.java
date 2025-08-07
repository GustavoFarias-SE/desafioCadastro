package model;

public class Pet {
    private String nome;
    private String raca;
    private String endereco;
    private int idade;
    private double peso;
    private TipoPet tipoPet;
    private SexoPet sexoPet;

//    public Pet(String nome, String raca, int idade, double peso) {
//        this.nome = nome;
//        this.raca = raca;
//        this.idade = idade;
//        this.peso = peso;
//    }

    public Pet(){

    }

    public enum TipoPet{
        CACHORRO,
        GATO
    }

    public enum SexoPet{
        MACHO,
        FEMEA
    }

    public SexoPet getSexoPet() {
        return sexoPet;
    }

    public void setSexoPet(SexoPet sexoPet) {
        this.sexoPet = sexoPet;
    }

    public TipoPet getTipoPet() {
        return tipoPet;
    }

    public void setTipoPet(TipoPet tipoPet) {
        this.tipoPet = tipoPet;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty() || !nome.contains(" ") || !nome.matches("[A-Za-z ]+")){
            throw new IllegalArgumentException("O pet deve ter um nome e um sobrenome");
        }

        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "nome='" + nome + '\'' +
                ", raca='" + raca + '\'' +
                ", idade=" + idade +
                ", peso=" + peso +
                '}';
    }
}
