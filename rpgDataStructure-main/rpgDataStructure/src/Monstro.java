import java.util.Random;
import java.util.Scanner;

public class Monstro extends Entidade{
    
    private int danoMin, danoMax;
    Scanner s = new Scanner(System.in);
    
    public Monstro(String nome, int vidaMaxima, int danoMin, int danoMax, int nivel){
        super(nome, vidaMaxima, nivel);
        //this.vidaAtual = vidaMaxima;
        //this.nivel = nivel;
        this.danoMin = danoMin;
        this.danoMax = danoMax;
        itemEquipado = new Item(10, "garras","comum");
    }

    @Override
    public void atacar(Entidade entidade){
        Random r = new Random();
        int dano  = r.nextInt(danoMin,danoMax);
        if (entidade.isEspinhos()==true){ 
            if(entidade.isDefendendo() == true){
                entidade.setVidaAtual(entidade.getVidaAtual() - (dano/3));
                entidade.setDefendendo(false);
                setVidaAtual(getVidaAtual() - dano/3);
                System.out.println(getNome()+ "desferiu "+ dano/3+ " de dano em "+entidade.getNome()+", mas sofreu "+ dano/3+ "de dano por conta de espinhos");
            }else if(entidade.isSuperDefesa() == true){
                entidade.setVidaAtual(entidade.getVidaAtual() - 0);
                entidade.setSuperDefesa(false);
                setVidaAtual(getVidaAtual() - dano/3);
                System.out.println(getNome()+ "nao afetou"+entidade+" por conta da super defesa e sofreu "+ dano/3+ "de dano por conta de espinhos");
            }
            else {
                entidade.setVidaAtual(entidade.getVidaAtual() - dano);
                setVidaAtual(getVidaAtual() - dano/3);
                System.out.println(getNome()+ "desferiu "+ dano+ " de dano em "+entidade.getNome()+", mas sofreu "+ dano/3+ "de dano por conta de espinhos");
            }

        }else{
            if(entidade.isDefendendo() == true){
                entidade.setVidaAtual(entidade.getVidaAtual() - (dano/3));
                entidade.setDefendendo(false);
                System.out.println(getNome()+ "desferiu "+ dano/3+ " de dano em "+entidade.getNome());
            }else if(entidade.isSuperDefesa() == true){
                entidade.setVidaAtual(entidade.getVidaAtual() - 0);
                entidade.setSuperDefesa(false);
                System.out.println(getNome()+ "nao afetou"+entidade+" por conta da super defesa");
            }
            else {
                entidade.setVidaAtual(entidade.getVidaAtual() - dano);
                System.out.println(getNome()+ "desferiu "+ dano+ " de dano em "+entidade.getNome());
            }
        }
    }

    @Override
    public void superAtaque(Entidade entidade) {
        Random r = new Random();
        int dano  = r.nextInt(danoMin + 10,danoMax + 10);
            if (entidade.isEspinhos()==true){
                if(entidade.isDefendendo() == true){
                    entidade.setVidaAtual(entidade.getVidaAtual() - (dano/3));
                    entidade.setDefendendo(false);
                    setVidaAtual(getVidaAtual() - dano/3);
                    System.out.println(getNome()+ "desferiu um super ataque que causou "+ dano/3+ " de dano em "+entidade.getNome()+", mas sofreu "+ dano/3+ "de dano por conta de espinhos");
                }else if(entidade.isSuperDefesa() == true){
                    entidade.setVidaAtual(entidade.getVidaAtual() - 0);
                    entidade.setSuperDefesa(false);
                    setVidaAtual(getVidaAtual() - dano/3);
                    System.out.println(getNome()+ "um super ataque que nao afetou"+entidade+" por conta da super defesa e sofreu "+ dano/3+ "de dano por conta de espinhos");
                }
                else {
                    entidade.setVidaAtual(entidade.getVidaAtual() - dano);
                    setVidaAtual(getVidaAtual() - dano/3);
                    System.out.println(getNome()+ "desferiu um super ataque que causou "+ dano+ " de dano em "+entidade.getNome()+", mas sofreu "+ dano/3+ "de dano por conta de espinhos");
                }

            }else{
                if(entidade.isDefendendo() == true){
                    entidade.setVidaAtual(entidade.getVidaAtual() - (dano/3));
                    entidade.setDefendendo(false);
                    System.out.println(getNome()+ "desferiu um super ataque que causou "+ dano/3+ " de dano em "+entidade.getNome());
                }else if(entidade.isSuperDefesa() == true){
                    entidade.setVidaAtual(entidade.getVidaAtual() - 0);
                    entidade.setSuperDefesa(false);
                    System.out.println(getNome()+ "um super ataque que nao afetou"+entidade+" por conta da super defesa");
                }
                else {
                    entidade.setVidaAtual(entidade.getVidaAtual() - dano);
                    System.out.println(getNome()+ "desferiu um super ataque que causou "+ dano+ " de dano em "+entidade.getNome());
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
