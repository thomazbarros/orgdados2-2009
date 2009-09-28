/*
 * Questão 2 do primeiro trabalho de Organização de Dados II
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
		int indexAnterior; //Index utilizada na remoção para atualizar o link do elemento anterior
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
		
		int hashcode(int elemento)//Método de geração de hash
		{
			return elemento%tamanho; 
		}
		
		boolean isCheio() //Verifica se a hash está cheia
		{
			return numeroElementos == tamanho;
		}
		
		boolean isVazio() //Verifica se a hash está vazia
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
					
					if(hash.get(index).getProximoElemento() == null){ //o próximo elemento é nulo
						return index;
					}
					else{
						//continua a busca no próximo elemento
						indexAnterior = index;
						index = hash.indexOf(hash.get(index).getProximoElemento());
					}
					
			}
								
			return index;
		}
		
		void insercao(int elemento, String dado){
			int index = busca(elemento);
			
			if(hash.get(index).getChave() == elemento) //verifica se o elemento já está na hash
			{
					System.out.println("A tabela já contém o elemento desejado.");
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
			System.out.println("Número incluído com sucesso.");
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
				
				System.out.println("Número removido com sucesso.");
				numeroElementos--;
			}
			else{
				System.out.println("A tabela não contém o elemento desejado.");
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
			System.out.println("|Posição|         |Chave|              |Dado|                |Link|                ");
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
