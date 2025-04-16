public class ListaEntidades {
    NodeEntidades head;
    NodeEntidades tail;

    public ListaEntidades(){
        this.head = null;
        this.tail = null;
    }

    public void add(Entidade personagem){
        NodeEntidades newNode = new NodeEntidades(personagem);
        if(head == null){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
    }

    public NodeEntidades remove(){
        NodeEntidades returnableNode = head;
        if(head == null){
            System.out.println("esta lista esta vazia.");
            return null;
        }else if(head == tail){
            System.out.println("a partir de agora, essa lista esta vazia");
            head = null;
            tail = null;
            return returnableNode;
        }else{
            head = head.next;
            head.previous = null;
            return returnableNode;
        }
    }

    public NodeEntidades peek(){
        if(head == null){
            System.out.println("esta lista esta vazia.");
            return null;
        }else{
            return head;
        }

    }

    public boolean isEmpty(){
        return head == null;
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

    public NodeEntidades get(int index){
        NodeEntidades current = head;
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

    public NodeEntidades getByNome(String nome){
        NodeEntidades current = head;
        boolean achou = false;
        while(current != null){
            if(current.personagem.getNome().equals(nome)){
                achou = true;
                break;
            }
            current = current.next;
        }
        if(achou == true){
            return current;
        }
        return null;
    }

    public void insertByIndex(Entidade personagem, int index){
        NodeEntidades newNode = new NodeEntidades(personagem);
        NodeEntidades current = head;
        int contador = 0;
        if(index > size() || index < 0){
            throw new IndexOutOfBoundsException("indice invalido");
        }
        while(current != null && contador < index){
            contador++;
            current = current.next;
        }
        if(index == size() || head == null){
            add(newNode.personagem);
            return;
        }else if(current == head){
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
            return;
        }else{
            current.previous.next = newNode;
            newNode.previous = current.previous;
            newNode.next = current;
            current.previous = newNode;
            return;
        }
    
    }

    public NodeEntidades removeByIndex(int index){
        NodeEntidades current = head;
        NodeEntidades returnableNode;
        int contador = 0;
        if(index >= size() || index < 0){
            throw new IndexOutOfBoundsException("indice invalido");
        }
        while(current != null && contador < index){
            contador++;
            current = current.next;
        }
        returnableNode = current;
        if(current == head){
            return remove();
        }else if(current == tail){
            tail = tail.previous;
            tail.next = null;
            return returnableNode;
        }else{
            current.previous.next = current.next;
            current.next.previous = current.previous;
            current.next = null;
            current.previous = null;
            return returnableNode;
        }
    }

    public void printCharacters(){
        NodeEntidades current = head;
        while(current != null){
            System.out.println(current.personagem.getNome());
            current = current.next;
        }
    }

    public void exibirInfoPersonagens(){
        NodeEntidades current = head;
        int contador = 1;
        while(current != null){
            System.out.println("Exibindo o personagem " + contador + ": ");
            System.out.println("Nome do personagem: " + current.personagem.getNome());
            System.out.println("Vida atual do personagem: " + current.personagem.getVidaAtual());
            System.out.println("Nível do personagem: " + current.personagem.getNivel());
            System.out.println("Equipamento do personagem: " + current.personagem.itemEquipado.getNomeItem()+"  "+current.personagem.itemEquipado.getRaridadeItem());
            System.out.println("Dano do item: " + current.personagem.itemEquipado.getDanoItem());
            System.out.println("-------------------------------------");
            contador++;
            current = current.next;
        }
    }

    public NodeEntidades getHumanoPVE(){
        NodeEntidades current = head;
        while(current != null){
            if(current.personagem instanceof Personagem){
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void setarPosBatalhas(){
        NodeEntidades current = head;
        while(current != null){
            current.personagem.setPosBatalha();
        }
    }
}
