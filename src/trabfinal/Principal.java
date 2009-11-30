package trabfinal;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

public class Principal {
	BufferedReader leitor;
	public Principal(){
		 leitor  = new BufferedReader(new InputStreamReader(System.in));
	}
    public static void main(String[] args) {
       try{
		System.out.println("Digite qual tipo de lista autoajustável você deseja usar:");
		System.out.println("1 - Mover para a frente;");
		System.out.println("2 - Transposição;");
		System.out.println("3 - Contador de frequência;");
		System.out.println("4 - Montar para a frente 'k'");
		System.out.println("5 - Sair.");
		int leitura = 0;
		Principal principal = new Principal();
		leitura = Integer.parseInt(principal.getLeitor().readLine());
		while ((leitura<= 0 )||( leitura > 5)){ //Provisoriamente será 3
			System.out.println("Tipo inválido. Tente novamente.");
			leitura = Integer.parseInt(principal.getLeitor().readLine());
		}
		
		switch (leitura){
		case 1:
			principal.moveParaFrente(principal);
			break;
		case 2:
			principal.transpoe();
			break;
		case 3:
			principal.contaFrequencia();
			break;
		case 4:
			principal.moveParaFrenteK();
			break;
		case 5:
			System.out.println("Saindo...");
			break;
		default: // Apenas uma formalidade. Se tudo estiver certinho, nunca passaremos por aqui.
			System.out.println("Erro estranho. Não era para passarmos nunca por aqui =P");
			break;
		}
	}

	catch(Exception e){}

	}
	void moveParaFrente(Principal principal){
		int status = 0;
		Lista lista = new Lista(1);
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
						break;

					case 2:
						System.out.println("Digite o elemento a ser buscado:");
						lista.busca(Integer.parseInt(principal.getLeitor().readLine()));
						break;
						
					case 3:
						System.out.println("Digite o elemento a ser removido:");
						lista.remocao(Integer.parseInt(principal.getLeitor().readLine()));
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
				System.out.println("Ih! Deu xabu. E agora?");
			}
		}
	}
	
	void moveParaFrenteK(){
		
	}
	void transpoe(){
		
	}
	void contaFrequencia(){
		
	}
	public BufferedReader getLeitor() {
		return leitor;
	}
	public void setLeitor(BufferedReader leitor) {
		this.leitor = leitor;
	}
}
