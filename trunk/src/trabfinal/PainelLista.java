package trabfinal;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
Trabalho final de Organização de Dados 2
Gustavo Henrique Alves dos Santos DRE:107363191
Leopoldo André Dutra Lusquino Filho DRE:107363002
Thomaz Avila Barros DRE:107363028
Carolina Szkruc de Carvalho DRE:107413394
*/

public class PainelLista extends JPanel{
	
	void atualizaLista(Lista lista){
		JLabel temp;
		int i = 0;
		
		this.removeAll();
		
		Celula celula;		
		celula = lista.getInicial();
		while(celula != null){
			if(lista.getTipo() == 3){
				temp = new JLabel(String.valueOf(celula.getChave()+" / "+celula.getContador()));
			}else{
				temp = new JLabel(String.valueOf(celula.getChave()));
			}
			temp.setBorder(BorderFactory.createLineBorder(Color.black));
			temp.setFont(new Font("Serif", Font.BOLD ,22));
			temp.setBounds(new Rectangle(0,0,100,100));
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
