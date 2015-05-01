package vista;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Random;

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

				arrayCarta = new ArrayList<Carta>();

			}

		public void mostrarCartas()
			{

				Random rnd = new Random();

				System.out.println("Primera secuencia.");
				System.out.println((rnd.nextInt(13) + 1));

				carta1 = new Carta(Integer.toString(GenerarAleatorio()), Carta.PICA);
				add(carta1);
				arrayCarta.add(carta1);
				updateUI();

			}

		private int GenerarAleatorio()
			{
				Random Aleatorio = new Random();
				int Dado;

				Dado = Aleatorio.nextInt(13) + 1;
				return Dado;
			}

	}
