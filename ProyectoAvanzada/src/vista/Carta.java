package vista;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Carta extends JPanel
	{

		private static final long serialVersionUID = 1L;
		private String valor;
		private String palo;
		private Image imagen;
		
		public static String CORAZON="1"; 
		public static String TREBOL="2"; 
		public static String DIAMANTE="3"; 
		public static String PICA="4"; 

		public Carta(String valor, String palo)
			{
				setValor(valor);
				setPalo(palo);
			
				
				JLabel lblValor = new JLabel(valor);
				add(lblValor);
				JLabel lblPalo = new JLabel(palo);
				add(lblPalo)		; 
				
				lblPalo.setVisible(false);
				lblValor.setVisible(false);
				
				

				
				setPreferredSize(new Dimension(74, 98));
			}

		@Override
		protected void paintComponent(Graphics g)
			{
				/* permitira cargar imagen */
				

				try
					{
						imagen = new ImageIcon(getClass().getResource("/palo"+palo+"_"+valor+".jpg")).getImage();

					} catch (NullPointerException e)
					{
						System.out.println("Error");
					}


			g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this); // renderiza
			
		
	}

		/* getter and setter */

		public String getPalo()
			{
				return palo;
			}

		public void setPalo(String palo)
			{
				this.palo = palo;
			}

		public String getValor()
			{
				return valor;
			}

		public void setValor(String valor)
			{
				this.valor = valor;
			}

		public Image getImagen()
			{
				return imagen;
			}

		public void setImagen(Image imagen)
			{
				this.imagen = imagen;
			}
	}
