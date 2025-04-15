public class Personagem extends Entidade{
    
    // criacao da classe personagem

    public Personagem(int id, String nome, String condicao, int vidaMaxima) {
        super(id, nome, condicao, vidaMaxima);
        this.vidaMaxima = vidaMaxima;
        this.vidaAtual = vidaMaxima;
        this.nivel = 0;
        Item item = new Item(15, "espada de madeira", "comum");
        adicionarItem(item);
    }

    public Personagem(String nome, String condicao, int vidaMaxima){
        super(nome, condicao, vidaMaxima);
    }

}
