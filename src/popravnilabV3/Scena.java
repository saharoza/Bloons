package popravnilabV3;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Scena extends Canvas implements Runnable {

	// private Igra mojaIgra;
	private Thread nitScene;
	private Igrac igrac;
	private Balon balon;
	protected ArrayList<Balon> baloni = new ArrayList<>();
	private int duzina = 300;
	private int sirina = 600;

	public Scena() {
		super();
		napraviScenu();
		this.nitScene = new Thread(this);

		this.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_A:
					pomeriIgraca(-1);
					break;
				case KeyEvent.VK_D:
					pomeriIgraca(1);
					break;
				}
			}

		});
		this.pokreniScenu();
	}

	private void napraviScenu() {
		this.setSize(duzina, sirina);
		igrac = new Igrac(new Vektor(duzina / 2 - 15, sirina - 15), Color.GREEN, 30, new Vektor(15, 0), this);
		this.generisiBalon();

	}

	protected void pomeriIgraca(int i) {
		this.igrac.pomeriIgraca(i);

	}

	public void pokreniScenu() {
		if (nitScene == null)
			nitScene = new Thread(this);
		nitScene.start();
	}

	public void zaustaviScenu() {
		nitScene.interrupt();
	}

	@Override
	public void run() {
		while (!Thread.interrupted()) {
			try {
				Thread.sleep(60);
				azuriraj();
				repaint();
			} catch (InterruptedException e) {
				break;
			}
			repaint();
		}
		zaustaviScenu();
	}

	private void azuriraj() {
		int ind = 0;
		LinkedList<Integer> izbaci = new LinkedList<Integer>();
		for (Balon balon : baloni) {
			try {
				balon.pomeriKrug(this);
			} catch (GOutOfBounds e) {
				izbaci.add(ind);
			}
			ind++;
		}
		for (Integer i : izbaci) {
			baloni.remove(i.intValue());
		}

		for (Balon balon : baloni) {
			if (balon.proveraPreklapanja(igrac))
				nitScene.interrupt();
		}

		generisiBalon();
		repaint();
	}

	private void generisiBalon() {
		double rand = Math.random();
		if (rand >= 0.9) {
			int x = (int) (Math.random() * sirina);
			Vektor polozaj = new Vektor(x, 0);
			balon = new Balon(polozaj, Color.RED, 20, new Vektor(0, 15), this);
			if (zauzeto(balon))
				return;
			else {
				baloni.add(balon);
			}
		}
		repaint();
	}

	private boolean zauzeto(popravnilabV3.Balon balon2) {
		boolean preklapanje = false;
		for (int i = 0; i < baloni.size(); i++) {
			if (baloni.get(i).proveraPreklapanja(balon2)) {
				preklapanje = true;
				break;
			}
		}
		return preklapanje;
	}

	@Override
	public void paint(Graphics g) {
		setBackground(Color.WHITE);
		if (igrac != null)
			igrac.iscrtajKrug(this);
		for (int i = 0; i < baloni.size(); i++)
			if (baloni.get(i) != null)
				baloni.get(i).iscrtajKrug(this);
	}

}
