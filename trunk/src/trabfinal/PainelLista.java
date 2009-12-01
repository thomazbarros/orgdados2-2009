package trabfinal;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PainelLista extends JPanel{
	
	void atualizaLista(Lista lista){
		JLabel temp;
		int i = 0;
		
		this.removeAll();
		
		Celula celula;		
		celula = lista.getInicial();
		while(celula != null){
			temp = new JLabel(String.valueOf(celula.getChave()));
			//temp.setBounds(new Rectangle(0 + i*10,0,100,100));//100*(i+1), 800, 100, 100));
			temp.setBorder(BorderFactory.createLineBorder(Color.black));
			this.add(temp);
			if(celula.getProximo() == null){
				break;
			}
			celula = celula.getProximo();
			i++;
		}
		this.revalidate();
		this.repaint();
	}
	
}
