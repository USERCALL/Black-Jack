package vista;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class VentanaDeJuego extends JFrame
	{

		private static final long serialVersionUID = 1L;
		private JMenuItem mntmEmpezar;
		private JMenuItem mntmReInciar;
		private JMenuItem mntmGuardar;
		private JMenuItem mntmSalir;
		private JMenuItem mntmComoJugar;
		private JMenuItem mntmAcerca;
		private JButton btnPedir;
		private JButton btnQuedarse;

		private panelJuego paneJuego; 
		private JLabel lblPuntuacionMaquinaValor;
		private JLabel lblPuntuacionUsuarioValor;
		
		public VentanaDeJuego()
			{
				/* informacion basica */
				setTitle("Juego 21");

				getContentPane().setLayout(new BorderLayout(0, 0));

				/* creacion de elemantos */
				createPanelPuntuacion();
				createMenuBar();
				createPaneJuego();
				createBortones();
				
				getContentPane().add(paneJuego, BorderLayout.CENTER); 

				setBounds(0, 0, 700, 700);
				setLocationRelativeTo(null);
				setResizable(false);
				setVisible(true);

			}
		

		private void createMenuBar()
			{

				JMenuBar menuBar = new JMenuBar();
				setJMenuBar(menuBar);

				/*----------------------------------------*/
				JMenu mnJuego = new JMenu("Juego");
				menuBar.add(mnJuego);

				mntmEmpezar = new JMenuItem("Empezar");
				mnJuego.add(mntmEmpezar);

				mntmReInciar = new JMenuItem("Re Inciar");
				mnJuego.add(mntmReInciar);

				mntmGuardar = new JMenuItem("Guardar");
				mnJuego.add(mntmGuardar);

				mntmSalir = new JMenuItem("Salir");
				mnJuego.add(mntmSalir);

				/*----------------------------------------------------------------*/

				JMenu mnInformacion = new JMenu("Informacion");
				menuBar.add(mnInformacion);
				
				mntmComoJugar = new JMenuItem("Como jugar");
				mnInformacion.add(mntmComoJugar);

				mntmAcerca = new JMenuItem("Acerca");
				mnInformacion.add(mntmAcerca);
			}

		private void createPaneJuego(){
			paneJuego =new panelJuego(); 
		}
		
		
		private void createPanelPuntuacion(){
			JPanel panelPuntuacion = new JPanel(new FlowLayout());
			getContentPane().add(panelPuntuacion, BorderLayout.NORTH);
			
			panelPuntuacion.setBorder(new TitledBorder("Puntuacion"));
			
			JLabel lblPuntuacionMaquina = new JLabel("[Maquina:"); 
			panelPuntuacion.add(lblPuntuacionMaquina);
			
			lblPuntuacionMaquinaValor = new JLabel(" No se a empezado]"); 
			panelPuntuacion.add(lblPuntuacionMaquinaValor);
			
			JLabel lblPuntuacionUsuario = new JLabel("[Usuario:"); 
			panelPuntuacion.add(lblPuntuacionUsuario);
			
			lblPuntuacionUsuarioValor = new JLabel(" No se a empezado]"); 
			panelPuntuacion.add(lblPuntuacionUsuarioValor);
			
		}

		private void createBortones()
			{

				JPanel panelBtotones = new JPanel(new FlowLayout());
				getContentPane().add(panelBtotones, BorderLayout.SOUTH);
				panelBtotones.setBorder(new TitledBorder("Opciones"));

				btnPedir = new JButton("Pedir carta");
				panelBtotones.add(btnPedir);

				btnQuedarse = new JButton("Quedarse");
				panelBtotones.add(btnQuedarse);

			}

/*getter and setter*/
		public JMenuItem getMntmEmpezar()
			{
				return mntmEmpezar;
			}


		public JMenuItem getMntmReInciar()
			{
				return mntmReInciar;
			}


		public JMenuItem getMntmGuardar()
			{
				return mntmGuardar;
			}


		public JMenuItem getMntmSalir()
			{
				return mntmSalir;
			}


		public JMenuItem getMntmComoJugar()
			{
				return mntmComoJugar;
			}


		public JMenuItem getMntmAcerca()
			{
				return mntmAcerca;
			}


		public JButton getBtnPedir()
			{
				return btnPedir;
			}


		public JButton getBtnQuedarse()
			{
				return btnQuedarse;
			}


		public panelJuego getPaneJuego()
			{
				return paneJuego;
			}


		public JLabel getLblPuntuacionMaquinaValor()
			{
				return lblPuntuacionMaquinaValor;
			}


		public JLabel getLblPuntuacionUsuarioValor()
			{
				return lblPuntuacionUsuarioValor;
			}

	}
