/*
 * Quest�o 2 do primeiro trabalho de Organiza��o de Dados II
 * Desenvolvido por:
 * 					Carolina Szkruc Carvalho DRE: 107413394
 * 					Gustavo Henrique Alves dos Santos DRE: 107363191
 * 					Leopoldo Andre Dutra Lusquino Filho DRE: 107363002
 * 					Thomaz Avila Barros DRE:107363028
 */
package questao2;

import java.util.ArrayList;

import questao2.Celula;


public class Hash {
	public static final int vazio = -999999;
	private
		ArrayList<Celula> hash; 
		int tamanho; //tamanho da hash
		int indexAnterior; //Index utilizada na remo��o para atualizar o link do elemento anterior
		int numeroElementos; //Numero de elementos ocupados na hash
	
	public Hash(int tamanho) 
		{
			numeroElementos = 0; 
			this.tamanho = tamanho;
			hash = new ArrayList<Celula>(tamanho);
			for(int i = 0; i < tamanho; i++){
				hash.add(new Celula());
			}
		}
		
		int hashcode(int elemento)//M�todo de gera��o de hash
		{
			return elemento%tamanho; 
		}
		
		boolean isCheio() //Verifica se a hash est� cheia
		{
			return numeroElementos == tamanho;
		}
		
		boolean isVazio() //Verifica se a hash est� vazia
		{
			return numeroElementos == 0;
		}
		
		int busca(int elemento)
		{
			int index = hashcode(elemento);
			indexAnterior = -1; //Inicializa o indicador do elemento anterior como "vazio"
			while(hash.get(index).getChave() != Celula.vazio){
					
					if(hash.get(index).getChave() == elemento){ //elemento encontrado
						return index;
					}	
					
					if(hash.get(index).getProximoElemento() == null){ //o pr�ximo elemento � nulo
						return index;
					}
					else{
						//continua a busca no pr�ximo elemento
						indexAnterior = index;
						index = hash.indexOf(hash.get(index).getProximoElemento());
					}
					
			}
								
			return index;
		}
		
		void insercao(int elemento, String dado){
			int index = busca(elemento);
			
			if(hash.get(index).getChave() == elemento) //verifica se o elemento j� est� na hash
			{
					System.out.println("A tabela j� cont�m o elemento desejado.");
					return;
			}
			else{
				if(hash.get(index).getChave() == Celula.vazio && hashcode(elemento) == index){
					hash.get(index).setChave(elemento);
					hash.get(index).setDado(dado);
				}
				else{
					for(int i = tamanho-1; i >= 0; i--)
					{
						if(hash.get(i).getChave() == Celula.vazio)
						{
							hash.get(i).setChave(elemento);
							hash.get(i).setDado(dado);
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
			if(hash.get(index).getChave() == elemento){
				if(hash.get(index).getProximoElemento() != null){
					hash.get(index).setChave(hash.get(index).getProximoElemento().getChave());
					hash.get(index).getProximoElemento().setChave(Celula.vazio);
					hash.get(index).setProximoElemento(hash.get(index).getProximoElemento().getProximoElemento());
				}else{
					hash.get(index).setChave(Celula.vazio);
					hash.get(index).setProximoElemento(null);
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

		public void imprimeHash(ArrayList<Celula> hash, int tamanho){
			System.out.println("|Posi��o|         |Chave|              |Dado|                |Link|                ");
			for(int posicao=0; posicao<tamanho; posicao++){
				int prox = hash.indexOf(hash.get(posicao).getProximoElemento());
				if (prox == -1){
					if(hash.get(posicao).getChave() == vazio){
						System.out.println( "|"
								+posicao
								+ "|                |" 
								+ "vazio"
								+ "|                |"
								+ hash.get(posicao).getDado()
								+ "|                |"  
								+ "null |" );
						
					}else{
					System.out.println( "|"
										+posicao
										+ "|                |" 
										+ hash.get(posicao).getChave()
										+ "|                |"
										+ hash.get(posicao).getDado()
										+ "|                |"  
										+ "null |" );
					}
				}else{
					if(hash.get(posicao).getChave() == vazio){
						System.out.println( "|"
								+posicao 
								+ "|                |"
								+ "vazio"
								+ "|                |"
								+ hash.get(posicao).getDado()
								+"|                |"
								+ prox +"|");					
					}else{
						System.out.println( "|"
										+posicao 
										+ "|                |"
										+ hash.get(posicao).getChave() 
										+ "|                |"
										+ hash.get(posicao).getDado()
										+"|                |"
										+ prox +"|");
					}
				}
				
			}
		}		
}
