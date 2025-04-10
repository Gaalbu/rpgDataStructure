import java.util.Scanner;

public class Jogador {
    Scanner sc = new Scanner(System.in);
    private String nome,senha;
    private int idJogador;
    // private Lista Personagens;

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

    public Jogador(int idJogador, String nome, String senha) {
        this.idJogador = idJogador;
        this.nome = nome;
        this.senha = senha;
        //this.personagens = null;
    }
    public void cadastrar(int id){
        System.out.println("Nome:");
        setNome(sc.next());
        System.out.println("Senha:");
        setSenha(sc.next());
        setIdJogaor(id);
    }
    public void criarPersonagem(){
        
    }
}
