package questao1;

import java.util.ArrayList;


public class Hash {
	private
		ArrayList<Celula> hash;
		int tamanho;
		boolean cheio;
	
	public
		Hash(int tamanho)
		{
			this.tamanho = tamanho;
			hash = new ArrayList(tamanho);
		}
	
		boolean isCheio()
		{
			return cheio;
		}
}
