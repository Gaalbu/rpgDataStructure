import java.util.Random;
import java.util.Scanner;

public class Batalha {
    private int idBatalha, contadorDeTurnos;
    private String estadoBatalha;
    private ListaEntidades participantes;
    private ListaEntidades ordemTurnos;
    private PilhaEntidades colocacaoEntidades = new PilhaEntidades();

    Scanner sc = new Scanner(System.in);

    public PilhaEntidades getColocacaoEntidades() {
        return colocacaoEntidades;
    }
    public void setColocacaoEntidades(PilhaEntidades colocacaoEntidades) {
        this.colocacaoEntidades = colocacaoEntidades;
    }
    public int getIdBatalha() {
        return idBatalha;
    }
    public void setIdBatalha(int idBatalha) {
        this.idBatalha = idBatalha;
    }
    public int getContadorDeTurnos() {
        return contadorDeTurnos;
    }
    public void setContadorDeTurnos(int contadorDeTurnos) {
        this.contadorDeTurnos = contadorDeTurnos;
    }
    public String getEstadoBatalha() {
        return estadoBatalha;
    }
    public void setEstadoBatalha(String estadoBatalha) {
        this.estadoBatalha = estadoBatalha;
    }
    public ListaEntidades getParticipantes() {
        return participantes;
    }
    public void setParticipantes(ListaEntidades participantes) {
        this.participantes = participantes;
    }
    public ListaEntidades getOrdemTurnos() {
        return ordemTurnos;
    }
    public void setOrdemTurnos(ListaEntidades ordemTurnos) {
        this.ordemTurnos = ordemTurnos;
    }
    public Batalha(int idBatalha, ListaEntidades participantes) {
        this.idBatalha = idBatalha;
        this.participantes = participantes;
        this.contadorDeTurnos = 0;
        this.estadoBatalha = "andamento";
        this.ordemTurnos = participantes;
    }

    public void iniciarBatalha(){
        while(!verificarVencedor(ordemTurnos)){

            System.out.println("========================================");
            System.out.println("Vida do seu personagem: " + ordemTurnos.head.personagem.getVidaAtual());
            System.out.println("Mana do seu personagem: " + ordemTurnos.head.personagem.getMana());
            System.out.println("Vida do seu oponente: " + ordemTurnos.tail.personagem.getVidaAtual());
            System.out.println("Mana do seu oponente: " + ordemTurnos.tail.personagem.getMana());
            System.out.println("========================================");

            System.out.println("============OPCOES=DE=ATAQUE============");
            System.out.println("Escolha a opcao que o personagem: " + ordemTurnos.head.personagem.getNome() + " exercera."); // + personagem + exercera
            System.out.println("1.Atacar.");
            System.out.println("2.Habilidade.");
            System.out.println("3.Item.");
            System.out.println("4.Defender.");
            System.out.println("========================================");
            String opcao = sc.nextLine();
            
            switch (opcao) {
                case "1":
                    ordemTurnos.head.personagem.atacar(ordemTurnos.tail.personagem);
                    if(!ordemTurnos.tail.personagem.estaVivo()){
                        colocacaoEntidades.push(ordemTurnos.removeByIndex(1).personagem);
                    }
                    break;
                case "2":
                    System.out.println("1. Super Ataque");
                    System.out.println("2. Super Defesa");
                    String habilidade = sc.nextLine();
                    if (habilidade.equals("1")) {
                        ordemTurnos.head.personagem.superAtaque(ordemTurnos.tail.personagem);
                        if(!ordemTurnos.tail.personagem.estaVivo()){
                            colocacaoEntidades.push(ordemTurnos.removeByIndex(1).personagem);
                        }
                    }else if (habilidade.equals("2")) {
                        ordemTurnos.head.personagem.superDefesa();
                        if(!ordemTurnos.head.personagem.estaVivo()){
                            colocacaoEntidades.push(ordemTurnos.removeByIndex(0).personagem);
                        }
                    }
                    break;
                case "3":
                    System.out.println("1. Poção de cura");
                    System.out.println("2. Poção de cura maxima");
                    System.out.println("3. Poção de espinhos");
                    String cura = sc.nextLine();
                    if (cura.equals("1")) {
                        int contPocao=2;
                        if (contPocao >0){
                            ordemTurnos.head.personagem.setVidaAtual(ordemTurnos.head.personagem.getVidaAtual() + 30);
                            if (ordemTurnos.head.personagem.getVidaAtual()>100){
                                ordemTurnos.head.personagem.setVidaAtual(100);
                                System.out.println("Voce tem mais "+ contPocao+" uso dessa poção");
                            }else{
                                System.out.println("Voce não pode mais usar essa poção");
                            }
                        }
                    }
                    else if (cura.equals("2")) {
                        int contPocao=1;
                        if (contPocao >0){
                            ordemTurnos.head.personagem.setVidaAtual(ordemTurnos.head.personagem.getVidaMaxima());
                            System.out.println("Voce tem mais "+ contPocao+" uso dessa poção");
                        }else{
                            System.out.println("Voce não pode mais usar essa poção");
                        }
                    }
                    else if (cura.equals("3")) {
                        int contPocao=1;
                        if (contPocao >0){
                            ordemTurnos.head.personagem.setEspinhos(true);
                            System.out.println("Voce tem mais "+ contPocao+" uso dessa poção");
                        }else{
                            System.out.println("Voce não pode mais usar essa poção");
                        }

                    }
                    break;
                case "4":
                    ordemTurnos.head.personagem.defender();
                    if(!ordemTurnos.head.personagem.estaVivo()){
                        colocacaoEntidades.push(ordemTurnos.removeByIndex(0).personagem);
                    }
                    break;
                default:
                    System.out.println("Voce digitou algo errado!");
                    break;
            }
            iniciarTurno();
            setContadorDeTurnos(getContadorDeTurnos()+ 1);
        }

        setEstadoBatalha("finalizada");
        exibirRanking();
    }

    public void iniciarBatalhaPVE(){
        while(!verificarVencedor(ordemTurnos)){
            if(ordemTurnos.peek().personagem instanceof Personagem){
                System.out.println("========================================");
                System.out.println("Vida do defensor: " + ordemTurnos.tail.personagem.getVidaAtual());
                System.out.println("Vida do atacante: " + ordemTurnos.head.personagem.getVidaAtual());
                System.out.println("========================================");

                System.out.println("============OPCOES=DE=ATAQUE============");
                System.out.println("Escolha a opcao que o personagem: " + ordemTurnos.head.personagem.getNome() + " exercera.");
                System.out.println("1.Atacar.");
                System.out.println("2.Habilidade.");
                System.out.println("3.Item.");
                System.out.println("4.Defender.");
                System.out.println("5.Fugir");
                System.out.println("========================================");
                String opcao = sc.nextLine();
                
                switch (opcao) {
                    case "1":

                        ordemTurnos.head.personagem.atacar(ordemTurnos.tail.personagem);
                        if(!ordemTurnos.tail.personagem.estaVivo()){
                            colocacaoEntidades.push(ordemTurnos.removeByIndex(1).personagem);
                        }
                        break;
                    case "2":
                        System.out.println("1. Super Ataque");
                        System.out.println("2. Super Defesa");
                        String habilidade = sc.nextLine();
                        if (habilidade.equals("1")) {
                            ordemTurnos.head.personagem.superAtaque(ordemTurnos.tail.personagem);
                            if(!ordemTurnos.tail.personagem.estaVivo()){
                                colocacaoEntidades.push(ordemTurnos.removeByIndex(1).personagem);
                            }
                        }else if (habilidade.equals("2")) {
                            ordemTurnos.head.personagem.superDefesa();
                            if(!ordemTurnos.head.personagem.estaVivo()){
                                colocacaoEntidades.push(ordemTurnos.removeByIndex(0).personagem);
                            }
                        }
                        break;
                    case "3":
                        System.out.println("1. Poção de cura");
                        System.out.println("2. Poção de cura maxima");
                        System.out.println("3. Poção de espinhos");
                        String cura = sc.nextLine();
                        if (cura.equals("1")) {
                            int contPocao=2;
                            if (contPocao >0){
                                ordemTurnos.head.personagem.setVidaAtual(ordemTurnos.head.personagem.getVidaAtual() + 30);
                                if (ordemTurnos.head.personagem.getVidaAtual()>100){
                                    ordemTurnos.head.personagem.setVidaAtual(100);
                                    System.out.println("Voce tem mais "+ contPocao+" uso dessa poção");
                                }else{
                                    System.out.println("Voce não pode mais usar essa poção");
                                }
                            }
                        }
                        else if (cura.equals("2")) {
                            int contPocao=1;
                            if (contPocao >0){
                                ordemTurnos.head.personagem.setVidaAtual(ordemTurnos.head.personagem.getVidaMaxima());
                                System.out.println("Voce tem mais "+ contPocao+" uso dessa poção");
                            }else{
                                System.out.println("Voce não pode mais usar essa poção");
                            }
                        }
                        else if (cura.equals("3")) {
                            int contPocao=1;
                            if (contPocao >0){
                                ordemTurnos.head.personagem.setEspinhos(true);
                                System.out.println("Voce tem mais "+ contPocao+" uso dessa poção");
                            }else{
                                System.out.println("Voce não pode mais usar essa poção");
                            }

                        }
                        break;
                    case "4":
                        ordemTurnos.head.personagem.defender();
                        if(!ordemTurnos.head.personagem.estaVivo()){
                            colocacaoEntidades.push(ordemTurnos.removeByIndex(0).personagem);
                        }
                        break;
                    case "5":
                        Random r = new Random();
                        if(r.nextInt(5) == 4 || r.nextInt(5) == 3){
                            System.out.println("voce conseguiu fugir com exito!");
                            return;
                        }else{
                            System.out.println("voce nao conseguiu fugir dessa vez.");
                            break;
                        }
                    default:
                        System.out.println("Voce digitou algo errado!");
                        break;
                }
                iniciarTurno();
            }else{
                ((Monstro) participantes.peek().personagem).sorteadorDeAtaque(participantes.getHumanoPVE().personagem);
                iniciarTurno();
            }
            setContadorDeTurnos(getContadorDeTurnos()+ 1);

        }

        setEstadoBatalha("finalizada");
        exibirRanking();
    }

    public void iniciarTurno(){
        if(ordemTurnos.peek().personagem.estaVivo()){
            ordemTurnos.add(ordemTurnos.remove().personagem);
        }
    }

    public boolean verificarVencedor(ListaEntidades ordemTurno){
        NodeEntidades current = ordemTurno.head;
        NodeEntidades vitorioso = null;
        int contadorVivos  = 0;
        while(current!= null){
            if(current.personagem.estaVivo()){
                vitorioso = current;
                contadorVivos++;
            }
            current = current.next;
        }
        if(contadorVivos == 1){
            colocacaoEntidades.push(vitorioso.personagem);
            System.out.println("batalha encerrada!");
            return true;
        }
        return false;
    }

    public void exibirRanking(){
        colocacaoEntidades.printAll();
        System.out.println("numero de turnos: "+ getContadorDeTurnos());
        sc.nextLine();
    }


    

    

    
    
}
