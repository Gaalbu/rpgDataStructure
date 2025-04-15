public class Personagem extends Entidade{
    
    // criacao da classe personagem

    public Personagem(int id, String nome, String condicao, int vidaMaxima) {
        super(id, nome, condicao, vidaMaxima);
        this.vidaMaxima = vidaMaxima;
        this.vidaAtual = vidaMaxima;
        this.nivel = 0;
        this.Inventário = null;
        this.habilidades = null;
    }

    public Personagem(String nome, String condicao, int vidaMaxima){
        super(nome, condicao, vidaMaxima);
    }

}
