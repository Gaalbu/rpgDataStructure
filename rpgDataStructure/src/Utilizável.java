public class Utilizável {
    /*
     * Essa Classe é para o uso de Itens ou Habilidades.
     * |->Inacabada❌.
     * |->Atualmente a classe funciona da seguinte maneira:
     * |-->Se o dano do Utilizável for positivo, ele é desferido contra a vida do oponente. Caso seja negativo, ele é cura para quem o utilizou. Se não houver dano, é uma habilidade.
     * |-->Caso o Utilizável seja uma habilidade, Usar retorna uma condição, aplicada em si, durante um turno, descrita na habilidade em si.
     */


    //ESCOLHAS PARA CONTEXTO:
    Utilizável pocaoCura = new Utilizável("Poção de Cura", "Cura", -10, 0);
    Utilizável espadaPedra = new Utilizável("Espada de Pedra", "Ataque", 5, 1);
    Utilizável esquiva = new Utilizável("Esquiva", "Desviar", 0, 2);
    Utilizável retomarFolego = new Utilizável("Retomar o fôlego", "Cura", -3, 3);
    private String nome, efeito;
    private int dano, id;
    
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
    public String getEfeito() {
        return efeito;
    }
    public void setEfeito(String efeito) {
        this.efeito = efeito;
    }
    public int getDano() {
        return dano;
    }
    public void setDano(int dano) {
        this.dano = dano;
    }
    public Utilizável(String nome, String efeito, int dano, int id) {
        this.nome = nome;
        this.efeito = efeito;
        this.dano = dano;
        this.id = id;
    }
    

    public void usar(Utilizável objeto, Entidade usuario, Entidade alvo){
        if (objeto.getEfeito() == "Cura"){
            if ((this.getDano()*-1) + usuario.getVidaAtual() > usuario.getVidaMaxima()){
                usuario.setVidaAtual(usuario.getVidaMaxima());
            }else{
                usuario.setVidaAtual(usuario.getVidaAtual() + (this.getDano()*-1));
            }
        }else if (objeto.getEfeito() == "Desviar"){
            usuario.setCondicao("Desviar");
        }else if (objeto.getEfeito() == "Ataque"){
            alvo.receberDano(dano);
        }
    }
}