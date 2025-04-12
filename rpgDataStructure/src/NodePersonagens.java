public class NodePersonagens {
    Personagem personagem;
    NodePersonagens next;
    NodePersonagens previous;

    public NodePersonagens(Personagem personagem){
        this.personagem = personagem;
        this.next = null;
        this.previous = null;
    }
}
