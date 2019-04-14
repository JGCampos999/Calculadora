package edu.curso;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Calculadora extends Application {
	double Elem = 0;
	double Total = 0;
	int ContDigiA = 0;
	String Op = "";

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		BorderPane painelPrincipal = new BorderPane();
		FlowPane painelDisplay = new FlowPane();
		GridPane painelBotoes = new GridPane();
		painelDisplay.setHgap(20);
		TextField txtDisplay = new TextField();
		txtDisplay.setPrefWidth(300);
		Button btnCE = new Button("CE");
		btnCE.setPrefWidth(40);
		btnCE.setPrefHeight(40);
		btnCE.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Total = 0;
				Elem = 0;
				Op = "";
				ContDigiA = 0;
				txtDisplay.setText("");
			}

		});
		painelDisplay.getChildren().addAll(txtDisplay, btnCE);
		painelBotoes.setHgap(5);
		painelBotoes.setVgap(5);

		String[] nomes = { "7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", ",", "0", "=", "/", };
		for (int i = 0; i < 16; i++) {
			Button btn = new Button(nomes[i]);
			int row = i / 4;
			int col = i % 4;
			btn.setPrefWidth(40);
			btn.setPrefHeight(40);
			painelBotoes.add(btn, col, row);
			btn.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent e) {
					Button b = (Button) e.getTarget();
					if (Character.isDigit(b.getText().charAt(0))) {
						txtDisplay.setText(txtDisplay.getText() + b.getText());
						String s = Character.toString(b.getText().charAt(0));
						Elem = ((Elem * 10) + Integer.parseInt(s));
						if (txtDisplay.getText().contains(",")) {
							ContDigiA++;
						}
					} else if (b.getText().charAt(0) == nomes[3].charAt(0)) {
						Op = nomes[3];
						if (txtDisplay.getText().contains(",")) {
							Elem = Elem / (Math.pow(10, ContDigiA));
						}
						Total = Elem;
						Elem = 0;
						txtDisplay.setText("");
						ContDigiA = 0;
					} else if (b.getText().charAt(0) == nomes[7].charAt(0)) {
						Op = nomes[7];
						if (txtDisplay.getText().contains(",")) {
							Elem = Elem / (Math.pow(10, ContDigiA));
						}
						Total = Elem;
						Elem = 0;
						txtDisplay.setText("");
						ContDigiA = 0;
					} else if (b.getText().charAt(0) == nomes[11].charAt(0)) {
						Op = nomes[11];
						if (txtDisplay.getText().contains(",")) {
							Elem = Elem / (Math.pow(10, ContDigiA));
						}
						Total = Elem;
						Elem = 0;
						txtDisplay.setText("");
						ContDigiA = 0;
					} else if (b.getText().charAt(0) == nomes[12].charAt(0)) {
						if (!txtDisplay.getText().contains(",")) {
							txtDisplay.setText(txtDisplay.getText() + b.getText());
						}
					} else if (b.getText().charAt(0) == nomes[15].charAt(0)) {
						Op = nomes[15];
						if (txtDisplay.getText().contains(",")) {
							Elem = Elem / (Math.pow(10, ContDigiA));
						}
						Total = Elem;
						Elem = 0;
						txtDisplay.setText("");
						ContDigiA = 0;
					} else {
						if (Op.equals("")) {
							Total = Elem;
						} else {
							if (txtDisplay.getText().contains(",")) {
								Elem = Elem / (Math.pow(10, ContDigiA));
							}
							if (Op.equals("+")) {
								Total = Elem + Total;
							} else if (Op.equals("-")) {
								Total = Total - Elem;
							} else if (Op.equals("*")) {
								Total = Elem * Total;
							} else {
								Total = Total / Elem;
							}
							Op = "";
						}
						if (Total % 1 == 0) {
							txtDisplay.setText("" + Math.round(Total));
						} else {
							txtDisplay.setText("" + Total);
						}
					}
				}
			});
		}
		painelPrincipal.setTop(painelDisplay);
		painelPrincipal.setCenter(painelBotoes);
		Scene scn = new Scene(painelPrincipal);
		stage.setScene(scn);
		stage.show();

	}
}
