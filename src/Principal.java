import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite o nome do primeiro jogador:");
		Jogador jogadorUm = new Jogador(sc.nextLine(), "X");
		System.out.println("Digite o nome do segundo jogador:");
		Jogador jogadorDois = new Jogador(sc.nextLine(), "O");
		
		System.out.println("Escolha a dimensão do tabuleiro:");
		int dimensao = sc.nextInt();
		sc.nextLine();
		
		System.out.printf("%s vai jogar com a letra X e %s com a letra O!%n", jogadorUm.getNome(), jogadorDois.getNome());
		
		int totalJogadas = dimensao * dimensao; 
		boolean jogarNovamente = false;
		
		do {
			System.out.println("");
			System.out.println("Começando o jogo:");
			JogoDaVelha jogo = new JogoDaVelha(dimensao);
			Jogador jogadorAtual = jogadorUm;
			int nrJogada = 1;

			while (nrJogada < totalJogadas && !jogo.verificaGanhador(jogadorAtual.getLetra())) {

				jogadorAtual = nrJogada % 2 == 1 ? jogadorUm : jogadorDois;
				
				System.out.printf("%s, qual linha você quer jogar?%n", jogadorAtual.getNome());
				int linha = sc.nextInt();
				sc.nextLine();
				System.out.printf("%s, qual coluna você quer jogar?%n", jogadorAtual.getNome());
				int col = sc.nextInt();
				sc.nextLine();
			
				if (!jogo.realizaJogada(linha - 1, col - 1, jogadorAtual.getLetra())) {
					System.out.println("Jogada inválida!");
					continue;
				}
				
				System.out.println(jogo);
				
				nrJogada++;
				
	
			} 
			
			if (jogo.verificaGanhador(jogadorAtual.getLetra())) {
				System.out.printf("%s ganhou o jogo!%n", jogadorAtual.getNome());
				jogadorAtual.addPontos();
			}
			
			System.out.println("Quer jogar novamente? (s/N)");
			jogarNovamente = sc.next().toLowerCase().startsWith("s");
		
		} while (jogarNovamente);
		
		System.out.printf("%s ganhou %d partida(s)!%n", jogadorUm.getNome(), jogadorUm.getPontos());
		System.out.printf("%s ganhou %d partida(s)!%n", jogadorDois.getNome(), jogadorDois.getPontos());
		
		sc.close();
		
		
	}
	
	
	
}
