package trabfinal;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

public class Principal {
	BufferedReader leitor;
	Janela janela = new Janela();
	
	public Principal(){
		 leitor  = new BufferedReader(new InputStreamReader(System.in));
	}
	
    public static void main(String[] args) {
       try{
		System.out.println("Digite qual tipo de lista autoajustável você deseja usar:");
		System.out.println("1 - Mover para a frente;");
		System.out.println("2 - Transposição;");
		System.out.println("3 - Contador de frequência;");
		System.out.println("4 - Mover para a frente 'k'");
		System.out.println("5 - Sair.");
		int leitura = 0;
		Principal principal = new Principal();
		leitura = Integer.parseInt(principal.getLeitor().readLine());
		while ((leitura<= 0 )||( leitura > 5)){ //Provisoriamente será 3
			System.out.println("Tipo inválido. Tente novamente.");
			leitura = Integer.parseInt(principal.getLeitor().readLine());
		}
		if ((leitura>=1) && (leitura<=3)){
			Lista lista = new Lista(leitura);
			principal.opcoes(principal, leitura , lista);
		}
		else if(leitura == 4){
			System.out.println("Digite o valor de k desejado");
			Lista lista = new Lista(4, Integer.parseInt(principal.getLeitor().readLine()));
			//principal.opcoesK(principal);
			principal.opcoes(principal, 4,lista);
		}
		System.out.println("Saindo...");
		principal.fecharJanela();
	}

	catch(Exception e){}

	}
	void opcoes(Principal principal, int tipo , Lista lista){
		int status = 0;
		while(status != -1){
			System.out.println("Digite o que você deseja fazer:");
			System.out.println("1 - Inserir elemento");
			System.out.println("2 - Buscar elemento");
			System.out.println("3 - Remover elemento");
			System.out.println("4 - Sair");
			try{
				int leitura = Integer.parseInt(principal.getLeitor().readLine());
				while ((leitura<= 0 )||( leitura > 4)){ 
					System.out.println("Escolha inválida. Tente novamente.");
					leitura = Integer.parseInt(principal.getLeitor().readLine());
				}
				switch (leitura){
					case 1:
						System.out.println("Digite o elemento a ser inserido:");
						lista.insercao(Integer.parseInt(principal.getLeitor().readLine()));
						janela.getPainelLista().atualizaLista(lista);
						break;

					case 2:
						System.out.println("Digite o elemento a ser buscado:");
						int elemento = Integer.parseInt(principal.getLeitor().readLine());
						Celula res = lista.busca(elemento);
						if(res == null){
							System.out.println("A lista está vazia.");
						}else{
							if(res.getChave() != elemento){
								System.out.println("O elemento procurado não está na lista.");
							}else{
								System.out.println("O elemento está na lista.");
							}
						}
						janela.getPainelLista().atualizaLista(lista);
						break;
						
					case 3:
						System.out.println("Digite o elemento a ser removido:");
						lista.remocao(Integer.parseInt(principal.getLeitor().readLine()));
						janela.getPainelLista().atualizaLista(lista);
						break;

					case 4:
						status = -1;
						fecharJanela();
						break;
					default://Apenas formalidade...
						System.out.println("Houston, we have a problem. That was not suppose to happen.");
						break;
					
				}
			}
			catch (Exception e){
				//System.out.println("Ih! Deu xabu. E agora?");
				e.printStackTrace();
			}
		}
	}
	
	/*void opcoesK(Principal principal){
		int status = 0;
		
		
		while(status != -1){
			
			try{
				System.out.println("Digite o valor de k desejado");
				Lista lista = new Lista(4, Integer.parseInt(principal.getLeitor().readLine()));
				
				System.out.println("Digite o que você deseja fazer:");
				System.out.println("1 - Inserir elemento");
				System.out.println("2 - Buscar elemento");
				System.out.println("3 - Remover elemento");
				System.out.println("4 - Sair");
				
				int leitura = Integer.parseInt(principal.getLeitor().readLine());
				
				while ((leitura<= 0 )||( leitura > 4)){ 
					System.out.println("Escolha inválida. Tente novamente.");
					leitura = Integer.parseInt(principal.getLeitor().readLine());
				}
				
				switch (leitura){
				
					case 1:
						System.out.println("Digite o elemento a ser inserido:");
						lista.insercao(Integer.parseInt(principal.getLeitor().readLine()));
						janela.getPainelLista().atualizaLista(lista);
						break;

					case 2:
						System.out.println("Digite o elemento a ser buscado:");
						int elemento = Integer.parseInt(principal.getLeitor().readLine());
						Celula res = lista.busca(elemento);
						if(res == null){
							System.out.println("A lista está vazia.");
						}else{
							if(res.getChave() != elemento){
								System.out.println("O elemento procurado não está na lista.");
							}else{
								System.out.println("O elemento está na lista.");
							}
						}
						janela.getPainelLista().atualizaLista(lista);
						break;
						
					case 3:
						System.out.println("Digite o elemento a ser removido:");
						lista.remocao(Integer.parseInt(principal.getLeitor().readLine()));
						janela.getPainelLista().atualizaLista(lista);
						break;

					case 4:
						status = -1;
						break;
					
					default://Apenas formalidade...
						System.out.println("Houston, we have a problem. That was not suppose to happen.");
						break;
					
				}
			}
			catch (Exception e){
				//System.out.println("Ih! Deu xabu. E agora?");
				e.printStackTrace();
			}
		}
	}*/

	public BufferedReader getLeitor() {
		return leitor;
	}
	
	public void fecharJanela()
	{
		janela.dispose();
	}

}
