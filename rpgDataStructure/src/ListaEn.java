import java.util.EmptyStackException;

public class ListaEn {
    private Node head, tail;
    private int tamanho;

    public ListaEn() {
        this.head = null;
        this.tail = null;
        this.tamanho = 0;
    }
    
    public void add(String entrada) {
        Node newNode = new Node(entrada);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        tamanho++;
    }
    
    public String remove()throws EmptyStackException{
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        String entrada = head.entrada;
        if (head == tail) { 
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        tamanho--;
        return entrada;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    public int tamanho() {
        return tamanho;
    }

}
