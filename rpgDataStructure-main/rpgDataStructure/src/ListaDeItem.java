public class ListaDeItem {
    
    NodeItem head;
    NodeItem tail;

    public ListaDeItem(){
        this.head = null;
        this.tail = null;
    }

    public void add(Item item){
        NodeItem newNode = new NodeItem(item);
        if(head == null){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public int size(){
        NodeItem current = head;
        int contador = 0;
        while(current != null){
            contador++;
            current = current.next;
        }
        return contador;
    }

    public NodeItem get(int index){
        NodeItem current = head;
        int contador = 0;
        if(index >= size() || index < 0){
            throw new IndexOutOfBoundsException();
        }
        while(current != null && contador < index){
            contador++;
            current = current.next;
        }
        return current;
    }

    public void printItens(){
        NodeItem current = head;
        int contador = 1;
        while(current != null){
            System.out.println(contador + "." + current.item.getNomeItem());
            contador++;
            current = current.next;
        }
    }
}
