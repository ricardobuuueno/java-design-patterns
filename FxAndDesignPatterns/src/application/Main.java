package application;
	
import application.pattern.mediator.Label;
import application.pattern.mediator.Slider;
import application.pattern.mediator.TextBox;
import application.pattern.mediator.UIMediator;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			UIMediator mediator = new UIMediator();
			Slider slider = new Slider(mediator);
			TextBox box = new TextBox(mediator);
			Label label = new Label(mediator);
			
			GridPane grid = new GridPane();
			grid.setAlignment(Pos.CENTER);
			grid.setVgap(20);
			grid.setPadding(new Insets(25,25,25,25));
			grid.add(label, 0, 0);
			grid.add(slider, 0, 1);
			grid.add(box, 0, 2);			
			
			Scene scene = new Scene(grid,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Mediator Pattern");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
