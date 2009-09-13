package questao1;

import java.util.ArrayList;


public class Hash {
	private
		ArrayList<Celula> hash;
		int tamanho;
		int celulasUsadas;
		int indexAnterior;
	
	public
		Hash(int tamanho)
		{
			this.tamanho = tamanho;
			hash = new ArrayList(tamanho);
		}
		
		int hashcode(int elemento)
		{
			return elemento%tamanho; 
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
		
		void remocao(int elemento){
			int index = busca(elemento);
			if(Math.abs(hash.get(index).getEstado()) == 1 && hash.get(index).getChave() == elemento){
				if(hash.get(index+1).getEstado() < 0){ /*verificando se é o fim ou não da cadeia */
					hash.get(index).setEstado(-2);
					hash.get(indexAnterior).setProximoElemento(hash.get(index).getProximoElemento());
				}
				else{
					hash.get(index).setEstado(2);
				}
				System.out.println("Número removido com sucesso.");
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
