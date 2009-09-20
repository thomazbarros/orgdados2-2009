/*
 * Quest�o 1 do primeiro trabalho de Organiza��o de Dados II
 * Desenvolvido por:
 * 					Carolina Szkruc Carvalho DRE: 107413394
 * 					Gustavo Henrique Alves dos Santos DRE: 107363191
 * 					Leopoldo Andre Dutra Lusquino Filho DRE: 107363002
 * 					Thomaz Avila Barros DRE:107363028
 */

package questao1;

import java.util.ArrayList;


public class Hash {
	private
		ArrayList<Celula> hash;
		int tamanho;
		int celulasUsadas;
		int indexAnterior;
		int numeroElementos;
	
	public Hash(int tamanho)
		{
			numeroElementos = 0;
			this.tamanho = tamanho;
			hash = new ArrayList<Celula>(tamanho);
			for(int i = 0; i < tamanho; i++){
				hash.add(new Celula());
			}
			System.out.println("TAMANHO DA HASH :" + hash.size());
		}
		
		int hashcode(int elemento)
		{
			return elemento%tamanho; 
		}
		
		boolean isCheio()
		{
			return numeroElementos == tamanho;
		}
		
		boolean isVazio()
		{
			return numeroElementos == 0;
		}
		
		int busca(int elemento)
		{
			int index = hashcode(elemento);
			indexAnterior = -1;
			while(hash.get(index).getEstado() < 0){
						
					if(Math.abs(hash.get(index).getEstado()) == 1 && hash.get(index).getChave() == elemento){
						return index;
					}	
						
					if(hash.get(index).getProximoElemento() == null){
						return index;
					}
					else{
						indexAnterior = index;
						index = hash.indexOf(hash.get(index).getProximoElemento());
					}
					
			}
								
			return index;
		}
		
		void insercao(int elemento, String dado){
			int index = busca(elemento);
			//System.out.println(index + "," + elemento + "," + (Math.abs(hash.get(index).getEstado()) == 1 && hash.get(index).getChave() == elemento));
			if(Math.abs(hash.get(index).getEstado()) == 1 && hash.get(index).getChave() == elemento)
			{
					System.out.println("A tabela j� cont�m o elemento desejado.");
					return;
			}
			else{
				if(hash.get(hashcode(elemento)).getEstado() == 0)
				{
					hash.get(hashcode(elemento)).setChave(elemento);
					hash.get(hashcode(elemento)).setEstado(1);
					hash.get(hashcode(elemento)).setDado(dado);
				}
				else{
					for(int i = tamanho-1; i >= 0; i--)
					{
						if(Math.abs(hash.get(i).getEstado()) != 1)
						{
							hash.get(i).setChave(elemento);
							hash.get(i).setEstado(1);
							hash.get(i).setDado(dado);
							hash.get(index).setEstado(-1);
							hash.get(index).setProximoElemento(hash.get(i));
							break;
						}
					}
				}
			}
			System.out.println("N�mero inclu�do com sucesso.");
			numeroElementos++;
		}
		
		void remocao(int elemento){
			int index = busca(elemento);
			if(Math.abs(hash.get(index).getEstado()) == 1 && hash.get(index).getChave() == elemento){
				if(hash.get(index).getEstado() < 0){ /*verificando se � o fim ou n�o da cadeia */
					hash.get(index).setEstado(-2);
					//if (hash.get(index).getProximoElemento() != null){
					//	hash.get(indexAnterior).setProximoElemento(hash.get(index).getProximoElemento());
					//}
					//else 
					if (indexAnterior != -1){
						hash.get(indexAnterior).setProximoElemento(hash.get(index).getProximoElemento());
					}
				}
				else{
					hash.get(index).setEstado(2);
				}
				System.out.println("N�mero removido com sucesso.");
				numeroElementos--;
			}
			else{
				System.out.println("A tabela n�o cont�m o elemento desejado.");
			}
		}

		public ArrayList<Celula> getHash() {
			return hash;
		}

		public void setHash(ArrayList<Celula> hash) {
			this.hash = hash;
		}

		public int getTamanho() {
			return tamanho;
		}

		public void setTamanho(int tamanho) {
			this.tamanho = tamanho;
		}

}