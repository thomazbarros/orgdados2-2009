/*
 * Questão 2 do primeiro trabalho de Organização de Dados II
 * Desenvolvido por:
 * 					Carolina Szkruc Carvalho DRE: 107413394
 * 					Gustavo Henrique Alves dos Santos DRE: 107363191
 * 					Leopoldo Andre Dutra Lusquino Filho DRE: 107363002
 * 					Thomaz Avila Barros DRE:107363028
 */
package questao2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Principal {


	public static void main(String[] args) {
		
		BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in));  
		int tamanho = 0;
		try{
			while (tamanho <= 0){
			System.out.println("Digite o número de elementos da hash:");
			tamanho = Integer.parseInt(leitor.readLine());
				if(tamanho <=0){
					System.out.println("Tamanho inválido. Tente novamente.");
				}
			}
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
						
						if(hash.isCheio()){
							System.out.println("A hash está cheia.");
						}
						else{
							System.out.println("Digite o elemento que deseja inserir:");
							try{
								int elementoInsercao = Integer.parseInt(leitor.readLine());
								System.out.println("Digite o dado a ser inserido:");
								String dado = " ";
								dado = leitor.readLine();
								hash.insercao(elementoInsercao, dado);
								
							}
							catch(Exception e){}
						}
						
						break;
						
					case 2 : 
						
						System.out.println("Digite o elemento que deseja remover:");
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
						
						break;						
						
					case 3 : 
						
						System.out.println("Digite o elemento que deseja procurar");
						try{
							int elementoBusca = Integer.parseInt(leitor.readLine());
							int index = hash.busca(elementoBusca);
							if(hash.getHash().get(index).getChave() == elementoBusca){
								System.out.println("O elemento " +elementoBusca+ " está na hash");
								System.out.println("Seu conteúdo será transcrito a seguir:");
								System.out.println(hash.getHash().get(index).getDado());
							}
							else{
								System.out.println("O elemento " +elementoBusca+ " não está na hash");
							};
						}
						catch(Exception e){}
						
						break;
						
					case 4 : 
						
						break;
					
					default:
						System.out.println("Opção inválida. Tente novamente.");
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
