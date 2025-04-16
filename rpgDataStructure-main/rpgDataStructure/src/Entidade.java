public abstract class Entidade {
    private int id;
    private String nome;
    private int vidaMaxima,vidaAtual, nivel;
    private boolean defendendo, superDefesa, espinhos;
    private int mana=2;
    ListaDeItem inventario = new ListaDeItem();
    Item itemEquipado;

    public Entidade(String nome, int vidaMaxima){
        this.nome = nome;
        this.vidaMaxima = vidaMaxima;
        this.vidaAtual = vidaMaxima;
        this.nivel = 1;
    }
    
    public Entidade(int id, String nome, int vidaMaxima) {
        this.id = id;
        this.nome = nome;
        this.vidaMaxima = vidaMaxima;
        this.vidaAtual = vidaMaxima;
        this.nivel = 1;
    }

    public Entidade(String nome, int vidaMaxima, int nivel){
        this.nome = nome;
        this.vidaMaxima = vidaMaxima;
        this.vidaAtual = vidaMaxima;
        this.nivel = nivel;
    }

    

    public boolean isDefendendo() {
        return defendendo;
    }

    public void setDefendendo(boolean defendendo) {
        this.defendendo = defendendo;
    }

    public boolean isSuperDefesa() {
        return superDefesa;
    }

    public void setSuperDefesa(boolean superDefesa) {
        this.superDefesa = superDefesa;
    }

    public boolean isEspinhos() {
        return espinhos;
    }

    public void setEspinhos(boolean espinhos) {
        this.espinhos = espinhos;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
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
                System.out.println(nome+" desferiu "+ (this.itemEquipado.getDanoItem()/3)+" em "+entidade.nome+ " com uma "+ itemEquipado.getNomeItem()+", mas sofreu "+(this.itemEquipado.getDanoItem()/3)+" por conta dos espinhos");
            }else if(entidade.superDefesa == true){
                entidade.vidaAtual = entidade.vidaAtual - 0;
                entidade.superDefesa = false;
                setVidaAtual(getVidaAtual() - this.itemEquipado.getDanoItem()/3);
                System.out.println(nome+" desferiu um ataque em "+entidade.nome+ " com uma "+ itemEquipado.getNomeItem()+", mas foi bloqueado pela super defesa e sofreu "+(this.itemEquipado.getDanoItem()/3)+" por conta dos espinhos");
            }
            else {
                entidade.vidaAtual = entidade.vidaAtual - this.itemEquipado.getDanoItem();
                setVidaAtual(getVidaAtual() - this.itemEquipado.getDanoItem()/3);
                System.out.println(nome+" desferiu "+ this.itemEquipado.getDanoItem()+" em "+entidade.nome+ " com uma "+ itemEquipado.getNomeItem()+", mas sofreu "+(this.itemEquipado.getDanoItem()/3)+" por conta dos espinhos");
            }

        }else{
            if(entidade.defendendo == true){
                entidade.vidaAtual = entidade.vidaAtual - (this.itemEquipado.getDanoItem())/3;
                entidade.defendendo = false;
                System.out.println(nome+" desferiu "+ (this.itemEquipado.getDanoItem()/3)+" em "+entidade.nome+ " com uma "+ itemEquipado.getNomeItem());
            }else if(entidade.superDefesa == true){
                entidade.vidaAtual = entidade.vidaAtual - 0;
                entidade.superDefesa = false;
                System.out.println(nome+" desferiu um ataque em "+entidade.nome+ " com uma "+ itemEquipado.getNomeItem()+", mas foi bloqueado pela super defesa");
            }
            else {
                entidade.vidaAtual = entidade.vidaAtual - this.itemEquipado.getDanoItem();
                System.out.println(nome+" desferiu "+ this.itemEquipado.getDanoItem()+" em "+entidade.nome+ " com uma "+ itemEquipado.getNomeItem());
            }
        }


    }
    public void defender(){
        this.defendendo = true;
        System.out.println(nome+" acionou defesa");
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

    public void subirNivel(){
        this.vidaMaxima = this.vidaMaxima + 20;
        this.vidaAtual = this.vidaMaxima;
        setNivel(getNivel()+1);
        System.out.println(nome+" subiu um nivel");
        System.out.println("Vida maxima: "+this.vidaMaxima);
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
                    System.out.println(nome+" desferiu um super ataque que causou "+ ((this.itemEquipado.getDanoItem()/3)*2)+" em "+entidade.nome+ " com uma "+ itemEquipado.getNomeItem()+", mas sofreu "+(this.itemEquipado.getDanoItem()/3)+" por conta dos espinhos");
                }else if(entidade.superDefesa == true){
                    entidade.vidaAtual = entidade.vidaAtual - 0;
                    entidade.superDefesa = false;
                    setVidaAtual(getVidaAtual() - this.itemEquipado.getDanoItem()/3);
                    System.out.println(nome+" desferiu um super ataque em "+entidade.nome+ " com uma "+ itemEquipado.getNomeItem()+", mas foi bloqueado pela super defesa e sofreu "+(this.itemEquipado.getDanoItem()/3)+" por conta dos espinhos");
                }
                else {
                    entidade.vidaAtual = entidade.vidaAtual - this.itemEquipado.getDanoItem()*2;
                    setVidaAtual(getVidaAtual() - this.itemEquipado.getDanoItem()/3);
                    System.out.println(nome+" desferiu um super ataque que causou"+ (this.itemEquipado.getDanoItem()*2)+" em "+entidade.nome+ " com uma "+ itemEquipado.getNomeItem()+", mas sofreu "+(this.itemEquipado.getDanoItem()/3)+" por conta dos espinhos");
                }

            }else{
                if(entidade.defendendo == true){
                    entidade.vidaAtual = entidade.vidaAtual - ((this.itemEquipado.getDanoItem())/3)*2;
                    entidade.defendendo = false;
                    System.out.println(nome+" desferiu um super ataque que causou "+ ((this.itemEquipado.getDanoItem()/3)*2)+" em "+entidade.nome+ " com uma "+ itemEquipado.getNomeItem());
                }else if(entidade.superDefesa == true){
                    entidade.vidaAtual = entidade.vidaAtual - 0;
                    entidade.superDefesa = false;
                    System.out.println(nome+" desferiu um super ataque em "+entidade.nome+ " com uma "+ itemEquipado.getNomeItem()+", mas foi bloqueado pela super defesa");
                }
                else {
                    entidade.vidaAtual = entidade.vidaAtual - this.itemEquipado.getDanoItem()*2;
                    System.out.println(nome+" desferiu um super ataque que causou"+ (this.itemEquipado.getDanoItem()*2)+" em "+entidade.nome+ " com uma "+ itemEquipado.getNomeItem());
                }
            }
            mana--;
        }


    }

    public void superDefesa() {
        if (mana>0){
            this.superDefesa = true;
            mana--;
            System.out.println(nome+" acionou super defesa");
        }else{
            System.out.println("Voce não tem mana para usar as habilidades!");
        }

    }

    public void setPosBatalha(){
        this.vidaAtual = vidaMaxima;
        this.mana = 2;
        this.defendendo = false;
        this.espinhos = false;
        this.superDefesa = false;
    }
}
