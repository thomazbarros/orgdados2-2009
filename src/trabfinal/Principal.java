package trabfinal;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Principal {
public static void main(String[] args) {


	BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in));  
	try{
		System.out.println("Digite qual tipo de lista autoajustável você deseja usar:");
		System.out.println("1 - Mover para a frente;");
		System.out.println("2 - Transposição;");
		System.out.println("3 - Contador de frequência;");
		//System.out.println(" 4 - Mover para a frente k");
		//System.out.println("5 - Métodos híbridos");
		int leitura = 0;
		leitura = Integer.parseInt(leitor.readLine());
		while ((leitura<= 0 )||( leitura > 5)){
			System.out.println("Tipo inválido. Tente novamente.");
				leitura = Integer.parseInt(leitor.readLine());
				}
	}
	catch(Exception e){}
	
}
}
