package logica;

import java.util.ArrayList;

import vista.Carta;

public class JuezJugo
	{

		public boolean perdio(ArrayList<Carta> array)
			{
				boolean perdio = false;
				int puntaje = 0;
				int valorCarta = 0;
				for (int i = 0; i < array.size(); i++)
					{

						valorCarta = Integer.parseInt(array.get(i).getValor());
						if (valorCarta == 11 || valorCarta == 12 || valorCarta == 13)
							{
								valorCarta = 10;
							}
						puntaje = puntaje + valorCarta;
					}

				System.out.println("puntaje " + puntaje);

				if (21 <= puntaje)
					{
						perdio = true;
					}
				return perdio;
			}

		public boolean isHumanoGanado(int puntaJeHumano,int puntajeMaquina)
			{
				boolean ganador = false;

				if (puntajeMaquina < puntaJeHumano)
					{
						ganador = true;
					}

				if (21 < puntajeMaquina)
					{
						ganador = true;
					}
				return ganador;
			}

		public int puntajeJugador(ArrayList<Carta> maso)
			{

				int puntaje = 0;
				int valorCarta = 0;
				for (int i = 0; i < maso.size(); i++)
					{

						valorCarta = Integer.parseInt(maso.get(i).getValor());
						if (valorCarta == 11 || valorCarta == 12 || valorCarta == 13)
							{
								valorCarta = 10;
							}
						puntaje = puntaje + valorCarta;
					}

				return puntaje;

			}

	}
