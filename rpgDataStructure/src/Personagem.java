public class Personagem extends Entidade{
    
    // criacao da classe personagem

    public Personagem(int id, String nome, int vidaMaxima) {
        super(id, nome, vidaMaxima);
        this.vidaMaxima = vidaMaxima;
        this.vidaAtual = vidaMaxima;
        this.nivel = 1;
        Item item = new Item(15, "espada de madeira", "comum");
        adicionarItem(item);
        itemEquipado = item;
    }

    public Personagem(String nome,  int vidaMaxima){
        super(nome, vidaMaxima);
    }

}
