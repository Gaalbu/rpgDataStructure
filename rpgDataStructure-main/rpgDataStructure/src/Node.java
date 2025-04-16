public class Node {
    /*
     * Essa Classe é o Node público de todas as listas/pilhas.
     * |->Classe acabada✅.
     */
    
    Node next, prev;
    String entrada;

    public Node(String entrada){
        this.next = null;
        this.prev = null;
        this.entrada = entrada;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }
    
}
