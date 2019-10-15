package dad.javafx.copyreplace;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CopyReplace extends Application {

	private Label searchLbl, replaceLbl;
	private TextField searchTxt, replaceTxt;
	private Button searchBt, replaceBt, replaceAllBt, closeBt, helpBt;
	private CheckBox caseCheck, searchBackCheck, regExpCheck, stickOutCheck;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		searchLbl = new Label("Buscar:");
		replaceLbl = new Label("Reemplazar con:");
		
		searchTxt = new TextField();
		replaceTxt = new TextField();
		
		searchBt = new Button("Buscar");
		searchBt.setMaxWidth(Double.MAX_VALUE);
		searchBt.setDefaultButton(true);
		
		replaceBt = new Button("Reemplazar");
		replaceBt.setMaxWidth(Double.MAX_VALUE);
		replaceAllBt = new Button("Reemplazar todo");
		replaceAllBt.setMaxWidth(Double.MAX_VALUE);
		closeBt = new Button("Cerrar");
		closeBt.setMaxWidth(Double.MAX_VALUE);
		helpBt = new Button("Ayudar");
		helpBt.setMaxWidth(Double.MAX_VALUE);
		
		caseCheck = new CheckBox("Mayúsculas  y minúsculas");
		searchBackCheck = new  CheckBox("Buscar hacia atrás");
		regExpCheck = new CheckBox("Expresión regular");
		stickOutCheck = new CheckBox("Resaltar resultados");
		
		// 3 columnas y 4 filas
		GridPane searchGrid = new GridPane();
		searchGrid.addRow(0, searchLbl, searchTxt);
		searchGrid.addRow(1, replaceLbl, replaceTxt);
		
		GridPane checkGrid = new GridPane();
		checkGrid.addRow(0, caseCheck, searchBackCheck);
		checkGrid.addRow(1, regExpCheck, stickOutCheck);
		checkGrid.setHgap(5);
		checkGrid.setVgap(5);
		
		searchGrid.setHgap(5);
		searchGrid.setVgap(5);
		
		searchGrid.add(checkGrid, 1, 2);
		
		ColumnConstraints[] cols = {
			
				new ColumnConstraints(),
				new ColumnConstraints()
		};
		
		cols[1].setFillWidth(true);
		cols[1].setHgrow(Priority.ALWAYS);
		searchGrid.getColumnConstraints().addAll(cols);
		
		VBox btBox = new VBox(5, searchBt, replaceBt, replaceAllBt, closeBt, helpBt);
		
		BorderPane root = new BorderPane();
		root.setCenter(searchGrid);
		root.setRight(btBox);
		root.setPadding(new Insets(5, 5, 5, 5));
		BorderPane.setMargin(searchGrid, new Insets(0,15,0,0));
		BorderPane.setAlignment(btBox, Pos.CENTER);
		
		Scene scene = new Scene(root, 600, 200);
		
		primaryStage.setTitle("Buscar y reemplazar");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);

	}

}
