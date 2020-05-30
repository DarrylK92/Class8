package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class HandlersDemo extends Application{
	@Override
	public void start(Stage stage) throws Exception {
		Circle c = new Circle();
		
		//HBox
		HBox pane = new HBox(10);
		pane.setAlignment(Pos.CENTER);
		
		//Borderpane
		BorderPane bPane = new BorderPane();
		bPane.setBottom(pane);
		
		//Stackpane
		StackPane sPane = new StackPane();
		bPane.setCenter(sPane);
		
		//Ok button
		Button btnEnlarge = new Button("Enlarge");
		btnEnlarge.setOnAction(e -> {
				c.setRadius(c.getRadius() + 2);
			});
		pane.getChildren().add(btnEnlarge);
		
		//Cancel button
		Button btnShrink = new Button("Shrink");
		btnShrink.setOnAction(e -> {
				if (c.getRadius() > 1) {
					c.setRadius(c.getRadius() - 2);
				}
			});
		pane.getChildren().add(btnShrink);
		
		//Circle
		c.setCenterX(100);
		c.setCenterY(100);
		c.setRadius(1);
		c.setFill(new Color(0, 0, 0, 0));
		c.setStroke(Color.BLACK);
		sPane.getChildren().add(c);
				
		Scene scene = new Scene(bPane, 200, 200);
		stage.setTitle("Handler");
		stage.setScene(scene);
		stage.show();
		
		scene.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.UP) {
				c.setRadius(c.getRadius() + 2);
			} else if (e.getCode() == KeyCode.DOWN){
				if (c.getRadius() > 1) {
					c.setRadius(c.getRadius() - 2);
				}
			}
		});
		
		sPane.setOnMouseClicked(e -> {
			if (e.getButton() == MouseButton.PRIMARY) {
				c.setRadius(c.getRadius() + 2);
			} else if (e.getButton() == MouseButton.SECONDARY){
				if (c.getRadius() > 1) {
					c.setRadius(c.getRadius() - 2);
				}
			}
		});
	}

	public static void main(String[] args) {
		launch(args);
	}
}

