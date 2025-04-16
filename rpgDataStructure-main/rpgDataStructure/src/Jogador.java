import java.util.Scanner;

public class Jogador {
    // variaveis de input:
    Scanner sc = new Scanner(System.in);
    int intInput1, intInput2;
    String strInput1, strInput2, strInput3;

    private String nome,senha;
    private int idJogador;
    private double saldoCristais;
    private ListaEntidades personagens = new ListaEntidades();

    public ListaEntidades getPersonagens() {
        return personagens;
    }

    public void setPersonagens(ListaEntidades personagens) {
        this.personagens = personagens;
    }

    public int getIdJogador() {
        return idJogador;
    }

    public void setIdJogaor(int idJogador) {
        this.idJogador = idJogador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    

    public double getSaldoCristais() {
        return saldoCristais;
    }

    public void setSaldoCristais(double saldoCristais) {
        this.saldoCristais = saldoCristais;
    }

    public Jogador(){

    }

    public Jogador(int id){
        this.idJogador = id;
    }

    public Jogador(int idJogador, String nome, String senha) {
        this.idJogador = idJogador;
        this.nome = nome;
        this.senha = senha;
    }
    public Jogador cadastrar(int id){
        Jogador player = new Jogador(id);
        System.out.println("Nome:");
        player.setNome(sc.next());
        System.out.println("Senha:");
        player.setSenha(sc.next());
        return player;
    }
    public void criarPersonagem(int id){
        System.out.println("digite o nome do personagem: ");
        strInput2 = sc.nextLine();
        Personagem p = new Personagem(id, strInput2,  100);
        personagens.add(p);
        System.out.println("personagem "+p.getNome()+" criado com sucesso!");
        sc.nextLine();
    }

    public void selecionarPersonagem(){
        if(personagens.isEmpty()){
            System.out.println("voce ainda nao tem personagens criados.");
            sc.nextLine();
            return;
        }
        System.out.println("digite o nome do personagem que deseja jogar: \n");
        personagens.printCharacters();
        strInput1 = sc.nextLine();
        for(int i = 0; i < personagens.size(); i++){
            if(strInput1.equals(personagens.get(i).personagem.getNome())){
                // logica de selecao de personagem na batalha
            }
            if(i == personagens.size() - 1){
                System.out.println("personagem invalido.");
            }
        }
        sc.nextLine();
        return;

    }
}
