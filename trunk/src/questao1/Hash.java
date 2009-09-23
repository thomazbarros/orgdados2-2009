/*
 * Questão 1 do primeiro trabalho de Organização de Dados II
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
		ArrayList<Celula> hash; //Conjunto que células que representa a hash.
		int tamanho; //tamanho da Hash.
		int numeroElementos; //Diz quantos elementos estão na Hash.
	
	public Hash(int tamanho) //Construtor
		{
			numeroElementos = 0; // Inicializando o número de elementos com zero.
			this.tamanho = tamanho;
			hash = new ArrayList<Celula>(tamanho); //inicializando o Array.
			for(int i = 0; i < tamanho; i++){
				hash.add(new Celula()); //Criando as células em cada posição do Array.
			}
		}
		
		int hashcode(int elemento)//Função da hash
		{
			return elemento%tamanho; 
		}
		
		boolean isCheio() //Verifica se a Hash está cheia.
		{
			return numeroElementos == tamanho; 
		}
		
		boolean isVazio() //Verifica se a Hash está vazia.
		{
			return numeroElementos == 0;
		}
		
		int busca(int elemento) //Método que verifica se um elemento está ou não na Hash.
		{
			int index = hashcode(elemento); //Essa funcao vai retornar o HashCode do elemento.
			while(hash.get(index).getEstado() < 0){
						
					if(Math.abs(hash.get(index).getEstado()) == 1 && hash.get(index).getChave() == elemento){
						//elemento encontrado
						return index;
					}	
						
					else if(hash.get(index).getProximoElemento() == null){ 
						//Caso o próximo elemento seja nulo, retorna o index atual
						return index;
					}
					else{
						//Passa para o próximo elemento
						index = hash.indexOf(hash.get(index).getProximoElemento());
					}
					
			}
								
			return index;
		}
		
		void insercao(int elemento, String dado){ 
			//Método responsável pela inserção de novos elementos, utiliza como critério os estados 
			int index = busca(elemento);
			//Verifica se o elemento já existe na hash
			if(Math.abs(hash.get(index).getEstado()) == 1 && hash.get(index).getChave() == elemento)
			{
					System.out.println("A tabela já contém o elemento desejado.");
					return;
			}
			else{
				if(hash.get(hashcode(elemento)).getEstado() == 0) //quando o estado é 0, a inserção é imediata
				{
					hash.get(hashcode(elemento)).setChave(elemento);
					hash.get(hashcode(elemento)).setEstado(1);
					hash.get(hashcode(elemento)).setDado(dado);
				}
				else{
					//quando o estado é diferente de 0, é necessário atualizar os links e os estados
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
			System.out.println("Número incluído com sucesso.");
			numeroElementos++;
		}
		
		void remocao(int elemento){
			int index = busca(elemento);
			//Verifica se o elemento está presente na hash
			if(Math.abs(hash.get(index).getEstado()) == 1 && hash.get(index).getChave() == elemento){
				if(hash.get(index).getEstado() < 0){ /*verificando se é o fim ou não da cadeia */
					hash.get(index).setEstado(-2);
				}
				else{
					hash.get(index).setEstado(2);
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

}
