/*
Trabalho realizado por: 

Enzo Oguro Linos
Jiulius Cesar Pereira Balog Silva
Leonardo Alencar Bordoni
Lucas Hideki Matumoto Freitas Oliveira
Nicolas Boffo
*/

package boundary;
import java.util.Scanner;

public class JogoUI {

    Scanner input = new Scanner(System.in);

    public String lerNome(){
        String nome = new String();
        nome = input.nextLine();
        return nome;
    }
    public char lerPeça(){
        char peça = input.next().charAt(0);
        return peça;
    }

    public int[] lerJogada(){
        int linha;
        int coluna;
        do {
            System.out.println("Insira número da coluna (entre 0 a 2): ");
            coluna = input.nextInt();
        } while(coluna < 0 || coluna > 2);
        do {
            System.out.println("Insira número da linha (entre 0 a 2): ");
            linha = input.nextInt();
        } while(linha < 0 || linha > 2);
        return new int[]{linha, coluna};
    }

    public void exibirTabuleiro(char[][] tabuleiro) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("| ");
                System.out.print(tabuleiro[i][j]);
                System.out.print(" |");
            }
            System.out.println();
        }
    }

    public void exibirFimJogo(String mensagem){
        System.out.println(mensagem);
    }
}


