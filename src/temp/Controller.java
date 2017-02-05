package temp;

public class Controller {

	/* Variables */
	private int temp;
	private int[] preset = new int[2];

	public final int MIN = 50;
	public final int MAX = 100;
	
	/* Getters & Setters */
	public int getTemp() {
		return temp;
	}

	public void setTemp(int temp) {
		if (temp > MAX) {
			temp = MAX;
		} else if (temp < MIN) {
			temp = MIN;
		}
		this.temp = temp;
	}
	
	/* Methods */
	public void setPreset(int val) {
		setTemp(preset[val]);
	}
}
