import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class PaneOrganizer {
	private BorderPane _root;
	private Timeline _myTimeline;
	private Group _myDots;
	
	public PaneOrganizer() {
		_root = new BorderPane();
		Pane evolutionPane = new Pane();
		_myDots = new Group(evolutionPane);
		Obstacles myObstacles = new Obstacles(evolutionPane);
		_root.setCenter(evolutionPane);
		this.setTimeline();
	}
	
	public Pane getRoot() {
		return _root;
	}
	
	public void setTimeline() {
		_myTimeline = new Timeline();
		KeyFrame key = new KeyFrame(Duration.millis(5), new MoveHandler());
		_myTimeline.getKeyFrames().add(key);
		_myTimeline.setCycleCount(Constants.BRAIN_SIZE);
		_myTimeline.play();
	}
	
	private class MoveHandler implements EventHandler<ActionEvent>{
		private int _moveNumber;
		public MoveHandler() {
			_moveNumber = 0;
		}
		public void handle(ActionEvent e) {
			_myDots.checkStatus();
			_myDots.moveIndividualDots(_moveNumber);
			_myDots.checkWinDots();
			_moveNumber++;
			if(_moveNumber>=Constants.BRAIN_SIZE) {
				_myDots.sortDots();
				_myDots.printDist();
				_myDots.breedDots();
				_myDots.resetDots();
				_myDots.mutateDots();
				setTimeline();
			}
		}
	}
}
