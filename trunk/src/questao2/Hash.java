package questao2;

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
			while(hash.get(index).getChave() != Celula.vazio){
					
					if(hash.get(index).getChave() == elemento){
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
			//System.out.println(index + "," + elemento + "," + (Math.abs(hash.get(index).getEstado()) == 1 && hash.get(index).getChave() == elemento));
			if(hash.get(index).getChave() == elemento)
			{
					System.out.println("A tabela já contém o elemento desejado.");
					return;
			}
			else{
				if(hash.get(hashcode(elemento)).getChave() == Celula.vazio)
				{
					hash.get(hashcode(elemento)).setChave(elemento);
				}
				else{
					for(int i = tamanho-1; i >= 0; i--)
					{
						if(hash.get(i).getChave() == Celula.vazio)
						{
							hash.get(i).setChave(elemento);
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
					//if (hash.get(index).getProximoElemento() != null){
					//	hash.get(indexAnterior).setProximoElemento(hash.get(index).getProximoElemento());
					//}
					//else 
				//if (indexAnterior != -1){
			//		hash.get(indexAnterior).setProximoElemento(hash.get(index).getProximoElemento());
				//}
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

}
