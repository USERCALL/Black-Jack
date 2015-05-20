package vista;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelJugador extends JPanel
	{

		private static final long serialVersionUID = 1L;

		Carta carta1;

		ArrayList<Carta> arrayCarta;

		public PanelJugador(String jugador)
			{

				setBorder(new TitledBorder(jugador));
				setLayout(new FlowLayout());
				setOpaque(false);

				arrayCarta = new ArrayList<Carta>();

			}

		public void solicitarCartas()
			{

				int valorCarta = generarValorAleatorio();

				System.out.println("valor de carta" + valorCarta);

				carta1 = new Carta(Integer.toString(valorCarta), generarPaloAleatorio());
				add(carta1);
				arrayCarta.add(carta1);
				updateUI();

			}

		private String generarPaloAleatorio()
			{
				int rdnInt = 0;
				String  palo =""; 
				try
					{
						SecureRandom number = SecureRandom.getInstance("SHA1PRNG");
						// Generate 20 integers 0..20

						rdnInt = number.nextInt(3);
						rdnInt++;
					} catch (NoSuchAlgorithmException nsae)
					{
						// Forward to handler
					}

				if (1 == rdnInt)
					{
						palo = Carta.CORAZON;
					}
				if (2 == rdnInt)
					{
						palo = Carta.TREBOL;
					}
				if (3 == rdnInt)
					{
						palo = Carta.DIAMANTE;
					}
				if (4 == rdnInt)
					{
						palo = Carta.PICA;
					}

				return palo;

			}

		private int generarValorAleatorio()
			{

				int rdnInt = 0;
				try
					{
						SecureRandom number = SecureRandom.getInstance("SHA1PRNG");
						// Generate 20 integers 0..20

						rdnInt = number.nextInt(12);
						rdnInt++;
					} catch (NoSuchAlgorithmException nsae)
					{
						// Forward to handler
					}

				return rdnInt;
			}

		public void limpiar()
			{

				arrayCarta.clear();
				/* remuelve lo del pane */
				this.removeAll();

				/* repinta las cosas del panel */

				repaint();
				updateUI();

			}

		public ArrayList<Carta> getArrayCartas()
			{

				return arrayCarta;
			}

	}
