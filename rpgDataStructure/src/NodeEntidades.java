public class NodeEntidades {
    Entidade personagem;
    NodeEntidades next;
    NodeEntidades previous;

    public NodeEntidades(Entidade personagem){
        this.personagem = personagem;
        this.next = null;
        this.previous = null;
    }
}
