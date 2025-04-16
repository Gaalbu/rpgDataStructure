import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    
    Scanner sc = new Scanner(System.in);
    public void iniciarJogo(){
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
            telaPrincipal(jogadores, jogadorAtual, idPersonagemAtual++);
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

    public void telaPrincipal(ArrayList<Jogador> jogadores, Jogador jogador, int id){
        ArrayList<Jogador> outrosJogadores = jogadores;
        Jogador jogadorAtual = jogador;

        int idPersonagemAtual = id;
        while(true){
            System.out.println("====================MENU===============");
            System.out.println("Escolha abaixo o que deseja fazer.");
            System.out.println("1.Criar Personagem.");
            System.out.println("2.Atribuir pontos de atributos.");
            System.out.println("3.Equipar itens.");
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
                    if(jogadorAtual.getPersonagens().head != null){
                        System.out.println("Escolha o Personagem que voce deseja equipar o item: ");
                        jogadorAtual.getPersonagens().printCharacters();
                        String nome = sc.nextLine();

                        jogadorAtual.getPersonagens().getByNome(nome).personagem.inventario.printItens();
                        System.out.println("Digite o numero do item que voce deseja equipar: ");
                        String itemEscolhido = sc.nextLine();
    
                        try {
                            jogadorAtual.getPersonagens().getByNome(nome).personagem.itemEquipado = jogadorAtual.getPersonagens().getByNome(nome).personagem.inventario.get((Integer.parseInt(itemEscolhido)-1)).item;
                        } catch (Exception e) {
                            System.out.println("Nao tem esse index no inventario!");
                        }
                    }else{
                        System.out.println("Voce nao tem itens no inventario para equipar");
                    }
                    break;
                case "4":
                    while(true){
                        String escModo;
                        ListaEntidades personagensParticipantes = new ListaEntidades();
                        if(jogadorAtual.getPersonagens().size() != 0){
                            System.out.println("=======================================");
                            System.out.println("Qual modo de batalha voce deseja escolher?");
                            System.out.println("1.PvP");
                            System.out.println("2.PvE");
                            System.out.println("=======================================");
                            escModo = sc.nextLine();

                            System.out.println("Com qual personagem você deseja batalhar?");
                            jogadorAtual.getPersonagens().printCharacters();
                            String NomeP1 = sc.nextLine();
                            NodeEntidades NoDoPersonagemP1 = jogadorAtual.getPersonagens().getByNome(NomeP1);
                            personagensParticipantes.add(NoDoPersonagemP1.personagem);
                            System.out.println("voce escolheu o personagem: " + NoDoPersonagemP1.personagem.getNome());
                            sc.nextLine();
                        }else{
                            System.out.println("Voce nao possui personagens cadastrados!");
                            break;
                        }

                        if(escModo.equals("1")){
                            if(outrosJogadores.size() != 1){
                                System.out.println("\n\nQuem vai ser o jogador 2?");
                                System.out.println("Lista de possíveis jogadores:");
                                for (Jogador j : outrosJogadores) {
                                    if(!j.getNome().equals(jogadorAtual.getNome())){
                                        System.out.println(j.getNome());
                                    }
                                }
                            }else{
                                System.out.println("Não tem 2 contas criadas para o PvP poder existir.");
                                break;
                            }
                            String nomeJ2 = sc.nextLine();
                            System.out.println("==================================");
                            Jogador j2 = new Jogador();
                            for (Jogador j : outrosJogadores) {
                                if(j.getNome().equals(nomeJ2)){
                                    j2 = j;
                                    break;
                                }
                            }

                            if(j2.getPersonagens() != null){
                                System.out.println("Escolha o Personagem do jogador 2:");
                                j2.getPersonagens().printCharacters();
                                String NomeP2 = sc.nextLine();
                                NodeEntidades NoDoPersonagemP2 = j2.getPersonagens().getByNome(NomeP2);
                                personagensParticipantes.add(NoDoPersonagemP2.personagem);
                                System.out.println("voce escolheu o personagem: " + NoDoPersonagemP2.personagem.getNome());
                                sc.nextLine();
                            }else{
                                System.out.println("Esse jogador não possui personagens!");
                                break;
                            }

                            telaBatalhaPvP(personagensParticipantes);

                        }else if(escModo.equals("2")){

                            ListaEntidades monstros = new ListaEntidades();
                            monstros.add(new Monstro("monstro 1", 120, 10, 20,1));
                            monstros.add(new Monstro("monstro 2", 100, 15, 25,2));
                            monstros.add(new Monstro("monstro 3", 140, 5, 15,3));
                            monstros.add(new Monstro("monstro 4", 150, 20, 30,4));

                            System.out.println("escolha o monstro com quem quer batalhar:\n");
                            monstros.printCharacters();
                            String input = sc.nextLine();

                            if(monstros.getByNome(input) == null){
                                System.out.println("esse monstro nao existe");
                                break;
                            }else{
                                personagensParticipantes.add(monstros.getByNome(input).personagem);
                                telaBatalhaPvE(personagensParticipantes, jogadorAtual);
                            }

                        }else{
                            System.out.println("Voce digitou algo errado!");
                        }

                        break;
                    }
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Voce digitou algo errado!");
                    break;
            }
        }   
    }

    public void telaBatalhaPvP(ListaEntidades participantes){
        Batalha b = new Batalha(0, participantes); // lembrar de alterar o id
        if(b.getParticipantes().get(0).personagem.getVidaAtual() < 0 || b.getParticipantes().get(1).personagem.getVidaAtual() < 0){
            System.out.println("Um dos Personagens escolhidos está morto!");
            return;
        }
        while(b.getParticipantes().get(0).personagem.getVidaAtual() > 0 && b.getParticipantes().get(1).personagem.getVidaAtual() > 0){
            System.out.println("============MENU=DE=BATALHA============");
            System.out.println("Escolha abaixo o que deseja fazer.");
            System.out.println("1.Mostrar fila de turnos.");
            System.out.println("2.Exibir informacoes dos personagens.");
            System.out.println("3.Menu de opcoes.");
            System.out.println("4.Encerrar Batalha.");
            System.out.println("=======================================");
            String escBatalha = sc.nextLine();

            switch (escBatalha) {
                case "1":
                    System.out.println(b.getOrdemTurnos().tail.personagem.getNome());
                    break;
                case "2":
                    b.getParticipantes().exibirInfoPersonagens();
                    break;
                case "3":
                    b.iniciarBatalha();
                    participantes.head.personagem.setPosBatalha();
                    return;
                case "4":
                    return;    
                default:
                    System.out.println("Voce digitou algo errado!");
                    break;
            }
        }
    }

    public void telaBatalhaPvE(ListaEntidades participantes, Jogador jogador){
        Batalha b = new Batalha(0, participantes); // lembrar de alterar o id
        if(b.getParticipantes().get(0).personagem.getVidaAtual() < 0 || b.getParticipantes().get(1).personagem.getVidaAtual() < 0){
            System.out.println("Um dos Personagens escolhidos está morto!");
            return;
        }
        while(b.getParticipantes().get(0).personagem.getVidaAtual() > 0 && b.getParticipantes().get(1).personagem.getVidaAtual() > 0){
            System.out.println("============MENU=DE=BATALHA============");
            System.out.println("Escolha abaixo o que deseja fazer.");
            System.out.println("1.Mostrar fila de turnos.");
            System.out.println("2.Exibir informacoes dos personagens.");
            System.out.println("3.Menu de opcoes.");
            System.out.println("4.Encerrar Batalha.");
            System.out.println("=======================================");
            String escBatalha = sc.nextLine();

            switch (escBatalha) {
                case "1":
                    b.getOrdemTurnos().printCharacters();
                    break;
                case "2":
                    b.getParticipantes().exibirInfoPersonagens();
                    break;
                case "3":
                    b.iniciarBatalhaPVE();
                    if(b.getColocacaoEntidades().peek().personagem instanceof Personagem){
                        if(b.getColocacaoEntidades().head.next.personagem.getNivel() == 1){
                            System.out.println("parabens! voce recebeu 100 cristais e uma espada de pedra");
                            jogador.setSaldoCristais(jogador.getSaldoCristais()+ 100);
                            jogador.getPersonagens().getByNome(b.getColocacaoEntidades().peek().personagem.getNome()).personagem.inventario.add(new Item(20, "espada de pedra", "raro"));
                        }else if(b.getColocacaoEntidades().head.next.personagem.getNivel() == 2){
                            System.out.println("parabens! voce recebeu 125 cristais e uma espada de ferro");
                            jogador.setSaldoCristais(jogador.getSaldoCristais()+ 125);
                            jogador.getPersonagens().getByNome(b.getColocacaoEntidades().peek().personagem.getNome()).personagem.inventario.add(new Item(25, "espada de ferro", "super raro"));
                        }else if(b.getColocacaoEntidades().head.next.personagem.getNivel() == 3){
                            System.out.println("parabens! voce recebeu 150 cristais e uma espada de ouro");
                            jogador.setSaldoCristais(jogador.getSaldoCristais()+ 150);
                            jogador.getPersonagens().getByNome(b.getColocacaoEntidades().peek().personagem.getNome()).personagem.inventario.add(new Item(30, "espada de ouro", "epico"));
                        }else if(b.getColocacaoEntidades().head.next.personagem.getNivel() == 4){
                            System.out.println("parabens! voce recebeu 200 cristais e uma espada de diamante");
                            jogador.setSaldoCristais(jogador.getSaldoCristais()+ 200);
                            jogador.getPersonagens().getByNome(b.getColocacaoEntidades().peek().personagem.getNome()).personagem.inventario.add(new Item(35, "espada de diamante", "lendario"));
                        }
                         jogador.getPersonagens().getByNome(b.getColocacaoEntidades().peek().personagem.getNome()).personagem.setPosBatalha();
                         return;
                    }
                    break;
                case "4":
                    return;    
                default:
                    System.out.println("Voce digitou algo errado!");
                    break;
            }
        }
    }
}
