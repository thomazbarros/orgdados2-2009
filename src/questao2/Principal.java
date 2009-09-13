package questao2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Principal {


	public static void main(String[] args) {
		
		BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in));  
		int tamanho = 0;
		
		System.out.println("Digite o numero de elementos da hash");
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
						
						System.out.println("Digite o elemento que deseja inserir");
						try{
							int elementoInsercao = Integer.parseInt(leitor.readLine());
							hash.insercao(elementoInsercao);
						}
						catch(Exception e){}
						
					case 2 : 
						
						System.out.println("Digite o elemento que deseja remover");
						try{
							int elementoRemocao = Integer.parseInt(leitor.readLine());
							hash.remocao(elementoRemocao);
						}
						catch(Exception e){}
						
					case 3 : 
						
						System.out.println("Digite o elemento que deseja remover");
						try{
							int elementoBusca = Integer.parseInt(leitor.readLine());
							int index = hash.busca(elementoBusca);
							if(hash.getHash().get(index).getChave() == elementoBusca){
								System.out.println("O elemento " +elementoBusca+ " esta na hash");
							}
							else{
								System.out.println("O elemento " +elementoBusca+ " nao esta na hash");
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
