package trabfinal;

public class Lista {

	private int tipo, k;
	private Celula inicial, ultima;

	public Lista(int tipo) {
		this.tipo = tipo;
		Celula inicial = null;
	}

	public Lista(int tipo,int k) {
		this.tipo = tipo;
		this.k = k;
		Celula inicial = null;
	}

	public Celula busca(int chave) {
		//
		if (inicial == null) {
			return inicial;
		}

		Celula celula = inicial;

		while (celula.getProximo() != null) {
			if (celula.getChave() == chave) {
				arruma(celula);
				return celula;
			}
		}

		return ultima;
	}

	public void insercao(int chave) {
		Celula celula = busca(chave);

		if (celula == null) {
			celula = new Celula(chave, ultima);
			ultima = celula;
			inicial = celula;
			System.out.println("Elemento inserido com sucesso.");
		} else if (celula.getChave() != chave) {
			celula = new Celula(chave, ultima);
			ultima.setProximo(celula);
			ultima = celula;
			System.out.println("Elemento inserido com sucesso.");
		} else {
			System.out.println("Elemento já está na lista.");
		}
	}

	public void remocao(int chave) {
		Celula celula = busca(chave);
		if (celula == null) {
			System.out.println("A lista está vazia.");
		}else if (celula.getChave() == chave) {
			if(celula.getAnterior() != null){
				celula.getAnterior().setProximo(celula.getProximo());
			}
			if(celula.getProximo() != null){
				celula.getProximo().setAnterior(celula.getAnterior());
			}
			System.out.println("Elemento removido com sucesso.");
		}else{
			System.out.println("Elemento não está presente na lista.");
		}
	}

	public void arruma(Celula celula) {
		switch (tipo) {
		case 1:
			moverParaFrente(celula);
		case 2:
			transposicao(celula);
		case 3:
			contadorDeFrequencia(celula);
		}
	}

	public void moverParaFrente(Celula celula) { 
		if (celula.getAnterior() == null) {
			celula.getAnterior().setProximo(celula.getProximo());
			if (celula.getProximo() != null) {
				celula.getProximo().setAnterior(celula.getAnterior());
			}
			celula.setAnterior(null);
			celula.setProximo(inicial);
			inicial.setAnterior(celula);
			inicial = celula;
		}
	}

	public void transposicao(Celula celula) { 
		if (celula.getAnterior() != null) {
			Celula anterior = celula.getAnterior();
			anterior.setProximo(celula.getProximo());
			anterior.setAnterior(celula);
			celula.getAnterior().getAnterior().setProximo(celula);
			celula.setProximo(anterior);
		}
	}

	public void contadorDeFrequencia(Celula celula) {
		celula.setContador(celula.getContador() + 1);

		while (celula.getAnterior() != null) {
			if (celula.getContador() > celula.getAnterior().getContador()) {
				transposicao(celula);
			}
		}

		if (celula.getAnterior() == inicial) {
			if (celula.getContador() > inicial.getContador()) {
				inicial.setProximo(celula.getProximo());
				celula.setProximo(inicial);
				celula.setAnterior(null);
				inicial = celula;
			}
		}
	}

	public void moverParaFrenteK(Celula celula) {
		for (int i = 0; i < k; i++) {
			if (celula.getAnterior() != null) {
				moverParaFrente(celula);
			}
		}
	}
}