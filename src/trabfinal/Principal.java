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
		System.out.println("Digite qual tipo de lista autoajust�vel voc� deseja usar:");
		System.out.println("1 - Mover para a frente;");
		System.out.println("2 - Transposi��o;");
		System.out.println("3 - Contador de frequ�ncia;");
		//System.out.println(" 4 - Mover para a frente k");
		//System.out.println("5 - M�todos h�bridos");
		int leitura = 0;
		Principal principal = new Principal();
		leitura = Integer.parseInt(principal.getLeitor().readLine());
		while ((leitura<= 0 )||( leitura > 3)){ //Provisoriamente ser� 3
			System.out.println("Tipo inv�lido. Tente novamente.");
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
		default:
			System.out.println("Erro estranho. N�o era para passarmos nunca por aqui =P");
			break;
		}
	}

	catch(Exception e){}

	}
	void moveParaFrente(){
		int status = 0;
		
		//while
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
