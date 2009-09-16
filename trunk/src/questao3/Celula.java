/*
 * Quest�o 3 do primeiro trabalho de Organiza��o de Dados II
 * Desenvolvido por:
 * 					Carolina Szkruc Carvalho DRE: 107413394
 * 					Gustavo Henrique Alves dos Santos DRE: 107363191
 * 					Leopoldo Andre Dutra Lusquino Filho DRE: 107363002
 * 					Thomaz Avila Barros DRE:107363028
 */
package questao3;

public class Celula {
	private int chave;
	private Celula proximoElemento;
	public static final int vazio = -999999;
	
	public Celula(){
		chave = vazio;
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
	
	public String toString(){
		if(proximoElemento != null){
			return "Chave :" + chave + "Proximo :" + proximoElemento.getChave() ;
		}
		return "Chave :" + chave + "Proximo :" + proximoElemento;
	}
	
}
