/*
 * Quest�o 3 do primeiro trabalho de Organiza��o de Dados II
 * Desenvolvido por:
 * 					Carolina Szkruc Carvalho DRE: 107413394
 * 					Gustavo Henrique Alves dos Santos DRE: 107363191
 * 					Leopoldo Andre Dutra Lusquino Filho DRE: 107363002
 * 					Thomaz Avila Barros DRE:107363028
 */
package questao3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Principal {


	public static void main(String[] args) {
		
		BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in));  
		int tamanho = 0;
		
		System.out.println("Digite o n�mero de elementos da hash:");
		try{
			tamanho = Integer.parseInt(leitor.readLine());
		}
		catch(Exception e){}
		
		Hash hash = new Hash(tamanho);
		
		while(true)
		{
			System.out.println("Digite o que deseja fazer :");
			System.out.println("1-Inserir novo elemento");
			System.out.println("2-Remover um elemento");
			System.out.println("3-Buscar um elemento");
			System.out.println("4-Sair");
			System.out.println(hash.getHash());
			
			try{
				int opcao = Integer.parseInt(leitor.readLine());
			
				switch(opcao){
				
					case 1 : 
						
						System.out.println("Digite o elemento que deseja inserir:");
						if(hash.isCheio()){
							System.out.println("A hash est� cheia.");
						}
						else{
							try{
								int elementoInsercao = Integer.parseInt(leitor.readLine());
								hash.insercao(elementoInsercao);
							}
							catch(Exception e){}
						}
						
						break;
						
					case 2 : 
						
						System.out.println("Digite o elemento que deseja remover:");
						if(hash.isVazio()){
							System.out.println("A hash est� vazia.");
						}
						else{
							try{
								int elementoRemocao = Integer.parseInt(leitor.readLine());
								hash.remocao(elementoRemocao);
							}
							catch(Exception e){}
						}
						
						break;						
						
					case 3 : 
						
						System.out.println("Digite o elemento que deseja procurar");
						try{
							int elementoBusca = Integer.parseInt(leitor.readLine());
							int index = hash.busca(elementoBusca);
							if(hash.getHash().get(index).getChave() == elementoBusca){
								System.out.println("O elemento " +elementoBusca+ " est� na hash");
							}
							else{
								System.out.println("O elemento " +elementoBusca+ " n�o est� na hash");
							};
						}
						catch(Exception e){}
						
						break;
						
					case 4 : 
						
						break;
					
					default:
						System.out.println("Op��o inv�lida. Tente novamente.");
						break;
				}
				
				if(opcao == 4){
					break;
				}
			}
			catch(Exception e){}			
		}	
	}
}