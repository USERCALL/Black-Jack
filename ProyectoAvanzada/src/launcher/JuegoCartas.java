package launcher;

import controlador.Controller;
import vista.VentanaDeJuego;

public class JuegoCartas
	{
		public static void main(String[] args)
			{
			new Controller(	new VentanaDeJuego()); 
			}
	}
