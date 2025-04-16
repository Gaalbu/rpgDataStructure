import java.util.EmptyStackException;

public class PilhaEntidades {
    NodeEntidades head;

    public void push(Entidade personagem){
        NodeEntidades newNode = new NodeEntidades(personagem);
        if(head == null){
            head = newNode;
            return;
        }else{
            newNode.next = head;
            head = newNode;
            return;
        }
    }

    public NodeEntidades pop(){
        NodeEntidades returnableNode = head;
        if(head == null){
            throw new EmptyStackException();
        }else if(head.next ==  null){
            System.out.println(" a partir de agora, a pilha esta vazia");
            head = null;
            return returnableNode;
        }else{
            head = head.next;
            return returnableNode;
        }
    }

    public NodeEntidades peek(){
        if(head == null){
            throw new EmptyStackException();
        }else{
             return head;
        }
    }

    public int size(){
        NodeEntidades current = head;
        int contador = 0;
        while(current != null){
            contador++;
            current = current.next;
        }
        return contador;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void printAll(){
        NodeEntidades current = head;
        while(current != null){
            System.out.println(current.personagem.getNome()+" vida: "+ current.personagem.getVidaAtual());
            current = current.next;
        }
    }
}
