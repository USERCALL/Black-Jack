package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.Carta;
import vista.VentanaDeJuego;

public class Controller implements ActionListener
	{

		int cartasSolicitdas = 0;
		private VentanaDeJuego vista;

		public Controller(VentanaDeJuego vista)

			{
				this.setVista(vista);
				añadirActionListenerMenubar();
				añadirActionListenerJugador();
			}

		private void añadirActionListenerMenubar()
			{

				/* menu bar numero uno */
				getVista().getMntmEmpezar().addActionListener(this);
				getVista().getMntmReInciar().addActionListener(this);
				getVista().getMntmGuardar().addActionListener(this);
				getVista().getMntmSalir().addActionListener(this);
				/* segundo menu bar */
				getVista().getMntmAcerca().addActionListener(this);
				getVista().getMntmComoJugar().addActionListener(this);

			}

		private void añadirActionListenerJugador()
			{

				/* añadiendo botones del juego */
				getVista().getBtnPedir().addActionListener(this);
				getVista().getBtnQuedarse().addActionListener(this);

			}

		public VentanaDeJuego getVista()
			{
				return vista;
			}

		public void setVista(VentanaDeJuego vista)
			{
				this.vista = vista;
			}

		@Override
		public void actionPerformed(ActionEvent e)
			{
				if (e.getSource() == getVista().getBtnPedir())
					{

						getVista().getPaneJuego().getPaneHumano().mostrarCartas();
				
					}
				if (e.getSource() == getVista().getBtnQuedarse())
					{
			
					}
			}

	}
