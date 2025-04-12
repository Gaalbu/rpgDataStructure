public abstract class Entidade {
    String id,nome,condicao;
    int vidaMaxima,vidaAtual, nivel;
    ListaEn habilidades;
    ListaEn Inventário;

    
    public Entidade(String id, String nome, String condicao, int vidaMaxima) {
        this.id = id;
        this.nome = nome;
        this.condicao = condicao;
        this.vidaMaxima = vidaMaxima;
        this.vidaAtual = vidaMaxima;
        this.nivel = 0;
    }


    public String getId() {
        return id;
    }


    public String getCondicao() {
        return condicao;
    }


    public void setCondicao(String condicao) {
        this.condicao = condicao;
    }


    public void setId(String id) {
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


    public void receberDano(int dano){
        this.vidaAtual = getVidaAtual() - dano;
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
        return vidaAtual <= 0;
    }

    public void subirNivel(int upgrade){
        setNivel(getNivel()+upgrade);
    }
}
