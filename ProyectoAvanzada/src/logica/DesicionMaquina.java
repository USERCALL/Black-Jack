package logica;

import java.util.ArrayList;

import vista.Carta;

public class DesicionMaquina
	{

		public boolean maquinaPideCarta(ArrayList<Carta> mano)
			{
				boolean pedir = true;
				int puntaje = 0;
				int valorCarta = 0;
				for (int i = 0; i < mano.size(); i++)
					{

						valorCarta = Integer.parseInt(mano.get(i).getValor());
						if (valorCarta == 11 || valorCarta == 12 || valorCarta == 13)
							{
								valorCarta = 10;
							}
						puntaje = puntaje + valorCarta;
					}

				if (17 <= puntaje)
					{
						pedir = false;
					}

				return pedir;
			}

	}
