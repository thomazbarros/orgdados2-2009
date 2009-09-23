/*
 * Questão 1 do primeiro trabalho de Organização de Dados II
 * Desenvolvido por:
 * 					Carolina Szkruc Carvalho DRE: 107413394
 * 					Gustavo Henrique Alves dos Santos DRE: 107363191
 * 					Leopoldo Andre Dutra Lusquino Filho DRE: 107363002
 * 					Thomaz Avila Barros DRE:107363028
 */

package questao1;

public class Celula {
	private int chave;
	private int estado;
	private Celula proximoElemento; //é o link para o próximo elemento.
	private String dado;
	
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


	public String getDado() {
		return dado;
	}


	public void setDado(String dado) {
		this.dado = dado;
	}
	
	
}
