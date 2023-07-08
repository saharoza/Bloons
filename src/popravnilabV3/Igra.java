package popravnilabV3;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Igra extends Frame {
	private Scena scena;

	public Igra() {
		super("Baloni");
		this.setSize(300, 700);
		this.setBounds(getX(), getY(), 300, 700);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		scena = new Scena();
		add(scena, BorderLayout.CENTER);
		scena.repaint();
		scena.setFocusable(true);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Igra();
	}
}
