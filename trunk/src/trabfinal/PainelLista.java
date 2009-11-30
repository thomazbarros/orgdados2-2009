package trabfinal;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PainelLista extends JPanel{
	//ArrayList<JLabel> listaLabels;
	
	//public PainelLista(){
	//	listaLabels = new ArrayList<JLabel>();
	//}
	
	void atualizaLista(Lista lista){
		this.removeAll();
		Celula celula;		
		celula = lista.getInicial();
		while(celula != null){
			this.add(new JLabel(String.valueOf(celula.getChave())));
			if(celula.getProximo() == null){
				break;
			}
			celula = celula.getProximo();
		}
	}
	
}
