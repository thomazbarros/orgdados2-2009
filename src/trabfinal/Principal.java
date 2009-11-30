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
		System.out.println("4 - Sair.");
		//System.out.println(" 4 - Mover para a frente k");
		//System.out.println("5 - Métodos híbridos");
		int leitura = 0;
		Principal principal = new Principal();
		leitura = Integer.parseInt(principal.getLeitor().readLine());
		while ((leitura<= 0 )||( leitura > 4)){ //Provisoriamente será 3
			System.out.println("Tipo inválido. Tente novamente.");
			leitura = Integer.parseInt(principal.getLeitor().readLine());
		}
		
		switch (leitura){
		case 1:
			principal.moveParaFrente();
			break;
		case 2:
			principal.transpoe();
			break;
		case 3:
			principal.contaFrequencia();
			break;
		case 4:
			System.out.println("Saindo...");
			break;
		default: // Apenas uma formalidade. Se tudo estiver certinho, nunca passaremos por aqui.
			System.out.println("Erro estranho. Não era para passarmos nunca por aqui =P");
			break;
		}
	}

	catch(Exception e){}

	}
	void moveParaFrente(){
		int status = 0;
		while(status != -1){
			
		}
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
