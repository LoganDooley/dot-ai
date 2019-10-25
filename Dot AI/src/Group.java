import javafx.scene.layout.Pane;

public class Group {
	private Dot[] _myGroup;
	
	public Group(Pane evolutionPane) {
		_myGroup = new Dot[Constants.POPULATION];
		for(int i = 0; i<_myGroup.length;i++) {
			_myGroup[i] = new Dot();
			evolutionPane.getChildren().add(_myGroup[i].getShape());
		}
	}
	
	public void moveIndividualDots(int round) {
		for(int i = 0; i<_myGroup.length; i++) {
			_myGroup[i].moveDot(round);
		}
	}
	
	public void checkStatus() {
		for(int i = 0; i<_myGroup.length; i++) {
			_myGroup[i].killDotUpdate();
		}
	}
	
	public void sortDots() {
		boolean sorted = false;
		Dot temp;
		while(!sorted) {
			sorted = true;
			for(int i = 0; i<_myGroup.length-1; i++){
				if(_myGroup[i].getDistance()>_myGroup[i+1].getDistance()) {
					temp = _myGroup[i];
					_myGroup[i]=_myGroup[i+1];
					_myGroup[i+1]=temp;
					sorted=false;
				}
			}
		}
	}
	
	public void printDist() {
		System.out.println(_myGroup[0].getDistance());
	}
	
	public void breedDots() {
		double[] dot1;
		double[] dot2;
		int random1;
		int random2;
		double[] newDot = new double[Constants.BRAIN_SIZE];
		int swap;
		int i = 0;
		while(i<(Constants.POPULATION/2)) {
			random1 = (int)(Math.random()*(Constants.POPULATION/2));
			random2 = (int)(Math.random()*(Constants.POPULATION/2));
			dot1 = _myGroup[random1].getBrain().getMovement();
			dot2 = _myGroup[random2].getBrain().getMovement();
			while(dot1.equals(dot2)) {
				random2 = (int)(Math.random()*(Constants.POPULATION/2));
				dot2 = _myGroup[random2].getBrain().getMovement();
			}
			swap = (int)(Math.random()*(Constants.POPULATION));
			if(i < 2) {
				dot1 = _myGroup[i].getBrain().getMovement();
				dot2 = _myGroup[i+1].getBrain().getMovement();
				for(int j = 0; j<newDot.length; j++) {
					if(i<swap) {
						newDot[j] = dot1[j];		
					} else {
						newDot[j] = dot2[j];
					}
				}
				_myGroup[Constants.POPULATION-1-i].setBrain(newDot);
				i++;
			}else if(random1 > 5 &&  random2 > 5) {
					for(int j = 0; j<newDot.length; j++) {
						if(i<swap) {
							newDot[j] = dot1[j];		
						} else {
							newDot[j] = dot2[j];
						}
					}
				_myGroup[Constants.POPULATION-1-i].setBrain(newDot);
				i++;
			}else if(random1 > 10 &&  random2 > 10) {
				if(Math.random()>0.25) {
					for(int j = 0; j<newDot.length; j++) {
						if(i<swap) {
							newDot[j] = dot1[j];		
						} else {
							newDot[j] = dot2[j];
						}
					}
				}
				_myGroup[Constants.POPULATION-1-i].setBrain(newDot);
				i++;
			}else if(random1 > 15 &&  random2 > 15) {
				if(Math.random()>0.50) {
					for(int j = 0; j<newDot.length; j++) {
						if(i<swap) {
							newDot[j] = dot1[j];		
						} else {
							newDot[j] = dot2[j];
						}
					}
				}
				_myGroup[Constants.POPULATION-1-i].setBrain(newDot);
				i++;
			}else {
				if(Math.random()>0.75) {
					for(int j = 0; j<newDot.length; j++) {
						if(i<swap) {
							newDot[j] = dot1[j];		
						} else {
							newDot[j] = dot2[j];
						}
					}
				}
				_myGroup[Constants.POPULATION-1-i].setBrain(newDot);
				i++;
			}
		}
	}
	
	public void resetDots() {
		for(int i = 0; i<_myGroup.length; i++) {
			_myGroup[i].reviveDot();
			_myGroup[i].resetDot();
		}
	}
	
	public void checkWinDots() {
		for(int i = 0; i<_myGroup.length; i++) {
			_myGroup[i].winDot();
		}
	}
	
	public void mutateDots() {
		for(int i = 0; i<_myGroup.length; i++) {
			_myGroup[i].mutateDot();
		}
	}
}
