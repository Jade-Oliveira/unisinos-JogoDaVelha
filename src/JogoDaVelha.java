import java.util.Arrays;

public class JogoDaVelha {
	private String[][] tabuleiro;
	private int dimensaoTab;
	
	public JogoDaVelha (int dimensao) {
		dimensaoTab = dimensao;
		
		if (dimensaoTab < 3 ) {
			System.out.println("Escolher a dimensão a partir de 3!");
		}
		else {
			tabuleiro = new String[dimensaoTab][dimensaoTab];
		}
	
	}
	
	
	public int getDimensaoTab() {
		return dimensaoTab;
	}


	public boolean realizaJogada (int linha, int col, String jogada) {
		if (linha >= getDimensaoTab() || col >= getDimensaoTab()) {
			return false;
		}
		
		String conteudoPos = tabuleiro[linha][col];
		
		if (conteudoPos != null) {
			return false;
		}

		tabuleiro[linha][col] = jogada;
		return true;
	}
	
	public boolean verificaGanhador (String jogada) {
		for (int i=0; i < getDimensaoTab(); i++) {
			boolean verificaLinha = true;			
			for (int j=0; j < getDimensaoTab(); j++) {
				if (tabuleiro[i][j] != jogada) {
					verificaLinha = false;
				}	
			}
			if (verificaLinha == true) {
				return true;
			}
		}
		for (int j=0; j < getDimensaoTab(); j++) {
			boolean verificaColuna = true;			
			for (int i=0; i < getDimensaoTab(); i++) {
				if (tabuleiro[i][j] != jogada) {
					verificaColuna = false;
				}
			}
			if (verificaColuna == true) {
				return true;
			}
		}
		boolean verificaDiagonalUm = true;
		boolean verificaDiagonalDois = true;
		for (int i=0; i < getDimensaoTab(); i++) {
			for (int j=0; j < getDimensaoTab(); j++) {
				if (tabuleiro[i][j] != jogada && i == j) {
					verificaDiagonalUm = false;
				}
			}
			
		}
		for (int i=0; i < getDimensaoTab(); i++ ) {
			for (int j=0; j < getDimensaoTab(); j++) {
				if (tabuleiro[i][j] != jogada && j == getDimensaoTab() - 1 -i) {
					verificaDiagonalDois = false;
				}
			}
		}
		if (verificaDiagonalUm == true || verificaDiagonalDois == true) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		String tabuleiroTexto = "";
		for (int i=0; i < getDimensaoTab(); i++ ) {
			for (int j=0; j < getDimensaoTab(); j++) {
				String jogada = tabuleiro[i][j];
				if (jogada != null) {
					tabuleiroTexto = tabuleiroTexto + " " + jogada;
				}
				else {
					tabuleiroTexto = tabuleiroTexto + "  ";
				}
				
			}
			tabuleiroTexto = tabuleiroTexto + "\n";
		}
		
		return "JogoDaVelha tabuleiro\n" + tabuleiroTexto;
		
	}
		
}
