package questao1;
import questao1.Hash;


public class Principal {


	public static void main(String[] args) {
		int tamanho,novoElemento;
		char continuaLoop;
		boolean hashCheia;
		
		System.out.println("Digite o numero de elementos da hash");
		tamanho = (int)System.in.read();
		Hash hash = new Hash(tamanho);
		
		while(true)
		{
			
			novoElemento = (int)System.in.read();
			
			if(hash.isCheio){
				System.out.println("A Hash esta cheia, nao é possível inserir novos elementos");
			}
			else{
				hash.insercao(novoElemento);
			}
			
				break;
			
		}
		
		
	}

}
