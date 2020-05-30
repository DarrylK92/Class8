package application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MouseDemo extends Application{
	@Override
	public void start(Stage stage) throws Exception {
		Pane pane = new Pane();
		
		Text text = new Text(20, 20, "Programming is fun");
		pane.getChildren().add(text);
		
		text.setOnMouseDragged(e -> {
			text.setLayoutX(e.getX());
			text.setLayoutY(e.getY());
		});
		
		
		Scene scene = new Scene(pane, 200, 200);
		stage.setTitle("Mouse Demo");
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
