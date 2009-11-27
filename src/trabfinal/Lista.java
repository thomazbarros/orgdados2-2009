package trabfinal;

public class Lista {

	private int tipo;
	private Celula celula;
	
	public Lista(int tipo, Celula celula){
		this.tipo = tipo;
		this.celula = celula;
	}
	
	public void arruma(){
		switch(tipo){
		  case 1:
			 // moverParaFrente();
		  case 2:
			//  transposicao();	
		  case 3:
			// contadorDeFrequencia();
		}
	}
	
	public void moverParaFrente(Celula celula2)
	{
		celula2.getAnterior().setProximo(celula2.getProximo());
		celula2.getProximo().setAnterior(celula2.getAnterior());
		celula2.setAnterior(null);
		celula2.setProximo(celula);
		celula.setAnterior(celula2);
		celula = celula2;
	}

}