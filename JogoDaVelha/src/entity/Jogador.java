/*
Trabalho realizado por: 

Enzo Oguro Linos
Jiulius Cesar Pereira Balog Silva
Leonardo Alencar Bordoni
Lucas Hideki Matumoto Freitas Oliveira
Nicolas Boffo
*/

package entity;

public class Jogador {
    String nome = new String();
    Peça peca = new Peça();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Peça getPeca() {
        return peca;
    }

    public void setPeca(Peça peca) {
        this.peca = peca;
    }
}
