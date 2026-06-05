package entity;

public class Tabuleiro {
    char [][] posicoes = new char[3][3];

    public char[][] getPosicoes() {
        return posicoes;
    }

    public void setPosicoes(int linha, int coluna, char tipo) {
        this.posicoes[linha][coluna] = tipo;
    }

    public boolean verificarJogada(int linha, int coluna) {
        return posicoes[linha][coluna] == ' ';
    }

    public Tabuleiro() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                posicoes[i][j] = ' ';
    }


}
