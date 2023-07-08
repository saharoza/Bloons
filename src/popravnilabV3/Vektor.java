package popravnilabV3;

public class Vektor implements Cloneable {
	private int x, y;

	public Vektor(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		try {
			Vektor klon = (Vektor) super.clone();
			klon.x = this.x;
			klon.y = this.y;
			return klon;
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

	public Vektor pomnoziVektor(int vrednost) {
		return new Vektor(this.x * vrednost, this.y * vrednost);
	}

	public Vektor saberiVektore(Vektor drugi) {
		return new Vektor(this.x + drugi.x, this.y + drugi.y);
	}
}
