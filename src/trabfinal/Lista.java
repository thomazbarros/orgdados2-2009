package trabfinal;

/*
Trabalho final de Organiza��o de Dados 2
Gustavo Henrique Alves dos Santos DRE:107363191
Leopoldo Andr� Dutra Lusquino Filho DRE:107363002
Thomaz Avila Barros DRE:107363028
Carolina Szkruc de Carvalho DRE:107413394
*/

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
			
			celula = celula.getProximo();
		}
		
		// caso em que a celula retornada � a chave procurada
		// devem ser chamados os m�todos de auto-ajuste
		if(ultima.getChave() == chave){
			Celula temp = ultima;
			arruma(celula);
			return temp;
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
			System.out.println("Elemento j� est� na lista.");
		}
	}

	public void remocao(int chave) {
		Celula celula = busca(chave);
	
		if (celula == null) {
			System.out.println("A lista est� vazia.");
		}else if (celula.getChave() == chave) {
			if(celula.getAnterior() != null){
				celula.getAnterior().setProximo(celula.getProximo());
			}
			if(celula.getProximo() != null){
				celula.getProximo().setAnterior(celula.getAnterior());//temp);
			}
			if(getInicial().getChave() == celula.getChave()){
				setInicial(celula.getProximo());
			}
			if(getUltima().getChave() == celula.getChave()){
				setUltima(celula.getAnterior());
			}
			System.out.println("Elemento removido com sucesso.");
		}else{
			System.out.println("Elemento n�o est� presente na lista.");
		}
	}

	public void arruma(Celula celula) {
		switch (tipo) {
		case 1:
			moverParaFrente(celula);
			break;
		case 2:
			transposicao(celula);
			break;
		case 3:
			contadorDeFrequencia(celula);
			break;
		case 4:
			moverParaFrenteK(celula);
			break;
		}
	}

	public void moverParaFrente(Celula celula) { 
		if (celula.getAnterior() != null) {
			celula.getAnterior().setProximo(celula.getProximo());
			if (celula.getProximo() != null) {
				celula.getProximo().setAnterior(celula.getAnterior());
			}else{
				setUltima(celula.getAnterior());
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
			
			if(celula.getAnterior().getAnterior() != null){
				celula.getAnterior().getAnterior().setProximo(celula);
			}else{
				//anterior � o primeiro n�, logo a c�lula ser� o novo n� inicial
				setInicial(celula);
			}
			celula.setAnterior(celula.getAnterior().getAnterior());
			
			anterior.setProximo(celula.getProximo());
			anterior.setAnterior(celula);
			
			if(celula.getProximo() != null){
				celula.getProximo().setAnterior(anterior);
			}else{
				//c�lula � o �ltimo n�, logo anterior ser� o novo �ltimo n�
				setUltima(anterior);
			}
			celula.setProximo(anterior);
		}
	}

	public void contadorDeFrequencia(Celula celula) {
		celula.setContador(celula.getContador() + 1);

		while ((celula.getAnterior() != null)&&(celula.getContador() > celula.getAnterior().getContador())) {
				transposicao(celula);
		}
		
		if(celula.getAnterior() == null)
		{
			inicial = celula;
		}
	}

	public void moverParaFrenteK(Celula celula) {
		for (int i = 0; i < k; i++) {
			if (celula.getAnterior() != null) {
				transposicao(celula);
			}
		}
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getK() {
		return k;
	}

	public void setK(int k) {
		this.k = k;
	}

	public Celula getInicial() {
		return inicial;
	}

	public void setInicial(Celula inicial) {
		this.inicial = inicial;
	}

	public Celula getUltima() {
		return ultima;
	}

	public void setUltima(Celula ultima) {
		this.ultima = ultima;
	}
}