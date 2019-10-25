import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class Obstacles {
	private Rectangle _wall;
	
	public Obstacles(Pane evolutionPane) {
		_wall = new Rectangle(200, 10);
		_wall.setX(150);
		_wall.setY(200);
		evolutionPane.getChildren().add(_wall);
	}
}
