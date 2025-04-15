import java.util.ArrayList;
import java.util.Scanner;

public class MenuAlternativo {
    
    Scanner sc = new Scanner(System.in);
    public void Menu(){
        int idAtual = 0;
        int idPersonagemAtual = 0;
        Jogador jogadorAtual;
        ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
        while(true){
            while(true){
                if(jogadores.isEmpty()){
                    jogadores.add(cadastrar(idAtual++));
                }else{
                    while(true){
                        System.out.println("=======================================");
                        System.out.println("1.Criar uma conta.");
                        System.out.println("2.Fazer login na conta.");
                        System.out.println("3.Ver contas cadastradas.");
                        System.out.println("4.Sair do RPG.");
                        System.out.println("=======================================");
                        String escolha = sc.nextLine();
                        if(escolha.equals("1")){
                            jogadores.add(cadastrar(idAtual++));
                        }else if(escolha.equals("2")){
                            System.out.println("Digite o nome de usuario da Conta que deseja fazer login: ");
                            String usuario = sc.nextLine();
                            System.out.println("Digite a senha da Conta que deseja fazer login: ");
                            String senha = sc.nextLine();
                            jogadorAtual = login(jogadores, usuario, senha);
                            if(jogadorAtual == null){
                                System.out.println("Você digitou algo errado!");
                            }else{
                                break;
                            }
                        }else if(escolha.equals("3")){
                            System.out.println("\n\n\n\n\n\n\n\n\n");
                            System.out.println("=======================================");
                            System.out.println("Lista de jogadores cadastrados:");
                            for (Jogador jogador : jogadores) {
                                System.out.println("Jogador de id "+ jogador.getIdJogador() + ": " + jogador.getNome());
                            }

                        }else if(escolha.equals("4")){
                            return;
                        }else{
                            System.out.println("Voce digitou algo errado!");
                        }
                    }
                    break;
                }
            }
            telaPrincipal(jogadorAtual, idPersonagemAtual++);
        }
    }

    public Jogador cadastrar(int id){
        System.out.println("Digite o seu nome de usuário: ");
        String usuario = sc.nextLine();
        System.out.println("Digite a sua senha: ");
        String senha = sc.nextLine();
        Jogador player = new Jogador(id, usuario, senha);
        return player;
    }

    public Jogador login(ArrayList<Jogador> jogadores, String usuario, String senha){
        for (Jogador j : jogadores) {
            if(j.getNome().equals(usuario) && j.getSenha().equals(senha)){
                return j;
            }
        }
        return null;
    }

    public void telaPrincipal(Jogador jogador, int id){
        Jogador jogadorAtual = jogador;
        int idPersonagemAtual = id;
        while(true){
            System.out.println("====================MENU===============");
            System.out.println("Escolha abaixo o que deseja fazer.");
            System.out.println("1.Criar Personagem.");
            System.out.println("2.Atribuir pontos de atributos.");
            System.out.println("3.Comprar/Equipar itens.");
            System.out.println("4.Escolher modo de batalha.");
            System.out.println("5.Voltar pra tela de login.");
            System.out.println("=======================================");
            String escolha = sc.nextLine();

            switch (escolha) {
                case "1":
                    jogadorAtual.criarPersonagem(idPersonagemAtual++);
                    break;
                case "2":
                    if(jogadorAtual.getPersonagens().head == null){
                        System.out.println("Voce nao tem personagens criados!");
                        break;
                    }else{
                        System.out.println("Para qual personagem voce deseja atribuir pontos de nivel?");
                        jogadorAtual.getPersonagens().printCharacters();
                        String escPerso = sc.nextLine();
                        System.out.println("Quantos pontos voce deseja atribuir ao personagem: " + escPerso + "?");
                        String pontosTemp = sc.nextLine();
                        try {
                            jogadorAtual.getPersonagens().getByNome(escPerso).personagem.subirNivel(Integer.parseInt(pontosTemp));
                        } catch (Exception e) {
                            System.out.println("Voce digitou o nome do personagem ou a quantidade de pontos de maneira incorreta!");
                        }
                    }
                    break;
                case "3":
                    while(true){
                        System.out.println("Voce deseja comprar ['1'] ou equipar itens ['2']?");
                        String escTemp = sc.nextLine();
                        if(escTemp.equals("1")){

                            // falta fazer

                        }else if(escTemp.equals("2")){

                            // Falta fazer pq nao entendi os itens

                            break;
                        }else{
                            System.out.println("Voce digitou algo errado!");
                            sc.nextLine();
                        }
                    }
                    break;
                case "4":
                    
                    break;
                case "5":
                    return;
                    //break;
                default:
                    System.out.println("Voce digitou algo errado!");
                    break;
            }
        }
        // lembrar de dar o return do id pra nao perder o id dos personagens.    
    }
}
