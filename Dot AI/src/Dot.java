import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class Dot {
	private Ellipse _dotShape;
	private Brain _dotBrain;
	private boolean _alive;
	
	public Dot() {
		_alive = true;
		_dotShape = new Ellipse(5, 5);
		_dotShape.setFill(Color.BLACK);
		_dotShape.setTranslateX(200);
		_dotShape.setTranslateY(390);
		_dotBrain = new Brain();
	}
	
	public Ellipse getShape() {
		return _dotShape;
	}
	
	public void resetDot() {
		_dotShape.setTranslateX(200);
		_dotShape.setTranslateY(390);
		_dotShape.setFill(Color.BLACK);
	}
	
	public Brain getBrain() {
		return _dotBrain;
	}
	
	public void setBrain(double[] newBrain) {
		_dotBrain.setBrain(newBrain);
	}
	
	public void moveDot(int counter) {
		if(_alive) {
			_dotShape.setTranslateX(_dotShape.getTranslateX()+Constants.MOVE_DIST*Math.sin(_dotBrain.getAngle(counter)));
			_dotShape.setTranslateY(_dotShape.getTranslateY()+Constants.MOVE_DIST*Math.cos(_dotBrain.getAngle(counter)));
		}
	}
	
	public double getDistance() {
		return Math.sqrt((_dotShape.getTranslateX()-Constants.GOAL_X)*(_dotShape.getTranslateX()-Constants.GOAL_X)+(_dotShape.getTranslateY()-Constants.GOAL_Y)*(_dotShape.getTranslateY()-Constants.GOAL_Y));
	}
	
	public void killDotUpdate() {
		if(_dotShape.getTranslateY()>400 || _dotShape.getTranslateX()>400 || _dotShape.getTranslateX()<0 || _dotShape.getTranslateY()<0) {
			_alive = false;
		}
		if(_dotShape.getTranslateY()>194 &&  _dotShape.getTranslateY()<210) {
			if(_dotShape.getTranslateX()>150 & _dotShape.getTranslateX()<350) {
				_alive = false;
			}
		}
	}
	
	public void winDot() {
		if(Math.abs(_dotShape.getTranslateX()-Constants.GOAL_X) < 5 && Math.abs(_dotShape.getTranslateY()-Constants.GOAL_Y) < 5) {
			_dotShape.setFill(Color.LAWNGREEN);
			_alive = false;
		}
	}
	
	public void reviveDot() {
		_alive = true;
	}
	
	public void mutateDot() {
		_dotBrain.mutate();
	}
}
