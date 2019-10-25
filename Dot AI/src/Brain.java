
public class Brain {
	private double[] _movements;
	
	public Brain() {
		_movements = new double[Constants.BRAIN_SIZE];
		for(int i = 0; i<_movements.length; i++) {
			_movements[i] = Math.random()*(2*Math.PI);
		}
	}
	
	public void mutate() {
		for(int i = 0; i<_movements.length; i++) {
			if(Math.random()<0.30) {
				_movements[i] = _movements[i]+Math.random()*((Math.PI)/4)-Math.PI/8;
			}
		}
	}

	public double getAngle(int i) {
		return _movements[i];
	}
	
	public double[] getMovement() {
		return _movements;
	}
	
	public void setBrain(double[] newMovements) {
		for(int i = 0; i<_movements.length;i++) {
			_movements[i] = newMovements[i];
		}
	}
}
