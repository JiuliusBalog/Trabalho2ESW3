import boundary.JogoUI;
import control.JogoUC;

public class Main {
    public static void main(String[] args) {
        JogoUI ui = new JogoUI();
        JogoUC uc = new JogoUC();

        // Puxa os nomes

        System.out.print("Insira o nome do primeiro jogador: ");
        String nome1 = ui.lerNome();
        System.out.print("Insira o nome do segundo jogador: ");
        String nome2 = ui.lerNome();
        uc.iniciarPartida(nome1, nome2);

        // Puxa as peças

        System.out.print("Insira a peça do primeiro jogador: ");
        char peça = ui.lerPeça();
        uc.escolherPeca(peça);

        // Loop principal

        do {
            int[] coordenadas = new int[2];
            while (uc.getStatus().equals("EmAndamento")) {
                ui.exibirTabuleiro(uc.getTabuleiro());
                coordenadas = ui.lerJogada();
                uc.realizarJogada(coordenadas);
            }
            ui.exibirTabuleiro(uc.getTabuleiro());
            if (uc.getStatus().equals("Vitoria")) {
                ui.exibirFimJogo(uc.getJogadorAtual().getNome() + " venceu!");
            } else {
                ui.exibirFimJogo("Empate!");
            }
            uc.terminarPartida();
        } while (uc.getStatus().equals("EmAndamento"));

    }
}
