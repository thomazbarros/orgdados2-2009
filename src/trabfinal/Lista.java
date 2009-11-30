package trabfinal;

public class Lista {

	private int tipo, k;
	private Celula inicial, ultima;
	
	public Lista(int tipo, Celula inicial){
		this.tipo = tipo;
		this.inicial = inicial;
	}
	
	public Celula busca(int chave){
		Celula celula= inicial;
		
		while(celula.getProximo() != null)
		{
			if(celula.getChave() == chave)
			{
				arruma(celula);
				return celula;
			}
		}
		
		return ultima;
	}
	
	public void insercao(int chave){
		Celula celula = busca(chave);
		
		if(celula.getChave() != chave)
		{
			celula = new Celula(chave, ultima);
			ultima.setProximo(celula);
			ultima = celula;
		}
	}
	
	public void remocao(int chave){
		Celula celula = busca(chave);
		
		if(celula.getChave() == chave)
		{
			celula.getAnterior().setProximo(celula.getProximo());
			celula.getProximo().setAnterior(celula.getAnterior());
		}
	}
	
	public void arruma(Celula celula){
		switch(tipo){
		  case 1:
			 moverParaFrente(celula);
		  case 2:
			transposicao(celula);	
		  case 3:
			contadorDeFrequencia(celula);
		}
	}
	
	public void moverParaFrente(Celula celula){ //ainda falta tratar se a célula é o nó-cabeça
		celula.getAnterior().setProximo(celula.getProximo());
		if(celula.getProximo() != null)
		{
			celula.getProximo().setAnterior(celula.getAnterior());
		}
		celula.setAnterior(null);
		celula.setProximo(inicial);
		inicial.setAnterior(celula);
		inicial = celula;
	}
	
	public void transposicao(Celula celula){ //ainda falta tratar se a célula é o nó-cabeça
		Celula anterior = celula.getAnterior();
		anterior.setProximo(celula.getProximo());
		anterior.setAnterior(celula);
		celula.getAnterior().getAnterior().setProximo(celula);
		celula.setProximo(anterior);
	}
	
	public void contadorDeFrequencia(Celula celula){
		celula.setContador(celula.getContador()+1);
		
		while(celula.getAnterior() != null)
		{
			if(celula.getContador() > celula.getAnterior().getContador())
			{
				transposicao(celula);
			}
		}
		
		if(celula.getAnterior() == inicial)
		{
			if(celula.getContador() > inicial.getContador())
			{
				inicial.setProximo(celula.getProximo());
				celula.setProximo(inicial);
				celula.setAnterior(null);
				inicial = celula;
			}
		}
	}


public void moverParaFrenteK(Celula celula){ //ainda falta tratar se a célula é o nó-cabeça
	for(int i = 0; i < k; i++)
	{
		moverParaFrente(celula);
	}
}
}