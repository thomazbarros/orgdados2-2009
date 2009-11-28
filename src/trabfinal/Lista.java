package trabfinal;

public class Lista {

	private int tipo;
	private Celula celula;
	
	public Lista(int tipo, Celula celula){
		this.tipo = tipo;
		this.celula = celula;
	}
	
	public void arruma(Celula celula2){
		switch(tipo){
		  case 1:
			 moverParaFrente(celula2);
		  case 2:
			transposicao(celula2);	
		  case 3:
			// contadorDeFrequencia();
		}
	}
	
	public void moverParaFrente(Celula celula2){
		celula2.getAnterior().setProximo(celula2.getProximo());
		celula2.getProximo().setAnterior(celula2.getAnterior());
		celula2.setAnterior(null);
		celula2.setProximo(celula);
		celula.setAnterior(celula2);
		celula = celula2;
	}
	
	public void transposicao(Celula celula2){
		Celula anterior = celula2.getAnterior();
		anterior.setProximo(celula2.getProximo());
		anterior.setAnterior(celula2);
		celula2.getAnterior().getAnterior().setProximo(celula2);
		celula2.setProximo(anterior);
	}
	
	
}