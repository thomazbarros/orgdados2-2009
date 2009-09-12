package questao1;

public class Celula {
	int chave;
	int estado;
	Celula proximoElemento;
	
	
	public Celula(){
		chave = -1;
		estado = 0;
		proximoElemento = null;
	}


	public int getChave() {
		return chave;
	}


	public void setChave(int chave) {
		this.chave = chave;
	}


	public int getEstado() {
		return estado;
	}


	public void setEstado(int estado) {
		this.estado = estado;
	}


	public Celula getProximoElemento() {
		return proximoElemento;
	}


	public void setProximoElemento(Celula proximoElemento) {
		this.proximoElemento = proximoElemento;
	}
	
}
