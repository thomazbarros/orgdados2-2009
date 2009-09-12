package questao2;

public class Principal {


	public static void main(String[] args) {

		System.out.println("Digite o numero de elementos da hash");
		int tamanho = (int)System.in.read();
		Hash hash = new Hash(tamanho);
		
		while(true)
		{
			System.out.println("Digite o que deseja fazer :");
			System.out.println("1-Inserir novo elemento");
			System.out.println("2-Buscar um elemento");
			System.out.println("3-Remover um elemento");
			System.out.println("4-Sair");
			
			int opcao = (int)System.in.read();
			
			switch(opcao){
			
				case 1 : 
					
					System.out.println("Digite o elemento que deseja inserir");
					int elementoInsercao = (int)System.in.read();
					
					//if(hash.isCheio()){
				//		System.out.println("A Hash esta cheia, nao é possível inserir novos elementos");
					//}
					//else{
						hash.insercao(elementoInsercao);
				//		System.out.println("O elemento " + elementoInsercao + " foi inserido com sucesso");
				//	}
					
				case 2 : 
					
					System.out.println("Digite o elemento que deseja remover");
					int elementoRemocao = (int)System.in.read();
					
					hash.remocao(elementoRemocao);
					//boolean removido = hash.insercao(elementoRemocao);
					//if(removido){
					//	System.out.println("O elemento " +elementoRemocao+ " foi removido com sucesso");
					//}
					//else{
					//	System.out.println("O elemento " +elementoRemocao+ " nao existe na hash");
				//	}
					
				case 3 : 
					
					System.out.println("Digite o elemento que deseja remover");
					int elementoBusca = (int)System.in.read();
					
					int index = hash.busca(elementoBusca);
					if(Math.abs(hash.getHash().get(index).getEstado()) == 1 && hash.getHash().get(index).getChave() == elementoBusca){
						System.out.println("O elemento " +elementoBusca+ " esta na hash");
					}
					else{
						System.out.println("O elemento " +elementoBusca+ " nao esta na hash");
					}
					
				case 4 : 
					
					break;
					
			}			
		}	
	}
}
