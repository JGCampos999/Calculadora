package edu.curso;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MinhaJanela {
	private JFrame janela;
	private JPanel painel;
	private JLabel lblHello;

	public MinhaJanela() {
		// Instância os componentes gráficos
		janela = new JFrame();
		painel = new JPanel();
		lblHello = new JLabel("Eu gosto de Java...");
		// Conecta, uns aos outros
		painel.add(lblHello);
		janela.setContentPane(painel);
		// Mostra a janela na tela
		janela.setSize(300, 300);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}