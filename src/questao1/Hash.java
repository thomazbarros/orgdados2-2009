package questao1;

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
			
			while(hash.get(index).getEstado() < 0){
					
					if(Math.abs(hash.get(index).getEstado()) == 1 && hash.get(index).getChave() == elemento){
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
