import java.util.Scanner;

public class Batalha {
    private int idBatalha, contadorDeTurnos;
    private String estadoBatalha;
    private ListaEntidades participantes;
    private ListaEntidades ordemTurnos;
    private PilhaEntidades colocacaoEntidades;
    
    Scanner sc = new Scanner(System.in);
    
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
            iniciarTurno();
        }
        setEstadoBatalha("finalizada");
        exibirRanking();
    }

    public void iniciarTurno(){
        setContadorDeTurnos(getContadorDeTurnos()+ 1);

        //participantes.peek().personagem --> acessa o proximo elemento (fazer logica de acao)
        
        if(ordemTurnos.peek().personagem.estaVivo()){
            ordemTurnos.add(ordemTurnos.remove().personagem); 
        }else{
            colocacaoEntidades.push(ordemTurnos.remove().personagem);
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
