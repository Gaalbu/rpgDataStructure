public abstract class Entidade {
    int id;
    String nome;
    int vidaMaxima,vidaAtual, nivel;
    ListaDeItem inventario = new ListaDeItem();
    Item itemEquipado;

    public Entidade(String nome, int vidaMaxima){
        this.nome = nome;
        this.vidaMaxima = vidaMaxima;
        this.vidaAtual = vidaMaxima;
        this.nivel = 0;
    }
    
    public Entidade(int id, String nome, int vidaMaxima) {
        this.id = id;
        this.nome = nome;
        this.vidaMaxima = vidaMaxima;
        this.vidaAtual = vidaMaxima;
        this.nivel = 0;
    }


    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNivel() {
        return nivel;
    }


    public void setNivel(int nivel) {
        this.nivel = nivel;
    }


    public int getVidaMaxima() {
        return vidaMaxima;
    }


    public void setVidaMaxima(int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
    }


    public int getVidaAtual() {
        return vidaAtual;
    }


    public void setVidaAtual(int vidaAtual) {
        this.vidaAtual = vidaAtual;
    }


    public void atacar(Entidade entidade){
        entidade.vidaAtual = entidade.vidaAtual - this.itemEquipado.getDanoItem();
    }

    // finalizacao dos metodos da classe entidade, que vai ser herdada por personagem

    public void usarHabilidade(int idHabilidade, Personagem alvo){

    }

    public void curar(int valor){
        if(vidaMaxima - vidaAtual < valor){
            setVidaAtual(getVidaAtual()+valor);
        }else{
            setVidaAtual(vidaMaxima);
        }
    }

    public boolean estaVivo(){
        return vidaAtual >= 0;
    }

    public void subirNivel(int upgrade){
        setNivel(getNivel()+upgrade);
    }

    public void adicionarItem(Item item){
        if(inventario.size() == 0){
            itemEquipado = item;
        }
        inventario.add(item);

    }
}
