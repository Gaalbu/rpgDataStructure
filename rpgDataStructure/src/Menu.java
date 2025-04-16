import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    /*
     * Essa Classe é o Menu em que o progama roda, sendo executada na main.
     * |->Classe inacabada❌.
     */
    Scanner sc = new Scanner(System.in);
    public void iniciar(){        
        int escolhaInicial, escolhaSecundaria,idAtual = 0;
        String nomeLogin, senhaLogin;
        ArrayList<Jogador> jogadores = new ArrayList<Jogador>(); //lista vazia de jogadores.
        Jogador jogadorEscolhido = null;
        //EFETUANDO O LOOP DO MENU;
        do{
            //Resetando variáveis de escolha e login.
            senhaLogin = "";
            nomeLogin = "";
            escolhaInicial = -1;
            escolhaSecundaria = -1;
            //Printando menu
            System.out.println("====================MENU===============");
            System.out.println("Escolha abaixo o que deseja fazer.");
            System.out.println("1.Cadastro/Autenticar");
            System.out.println("2.Verificar personagem");
            System.out.println("3.Selecionar batalha");
            System.out.println("4.Finalizar");
            System.out.println("=======================================");
            escolhaInicial = sc.nextInt();
            switch (escolhaInicial) {
                case 1:
                    if (jogadores.size() == 0){ //Sem jogadores, então cria
                        Jogador player = new Jogador();
                        Jogador novo_jogador = player.cadastrar(idAtual++);
                        //Jogador player = Jogador.cadastrar(idAtual++); //Cadastra o player e tbm passa o contador de Id para frente.
                        jogadores.add(novo_jogador);
                        System.out.println("Seu nome:"+novo_jogador.getNome()+", Senha:"+novo_jogador.getSenha());
                    }else{
                        System.out.println("Já foram castrados os seguintes jogadores:");
                        for (Jogador jogador : jogadores) {
                            System.out.println(jogador.getNome());
                        }
                        System.out.println("Deseja cadastrar['1'] ou entrar na conta['2']?");
                        escolhaSecundaria = sc.nextInt();
                        sc.nextLine();
                        switch (escolhaSecundaria) {
                            case 1:
                                Jogador player = new Jogador();
                                Jogador novo_jogador = player.cadastrar(idAtual++);
                                jogadores.add(novo_jogador);
                                System.out.println("Seu nome:"+novo_jogador.getNome()+", Senha:"+novo_jogador.getSenha());
                                break;
                            case 2:
                                System.out.println("Digite o nome da conta:");
                                nomeLogin = sc.nextLine();
                                System.out.println("Digite a senha da conta:");
                                senhaLogin = sc.nextLine();
                                for (Jogador jogador : jogadores) { //Percorrendo e locando o jogador.
                                    if (jogador.getNome().equals(nomeLogin) && jogador.getSenha().equals(senhaLogin)){
                                        jogadorEscolhido = jogador; // Conta encontrada!
                                        break;
                                    }
                                }
                                if (jogadorEscolhido != null){ //Mensagem de retorno positivo.
                                    System.out.println("Login efetuado com sucesso! Bem vindo, "+jogadorEscolhido.getNome()+"!");
                                }else{
                                    System.out.println("Nenhuma conta associada foi encontrada! Login falhou.");
                                }
                                break;
                            default:
                                System.out.println("Entrada inválida");
                                break;
                        }
                    }
                    
                    break;
                
                case 2:
                    if (jogadorEscolhido == null){
                        System.out.println("Erro! Você não está em conta alguma. Cadastre ou entre em uma!");
                    }else{
                        
                        
                    }
                    

                    break;
                case 4:
                    //Escolha de finalização, deixar ausente o campo.
                    break;
            
                default:
                    System.out.println("Entrada inválida");
                    break;
            }



        }while(escolhaInicial != 4);
    }
}
