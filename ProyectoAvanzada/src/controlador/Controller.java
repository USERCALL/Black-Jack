package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import logica.DesicionMaquina;
import logica.JuezJugo;
import vista.Archivos;
import vista.VentanaDeJuego;

public class Controller implements ActionListener
	{

		int cartasSolicitdas = 0;
		private VentanaDeJuego vista;
		private int partidasGanadasMaquina;
		private int partidasGanadasHumano;

		DesicionMaquina maquina = new DesicionMaquina();
		JuezJugo juez = new JuezJugo();

		public Controller(VentanaDeJuego vista)

			{
				this.setVista(vista);

				partidasGanadasMaquina = 0;
				partidasGanadasHumano = 0;

				añadirActionListenerMenubar();
				añadirActionListenerJugador();
			}

		private void añadirActionListenerMenubar()
			{

				/* menu bar numero uno */
				getVista().getMntmEmpezar().addActionListener(this);
				getVista().getMntmReInciar().addActionListener(this);
				getVista().getMntmAbrir().addActionListener(this);
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
				if (e.getSource() == getVista().getMntmReInciar())
					{
						btnMntmReInciar(); 
					}	
				
				
				
				
				
				if (e.getSource() == getVista().getBtnPedir())
					{
						btnPedrCarta();
					}
				if (e.getSource() == getVista().getBtnQuedarse())
					{
						btnQuedarse();
					}
				if (e.getSource() == getVista().getMntmAbrir())
					{
						btnMntmAbrir();
					}
				if (e.getSource() == getVista().getMntmGuardar())
					{
						btnMntmGuardar();
					}
				if (e.getSource() == getVista().getMntmSalir())
					{
						btnMntmSalir();
					}
				if (e.getSource() == getVista().getMntmAcerca())
					{
						btnMntmAcerca();
					}
				if (e.getSource() == getVista().getMntmComoJugar())
					{
						btnMntmComoJugar();
					}

			}

		private void btnMntmComoJugar()
			{
				JOptionPane.showMessageDialog(null, 
						"Selecciona Primero Pedir Carta y presiona quedarse para que \n"
						+ "la maquina destape sus cartas recurda la idea del juego es \n "
						+ "tener una puntuacion de 21 Sdsin excederse \n"
						+ "[si la maquina iguala tu puntaje esta ganara por reglas del juego] ");
				
				
			}

		private void btnMntmAcerca()
			{
			JOptionPane.showMessageDialog(null, "Juego elaborado por USERCALL año 2015 \nBajo licencia GPL3.0 \nSofware lLibre para una sociedad Libre ");
			
			}
		
		private void btnMntmReInciar()
			{
				
				partidasGanadasMaquina=0; 
				partidasGanadasHumano=0; 
				
				getVista().getPaneJuego().getPaneMaquina().limpiar();
				getVista().getPaneJuego().getPaneHumano().limpiar();
				
				getVista().getLblPuntuacionMaquinaValor().setText("Se Reinicio");
				getVista().getLblPuntuacionUsuarioValor().setText("Se Reinicio");
				
			}

		private void btnMntmSalir()
			{
				System.exit(0)
				;
				
			}
		
        private void btnPedrCarta()
			{
				getVista().getPaneJuego().getPaneHumano().solicitarCartas();

				if (true == juez.perdio(getVista().getPaneJuego().getPaneHumano().getArrayCartas()))
					{
						partidasGanadasMaquina++;
						getVista().getLblPuntuacionMaquinaValor().setText(
								Integer.toString(partidasGanadasMaquina) + "]");
						JOptionPane.showMessageDialog(null, "Has superado los 21 puntos \nSe reiniciara", "Perdio",
								JOptionPane.YES_OPTION);

						getVista().getPaneJuego().getPaneHumano().limpiar();
					}
			}

		private void btnQuedarse()
			{

				do
					{
						getVista().getPaneJuego().getPaneMaquina().solicitarCartas();
					} while (true == maquina.maquinaPideCarta(getVista().getPaneJuego().getPaneMaquina()
						.getArrayCartas()));;

				int puntajeHumano = juez.puntajeJugador(getVista().getPaneJuego().getPaneHumano().getArrayCartas());
				int puntajeMaquina = juez.puntajeJugador(getVista().getPaneJuego().getPaneMaquina().getArrayCartas());

				if (juez.isHumanoGanado(puntajeHumano, puntajeMaquina))
					{
						partidasGanadasHumano++;
						JOptionPane.showMessageDialog(null, "le has ganado con [" + puntajeHumano + "] puntos contra ["
								+ puntajeMaquina + "] puntos de la maquina   \nSe reiniciara", "Perdio",
								JOptionPane.YES_OPTION);
						getVista().getLblPuntuacionUsuarioValor().setText(
								(Integer.toString(partidasGanadasHumano) + "]"));;
					} else
					{
						partidasGanadasMaquina++;

						JOptionPane.showMessageDialog(null, "Te ha ganado la maquina con [" + puntajeMaquina
								+ "] puntos contra [" + puntajeHumano + "] puntos tuyos  \nSe reiniciara", "Perdio",
								JOptionPane.YES_OPTION);
						getVista().getLblPuntuacionMaquinaValor().setText(
								Integer.toString(partidasGanadasMaquina) + "]");

					}
				getVista().getPaneJuego().getPaneHumano().limpiar();
				getVista().getPaneJuego().getPaneMaquina().limpiar();

			}

		private void btnMntmGuardar()
			{
				String info = Integer.toString(partidasGanadasHumano) + "," + Integer.toString(partidasGanadasHumano);
				new Archivos().guardarArchivo(info);
			}

		private void btnMntmAbrir()
			{
				Archivos archivo = new Archivos();
				String[] puntuacion = archivo.abrirArchivo();
				partidasGanadasHumano = Integer.parseInt(puntuacion[0]);
				partidasGanadasMaquina = Integer.parseInt(puntuacion[1]);

				getVista().getLblPuntuacionUsuarioValor().setText(puntuacion[0]);
				getVista().getLblPuntuacionMaquinaValor().setText(puntuacion[1]);

			}

	}
