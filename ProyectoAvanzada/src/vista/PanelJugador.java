package vista;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import logica.JuezJugo;

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

		public void solicitarCartas()
			{

				int v = GenerarAleatorio();

				System.out.println("valor de carta" + v);

				carta1 = new Carta(Integer.toString(v), Carta.PICA);
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
		
		
		public void limpiar(){
			
			arrayCarta.clear(); 
			/*remuelve  lo del pane*/
			this.removeAll();
			
			/*repinta las cosas del panel*/
			updateUI();
			
			
		}
		
		
		public ArrayList<Carta> getArrayCartas(){
			
			return arrayCarta; 
		}
		
		
		

	}
