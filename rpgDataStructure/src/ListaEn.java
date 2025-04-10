import java.util.EmptyStackException;

public class ListaEn {
    private Node head, tail;
    private int tamanho;

    public ListaEn() {
        this.head = null;
        this.tail = null;
        this.tamanho = 0;
    }

    // Adiciona um elemento ao final da lista
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

    // Remove o primeiro elemento da lista
    public String remove()throws EmptyStackException{
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        String data = head.data;
        if (head == tail) { // Apenas um elemento na lista
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        tamanho--;
        return data;
    }

    // Verifica se a lista está vazia
    public boolean isEmpty() {
        return head == null;
    }

    // Retorna o tamanho da lista
    public int tamanho() {
        return tamanho;
    }

    // Classe interna para representar um nó da lista
    private static class Node {
        String data;
        Node next, prev;

        Node(String data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
}
