import java.util.Random;
import java.util.Scanner;

public class Monstro extends Entidade{
    
    private int danoMin, danoMax;
    Scanner s = new Scanner(System.in);
    
    public Monstro(String nome, int vidaMaxima, int danoMin, int danoMax, int nivel){
        super(nome, vidaMaxima);
        this.vidaAtual = vidaMaxima;
        this.nivel = nivel;
        this.danoMin = danoMin;
        this.danoMax = danoMax;
        itemEquipado = new Item(10, "garras","comum");
    }

    @Override
    public void atacar(Entidade entidade){
        Random r = new Random();
        int dano  = r.nextInt(danoMin,danoMax);
        if (entidade.espinhos==true){ 
            if(entidade.defendendo == true){
                entidade.vidaAtual = entidade.vidaAtual - dano/3;
                entidade.defendendo = false;
                setVidaAtual(getVidaAtual() - dano/3);
                System.out.println(nome+ "desferiu "+ dano/3+ " de dano em "+entidade.nome+", mas sofreu "+ dano/3+ "de dano por conta de espinhos");
            }else if(entidade.superDefesa == true){
                entidade.vidaAtual = entidade.vidaAtual - 0;
                entidade.superDefesa = false;
                setVidaAtual(getVidaAtual() - dano/3);
                System.out.println(nome+ "nao afetou"+entidade+" por conta da super defesa e sofreu "+ dano/3+ "de dano por conta de espinhos");
            }
            else {
                entidade.vidaAtual = entidade.vidaAtual - dano;
                setVidaAtual(getVidaAtual() - dano/3);
                System.out.println(nome+ "desferiu "+ dano+ " de dano em "+entidade.nome+", mas sofreu "+ dano/3+ "de dano por conta de espinhos");
            }

        }else{
            if(entidade.defendendo == true){
                entidade.vidaAtual = entidade.vidaAtual - (dano/3);
                entidade.defendendo = false;
                System.out.println(nome+ "desferiu "+ dano/3+ " de dano em "+entidade.nome);
            }else if(entidade.superDefesa == true){
                entidade.vidaAtual = entidade.vidaAtual - 0;
                entidade.superDefesa = false;
                System.out.println(nome+ "nao afetou"+entidade+" por conta da super defesa");
            }
            else {
                entidade.vidaAtual = entidade.vidaAtual - dano;
                System.out.println(nome+ "desferiu "+ dano+ " de dano em "+entidade.nome);
            }
        }
    }

    @Override
    public void superAtaque(Entidade entidade) {
        Random r = new Random();
        int dano  = r.nextInt(danoMin + 10,danoMax + 10);
            if (entidade.espinhos==true){
                if(entidade.defendendo == true){
                    entidade.vidaAtual = entidade.vidaAtual - (dano/3);
                    entidade.defendendo = false;
                    setVidaAtual(getVidaAtual() - dano/3);
                    System.out.println(nome+ "desferiu um super ataque que causou "+ dano/3+ " de dano em "+entidade.nome+", mas sofreu "+ dano/3+ "de dano por conta de espinhos");
                }else if(entidade.superDefesa == true){
                    entidade.vidaAtual = entidade.vidaAtual - 0;
                    entidade.superDefesa = false;
                    setVidaAtual(getVidaAtual() - dano/3);
                    System.out.println(nome+ "um super ataque que nao afetou"+entidade+" por conta da super defesa e sofreu "+ dano/3+ "de dano por conta de espinhos");
                }
                else {
                    entidade.vidaAtual = entidade.vidaAtual - dano;
                    setVidaAtual(getVidaAtual() - dano/3);
                    System.out.println(nome+ "desferiu um super ataque que causou "+ dano+ " de dano em "+entidade.nome+", mas sofreu "+ dano/3+ "de dano por conta de espinhos");
                }

            }else{
                if(entidade.defendendo == true){
                    entidade.vidaAtual = entidade.vidaAtual - (dano/3);
                    entidade.defendendo = false;
                    System.out.println(nome+ "desferiu um super ataque que causou "+ dano/3+ " de dano em "+entidade.nome);
                }else if(entidade.superDefesa == true){
                    entidade.vidaAtual = entidade.vidaAtual - 0;
                    entidade.superDefesa = false;
                    System.out.println(nome+ "um super ataque que nao afetou"+entidade+" por conta da super defesa");
                }
                else {
                    entidade.vidaAtual = entidade.vidaAtual - dano;
                    System.out.println(nome+ "desferiu um super ataque que causou "+ dano+ " de dano em "+entidade.nome);
                }
            }
        }

        public void sorteadorDeAtaque(Entidade entidade){
            Random r = new Random();
            int ataque = r.nextInt(0,10);

            if(ataque == 9){
                superAtaque(entidade);
            }else{
                atacar(entidade);
            }
            s.nextLine();
            return;
        }


}
