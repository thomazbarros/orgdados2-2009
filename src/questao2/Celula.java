package questao2;

public class Celula {
	private int chave;
	private Celula proximoElemento;
	
	public Celula(){
		proximoElemento = null;
	}

	public int getChave() {
		return chave;
	}

	public void setChave(int chave) {
		this.chave = chave;
	}

	public Celula getProximoElemento() {
		return proximoElemento;
	}

	public void setProximoElemento(Celula proximoElemento) {
		this.proximoElemento = proximoElemento;
	}
	
}
