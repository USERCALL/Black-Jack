package vista;




import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.BoxLayout;

public class panelJuego extends JPanel
	{

		private static final long serialVersionUID = 1L;
		private PanelJugador paneMaquina;
		private PanelJugador paneHumano;
		//private Image imagen;

		public panelJuego()
			{

				setBounds(0, 0, 300, 300);
				setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
				
				createPanelMaquina();
				createPanelHumano();
				
			}
/*creacion de paneles*/
		private void createPanelMaquina()
			{
				paneMaquina = new PanelJugador("Maquina");
				add(paneMaquina);

			}

		private void createPanelHumano()
			{

				paneHumano = new PanelJugador("Humano");
				add(paneHumano);
			}
/*getter*/
		public PanelJugador getPaneMaquina()
			{
				return paneMaquina;
			}

		public PanelJugador getPaneHumano()
			{
				return paneHumano;
			}

	
		Image imagen;
		  protected void paintComponent(Graphics g) {

			  try { imagen = new
						ImageIcon(getClass().getResource("/panio.jpg")).getImage(); } catch
						 (NullPointerException e) { System.out.println("Error no se craga imagen"); }
						 
						 g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this); //renderiza
				
			
			    }
		

	
		
		

	}