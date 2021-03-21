
public class Jogador {
	private String nome;
	private int pontos;
	private String letra;
	
	public Jogador (String nome, String letra) {
		this.nome = nome;
		this.letra = letra;
		pontos = 0;
	}

	public String getNome() {
		return nome;
	}
	
	public String getLetra() {
		return letra;
	}

	public int getPontos() {
		return pontos;
	}

	public void addPontos() {
		this.pontos++; 
	}

	@Override
	public String toString() {
		return "Jogador [nome=" + nome + ", pontos=" + pontos + "]";
	}
	
	
}
