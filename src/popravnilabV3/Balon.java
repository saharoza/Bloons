package popravnilabV3;

import java.awt.*;

public class Balon extends KruznaFigura {

	public Balon(Vektor centar, Color boja, double precnik, Vektor brzina, Scena scena) {
		super(centar, Color.red, 20, new Vektor(0, 10), scena);
		// System.out.println("generisem balon");
	}

	@Override
	public void iscrtajKrug(Scena scena) {
		Graphics g = scena.getGraphics();
		g.setColor(Color.red);
		g.fillOval(super.centar.getX() - 10, super.centar.getY() - 10, precnik, precnik);
	}

	@Override
	public void pomeriKrug(Scena scena) throws GOutOfBounds {
		this.centar = this.centar.saberiVektore(brzina);
		if ((centar.getX() < 0) || (centar.getX() > scena.getWidth()) || (centar.getY() < 0)
				|| (centar.getY() > scena.getHeight()))
			throw new GOutOfBounds();

	}

}
