package popravnilabV3;

import java.awt.*;

public class Igrac extends KruznaFigura {

	public Igrac(Vektor centar, Color boja, int precnik, Vektor brzina, Scena scena) {
		super(centar, Color.green, precnik, brzina, scena);
	}

	@Override
	public void iscrtajKrug(Scena scena) {
		Graphics g = scena.getGraphics();
		g.setColor(Color.green);
		g.fillOval(super.centar.getX(), super.centar.getY(), precnik, precnik);
		g.setColor(Color.blue);
		g.fillOval(super.centar.getX() + precnik / 4, super.centar.getY() + precnik / 4, precnik / 2, precnik / 2);
	}

	public void preklapaSe(Krug krug) {
		if (this.proveraPreklapanja(krug))
			this.scena.zaustaviScenu();
	}

	public void pomeriIgraca(int pomeraj) {
		Vektor noviCentar = this.centar.saberiVektore(this.brzina.pomnoziVektor(pomeraj));
		if (noviCentar.getX() > scena.getWidth() || noviCentar.getX() < 0)
			return;
		centar = noviCentar;
		iscrtajKrug(this.scena);
	}

	@Override
	public void pomeriKrug(Scena scena) throws GOutOfBounds {
		return;
	}
}
