package trabfinal;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class Janela extends JFrame{
	PainelLista painelLista;
	
	public Janela(){
		inicializaComponentes();
	}
	
	private void inicializaComponentes() {
		setPreferredSize(new Dimension(1024	, 100));
		setTitle("Listas Auto-Ajustáveis");
		setDefaultLookAndFeelDecorated(true);
		setDefaultCloseOperation(Janela.EXIT_ON_CLOSE);
		painelLista = new PainelLista();
		painelLista.setPreferredSize(new Dimension(1024, 100));
		JScrollPane scrollPainelLista = new JScrollPane(painelLista);
		scrollPainelLista.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPainelLista.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		setContentPane(painelLista); 
		pack();
		setResizable(true);
		setVisible(true);
	}

	public PainelLista getPainelLista() {
		return painelLista;
	}

	public void setPainelLista(PainelLista painelLista) {
		this.painelLista = painelLista;
	}
	
}
