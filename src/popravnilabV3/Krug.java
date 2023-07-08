package popravnilabV3;

import java.awt.*;

public abstract class Krug {

	protected Vektor centar;
	private Color boja;
	protected int precnik;

	public Krug(Vektor centar, Color boja, int precnik) {
		this.centar = centar;
		this.boja = boja;
		this.precnik = precnik;
	}

	public boolean proveraPreklapanja(Krug drugi) {
		double rastojanjeCentara = Math.sqrt(Math.pow(this.centar.getX() - drugi.centar.getX(), 2)
				+ Math.pow(this.centar.getY() - drugi.centar.getY(), 2));
		if (rastojanjeCentara <= this.precnik / 2 + drugi.precnik / 2)
			return true;
		return false;
	}

	public abstract void iscrtajKrug(Scena scena);

	public abstract void pomeriKrug(Scena scena) throws GOutOfBounds;
}
