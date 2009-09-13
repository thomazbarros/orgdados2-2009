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
			hash = new ArrayList(tamanho);
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
		
		void insercao(int elemento){
			int index = busca(elemento);
			if(Math.abs(hash.get(index).getEstado()) == 1 && hash.get(index).getChave() == elemento)
			{
					System.out.println("A tabela já contém o elemento desejado.");
					return;
			}
			else{
				if(hash.get(hashcode(elemento)).getEstado() == 0)
				{
					hash.get(hashcode(elemento)).setChave(elemento);
					hash.get(hashcode(elemento)).setEstado(1);
				}
				else{
					for(int i = tamanho; i >= 0; i--)
					{
						if(hash.get(i).getEstado() == 0)
						{
							hash.get(hashcode(elemento)).setChave(elemento);
							hash.get(hashcode(elemento)).setEstado(1);
							hash.get(index).setEstado(-1);
							hash.get(index).setProximoElemento(hash.get(i));
						}
					}
				}
			}
			System.out.println("Número incluído com sucesso.");
			numeroElementos++;
		}
		
		void remocao(int elemento){
			int index = busca(elemento);
			if(Math.abs(hash.get(index).getEstado()) == 1 && hash.get(index).getChave() == elemento){
				if(hash.get(index+1).getEstado() < 0){ /*verificando se é o fim ou não da cadeia */
					hash.get(index).setEstado(-2);
					if (hash.get(index).getProximoElemento() != null){
						hash.get(indexAnterior).setProximoElemento(hash.get(index).getProximoElemento());
					}
					else if (indexAnterior != -1){
						hash.get(indexAnterior).setProximoElemento(null);
					}
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
