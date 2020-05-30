package application;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AnimationDemo extends Application{
	@Override
	public void start(Stage stage) throws Exception {
		Pane pane = new Pane();
		
		ImageView iv = new ImageView("flag.gif");
		iv.setScaleX(0.5);
		iv.setScaleY(0.5);
		pane.getChildren().add(iv);
		
		//animation with PathTransition
		PathTransition pt = new PathTransition(Duration.millis(10000), new Circle(200), iv);
		pt.setCycleCount(5);
		pt.play();
		
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setTitle("Animation");
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
