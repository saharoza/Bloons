package popravnilabV3;

import java.awt.Color;

public abstract class KruznaFigura extends Krug {

	protected Vektor brzina;
	protected Scena scena;

	public KruznaFigura(Vektor centar, Color boja, int precnik, Vektor brzina, Scena scena) {
		super(centar, boja, precnik);
		this.brzina = brzina;
		this.scena = scena;
	}

	private void pomeri(Scena scena) throws GOutOfBounds {
		this.centar = this.centar.saberiVektore(this.brzina);
	}

	@Override
	public abstract void iscrtajKrug(Scena scena);

}
