package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Calculator extends Application{
	@Override
	public void start(Stage stage) throws Exception {
		//Create BorderPane
		BorderPane bPane = new BorderPane();
		
		//Create HBox for numbers and result
		HBox top = new HBox(10);
		top.setAlignment(Pos.CENTER);
		bPane.setTop(top);
		
		//Create HBox for buttons
		HBox bottom = new HBox(10);
		bottom.setAlignment(Pos.CENTER);
		bPane.setBottom(bottom);
		
		//Create objects for top HBox
		Text num1 = new Text("Number 1: ");
		TextField num1Edit = new TextField();
		Text num2 = new Text("Number 2: ");
		TextField num2Edit = new TextField();
		Text result = new Text("Result: ");
		TextField resultEdit = new TextField();
		resultEdit.setDisable(true); //Disable user from editing contents of textField
		top.getChildren().addAll(num1, num1Edit, num2, num2Edit, result, resultEdit);
		
		//Create objects for bottom HBox
		//Add button
		Button add = new Button("Add");
		add.setOnAction(e -> {
			try {
				double ans = Double.parseDouble(num1Edit.getText()) + Double.parseDouble(num2Edit.getText());
				resultEdit.setText(String.valueOf(ans));
			} catch(Exception exception) {
				resultEdit.setText("Error");
			}
			
		});
		
		//Subtract button
		Button subtract = new Button("Subtract");
		subtract.setOnAction(e -> {
			try {
				double ans = Double.parseDouble(num1Edit.getText()) - Double.parseDouble(num2Edit.getText());
				resultEdit.setText(String.valueOf(ans));
			} catch(Exception exception) {
				resultEdit.setText("Error");
			}
			
		});
		
		//Multiply button
		Button multiply = new Button("Multiply");
		multiply.setOnAction(e -> {
			try {
				double ans = Double.parseDouble(num1Edit.getText()) * Double.parseDouble(num2Edit.getText());
				resultEdit.setText(String.valueOf(ans));
			} catch(Exception exception) {
				resultEdit.setText("Error");
			}
		});
		
		//Divide button
		Button divide = new Button("Divide");
		divide.setOnAction(e -> {
			try {
				double ans = Double.parseDouble(num1Edit.getText()) / Double.parseDouble(num2Edit.getText());
				resultEdit.setText(String.valueOf(ans));
			} catch(Exception exception) {
				resultEdit.setText("Error");
			}
		});
		
		bottom.getChildren().addAll(add, subtract, multiply, divide);
		
		Scene scene = new Scene(bPane);
		stage.setScene(scene);
		stage.setTitle("Calculator");
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
