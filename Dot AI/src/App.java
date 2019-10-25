import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{
	@Override
	public void start(Stage stage) {
		PaneOrganizer organizer = new PaneOrganizer();
		Scene scene = new Scene(organizer.getRoot(), 400, 400);
		stage.setScene(scene);
		stage.setTitle("Evolution");
		stage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
