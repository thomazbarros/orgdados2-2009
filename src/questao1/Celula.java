/*
 * Quest�o 1 do primeiro trabalho de Organiza��o de Dados II
 * Desenvolvido por:
 * Carolina ... DRE:
 * Gustavo Henrique Alves dos Santos DRE:
 * Leopoldo Andre Dutra Lusquino Filho DRE:
 * Thomaz Avila Barros DRE:107363028
 */

package questao1;

public class Celula {
	private int chave;
	private int estado;
	private Celula proximoElemento;
	
	
	public Celula(){
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
	
//	public String toString(){
	//	if(proximoElemento != null){
		//	return "Estado :" + estado + "Chave :" + chave + "Proximo :" + proximoElemento.getChave() ;
	//	}
	//	return "Estado :" + estado + "Chave :" + chave + "Proximo :" + proximoElemento;
//	}
	
}
