package trabfinal;

public class Celula {
	
	private int chave, contadorFrequencia;
	private Celula anterior, proximo;
		
	
	public Celula(int chave, Celula anterior){
		this.chave = chave;
		contadorFrequencia = 0;
		this.anterior = anterior;
		proximo = null;
	}
	
	
	public int getChave() {
			return chave;
	}
		
	public void setChave(int chave) {
			this.chave = chave;
	}
	
	public int getContador() {
			return contadorFrequencia;
	}
		
	public void setContador(int contador) {
			this.contadorFrequencia = contador;
	}
	
	public Celula getAnterior() {
			return anterior;
	}
	
	public void setAnterior(Celula anterior) {
			this.anterior = anterior;
	}
		
	public Celula getProximo() {
			return proximo;
	}
		
	public void setProximo(Celula proximo) {
			this.proximo = proximo;
	}
}