public abstract class Entidade {
    int id;
    String nome;
    int vidaMaxima,vidaAtual, nivel;
    boolean defendendo, superDefesa, espinhos;
    int mana=2;
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
        if (entidade.espinhos==true){
            if(entidade.defendendo == true){
                entidade.vidaAtual = entidade.vidaAtual - (this.itemEquipado.getDanoItem())/3;
                entidade.defendendo = false;
                setVidaAtual(getVidaAtual() - this.itemEquipado.getDanoItem()/3);
            }else if(entidade.superDefesa == true){
                entidade.vidaAtual = entidade.vidaAtual - 0;
                entidade.superDefesa = false;
                setVidaAtual(getVidaAtual() - this.itemEquipado.getDanoItem()/3);
            }
            else {
                entidade.vidaAtual = entidade.vidaAtual - this.itemEquipado.getDanoItem();
                setVidaAtual(getVidaAtual() - this.itemEquipado.getDanoItem()/3);
            }

        }else{
            if(entidade.defendendo == true){
                entidade.vidaAtual = entidade.vidaAtual - (this.itemEquipado.getDanoItem())/3;
                entidade.defendendo = false;
            }else if(entidade.superDefesa == true){
                entidade.vidaAtual = entidade.vidaAtual - 0;
                entidade.superDefesa = false;
            }
            else {
                entidade.vidaAtual = entidade.vidaAtual - this.itemEquipado.getDanoItem();
            }
        }


    }
    public void defender(){
        this.defendendo = true;
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
        return vidaAtual > 0;
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

    public void superAtaque(Entidade entidade) {
        if (mana==0){
            System.out.println("Voce não tem mais mana");
        }else{
            if (entidade.espinhos==true){
                if(entidade.defendendo == true){
                    entidade.vidaAtual = entidade.vidaAtual - ((this.itemEquipado.getDanoItem())/3)*2;
                    entidade.defendendo = false;
                    setVidaAtual(getVidaAtual() - this.itemEquipado.getDanoItem()/3);
                }else if(entidade.superDefesa == true){
                    entidade.vidaAtual = entidade.vidaAtual - 0;
                    entidade.superDefesa = false;
                    setVidaAtual(getVidaAtual() - this.itemEquipado.getDanoItem()/3);
                }
                else {
                    entidade.vidaAtual = entidade.vidaAtual - this.itemEquipado.getDanoItem()*2;
                    setVidaAtual(getVidaAtual() - this.itemEquipado.getDanoItem()/3);
                }

            }else{
                if(entidade.defendendo == true){
                    entidade.vidaAtual = entidade.vidaAtual - ((this.itemEquipado.getDanoItem())/3)*2;
                    entidade.defendendo = false;
                }else if(entidade.superDefesa == true){
                    entidade.vidaAtual = entidade.vidaAtual - 0;
                    entidade.superDefesa = false;
                }
                else {
                    entidade.vidaAtual = entidade.vidaAtual - this.itemEquipado.getDanoItem()*2;
                }
            }
            mana--;
        }


    }

    public void superDefesa() {
        if (mana>0){
            this.superDefesa = true;
            mana--;
        }else{
            System.out.println("Voce não tem mana para usar as habilidades!");
        }

    }
}
