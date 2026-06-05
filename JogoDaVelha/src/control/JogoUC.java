/*
Trabalho realizado por: 

Enzo Oguro Linos
Jiulius Cesar Pereira Balog Silva
Leonardo Alencar Bordoni
Lucas Hideki Matumoto Freitas Oliveira
Nicolas Boffo
*/

package control;
import entity.Jogador;
import entity.Peça;
import boundary.JogoUI;
import entity.Tabuleiro;
import java.util.Scanner;
public class JogoUC {
    String status = "EmAndamento";
    Scanner input = new Scanner(System.in);
    Jogador jogador1 = new Jogador();
    Jogador jogador2 = new Jogador();
    int jogadorAtual = 0;
    Tabuleiro tabuleiro = new Tabuleiro();

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Jogador getJogadorAtual() {
        return jogadorAtual == 0 ? jogador1 : jogador2;
    }

    public char[][] getTabuleiro(){
        return tabuleiro.getPosicoes();
    }

    public void iniciarPartida(String nome1, String nome2){
        jogador1.setNome(nome1);
        jogador2.setNome(nome2);
        System.out.println("Jogador 1: " + jogador1.getNome());
        System.out.println("Jogador 2: " + jogador2.getNome());
    }

    public void escolherPeca(char peça){
        Peça peça1 = new Peça();
        Peça peça2 = new Peça();

        peça = Character.toUpperCase(peça);

        while(peça != 'X' && peça != 'O') {
            System.out.println("Peça inválida. Escolha X ou O: ");
            peça = input.next().toUpperCase().charAt(0);
        }

        peça1.setTipo(peça);
        jogador1.setPeca(peça1);

        peça2.setTipo(peça == 'X' ? 'O' : 'X');
        jogador2.setPeca(peça2);

        System.out.println("Peça do Jogador 1: " + peça1.getTipo());
        System.out.println("Peça do Jogador 2: " + peça2.getTipo());
    }

    public void realizarJogada(int[] posicoes) {
        if(!tabuleiro.verificarJogada(posicoes[0], posicoes[1])) {
            System.out.println("Posição ocupada, tente novamente.");
            return;
        }
        Jogador jogador = getJogadorAtual();
        char tipo = jogador.getPeca().getTipo();
        tabuleiro.setPosicoes(posicoes[0], posicoes[1], tipo);
        status = verificarStatus();
        if(status.equals("EmAndamento")) {
            trocarTurno();
        }
    }

    public void trocarTurno() {
        jogadorAtual = jogadorAtual == 0 ? 1 : 0;
    }

    public void terminarPartida(){
        char choice;
        System.out.println("Deseja jogar mais uma vez?\nSim - S\nNão - N");
        choice = input.next().charAt(0);
        choice = Character.toUpperCase(choice);
        if(choice == 'S'){
            recomeçarPartida();
        } else if(choice == 'N'){
            System.out.println("Fechando programa...");
            System.exit(0);
        }
    }

    public void recomeçarPartida(){
        tabuleiro = new Tabuleiro();
        jogadorAtual = 0;
        status = "EmAndamento";
    }

    public String verificarStatus() {
        char[][] posicoes = tabuleiro.getPosicoes();

        // Verifica linhas
        for (int i = 0; i < 3; i++) {
            if (posicoes[i][0] != ' ' && posicoes[i][0] == posicoes[i][1] && posicoes[i][1] == posicoes[i][2])
                return "Vitoria";
        }

        // Verifica colunas
        for (int j = 0; j < 3; j++) {
            if (posicoes[0][j] != ' ' && posicoes[0][j] == posicoes[1][j] && posicoes[1][j] == posicoes[2][j])
                return "Vitoria";
        }

        // Verifica diagonais
        if (posicoes[0][0] != ' ' && posicoes[0][0] == posicoes[1][1] && posicoes[1][1] == posicoes[2][2])
            return "Vitoria";
        if (posicoes[0][2] != ' ' && posicoes[0][2] == posicoes[1][1] && posicoes[1][1] == posicoes[2][0])
            return "Vitoria";

        // Verifica empate
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (posicoes[i][j] == ' ') return "EmAndamento";
        return "Empate";
    }
}
