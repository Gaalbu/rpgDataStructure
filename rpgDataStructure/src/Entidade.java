public abstract class Entidade {
    String id,nome,condicao;
    int vidaMaxima,vidaAtual;
    ListaEn habilidades;
    ListaEn Inventário;
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
}
