package questao2;

import java.util.ArrayList;


public class Hash {
	private
		ArrayList<Celula> hash;
		int tamanho;
	
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
			
			while(hash.get(index).getProximoElemento() != null ){
					
					if(hash.get(index).getChave() == elemento){
						return index;
					}	
		
					if(hash.get(index).getProximoElemento() == null){
						return index;
					}
					else{
						index = hash.indexOf(hash.get(index).getProximoElemento());
					}
					
			}
			
			return index;
		}
		
		void insercao(int elemento){
			int index = busca(elemento);
			int indexInserida = tamanho-1;
			
			if(hash.get(index).getChave() == elemento){
				System.out.println("O elemento "+elemento+" ja se encontra na hash");
				return;
			}
			
			while(indexInserida >= 0){
				
			}
			
		}
		
		void remocao(int elemento){
			
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
