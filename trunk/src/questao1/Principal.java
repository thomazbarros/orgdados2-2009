package questao1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Principal {


	public static void main(String[] args) {
		
		BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in));  
		int tamanho = 0;
		
		System.out.println("Digite o número de elementos da hash");
		try{
			tamanho = Integer.parseInt(leitor.readLine());
		}
		catch(Exception e){}
		
		Hash hash = new Hash(tamanho);
		
		while(true)
		{
			System.out.println("Digite o que deseja fazer :");
			System.out.println("1-Inserir novo elemento");
			System.out.println("2-Buscar um elemento");
			System.out.println("3-Remover um elemento");
			System.out.println("4-Sair");
			
			try{
				int opcao = Integer.parseInt(leitor.readLine());
			
				switch(opcao){
				
					case 1 : 
						
						System.out.println("Digite o elemento que deseja inserir:");
						if(hash.isCheio()){
							System.out.println("A hash está cheia");
						}
						else{
							try{
								int elementoInsercao = Integer.parseInt(leitor.readLine());
								hash.insercao(elementoInsercao);
							}
							catch(Exception e){}
						}
						
					case 2 : 
						
						System.out.println("Digite o elemento que deseja remover");
						if(hash.isVazio()){
							System.out.println("A hash está vazia.");
						}
						else{
							try{
								int elementoRemocao = Integer.parseInt(leitor.readLine());
								hash.remocao(elementoRemocao);
							}
							catch(Exception e){}
						}
						
					case 3 : 
						
						System.out.println("Digite o elemento que deseja remover");
						try{
							int elementoBusca = Integer.parseInt(leitor.readLine());
							int index = hash.busca(elementoBusca);
							if(Math.abs(hash.getHash().get(index).getEstado()) == 1 && hash.getHash().get(index).getChave() == elemento){
								System.out.println("O elemento " +elementoBusca+ " está na hash");
							}
							else{
								System.out.println("O elemento " +elementoBusca+ " não está na hash");
							};
						}
						catch(Exception e){}
						
						
					case 4 : 
						
						break;
				}
			}
			catch(Exception e){}			
		}	
	}
}
