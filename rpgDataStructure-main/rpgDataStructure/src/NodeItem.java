public class NodeItem {
    
    Item item;
    NodeItem prev;
    NodeItem next;

    public NodeItem(Item item) {
        this.item = item;
        this.prev = null;
        this.next = null;
    }

}
