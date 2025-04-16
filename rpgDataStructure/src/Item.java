public class Item {
    
    private int danoItem;
    private String nomeItem;
    private String raridadeItem;

    public Item(int danoItem, String nomeItem, String raridadeItem) {
        this.danoItem = danoItem;
        this.nomeItem = nomeItem;
        this.raridadeItem = raridadeItem;
    }

    public int getDanoItem() {
        return danoItem;
    }
    public void setDanoItem(int danoItem) {
        this.danoItem = danoItem;
    }
    public String getNomeItem() {
        return nomeItem;
    }
    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }
    public String getRaridadeItem() {
        return raridadeItem;
    }
    public void setRaridadeItem(String raridadeItem) {
        this.raridadeItem = raridadeItem;
    }

}
