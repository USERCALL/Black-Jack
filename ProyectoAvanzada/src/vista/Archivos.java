package vista;

//SimpleFileChooser.java
//A simple file chooser to see what it takes to make one of these work.
//

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.*;

public class Archivos
	{

		public void guardarArchivo(String info)
			{
				try
					{
						@SuppressWarnings("unused")
						String nombre = "";
						JFileChooser file = new JFileChooser();
						file.showSaveDialog(file);
						File guarda = file.getSelectedFile();

						if (guarda != null)
							{
								nombre = file.getSelectedFile().getName();
								/*
								 * guardamos el archivo y le damos el formato
								 * directamente, si queremos que se guarde en
								 * formato doc lo definimos como .doc
								 */
								FileWriter save = new FileWriter(guarda + ".txt");
								save.write(info);
								save.close();
								JOptionPane.showMessageDialog(null, "El archivo se a guardado Exitosamente",
										"Informaci�n", JOptionPane.INFORMATION_MESSAGE);
							}
					} catch (IOException ex)
					{
						JOptionPane.showMessageDialog(null, "Su archivo no se ha guardado", "Advertencia",
								JOptionPane.WARNING_MESSAGE);
					}

			}

		public String[] abrirArchivo()
			{

				String[] reStrings =
					{};

				try
					{
						JFileChooser fileChooser = new JFileChooser();
						/* llamamos el metodo que permite cargar la ventana */
						fileChooser.showOpenDialog(fileChooser);
						/* abrimos el archivo seleccionado */
						File abre = fileChooser.getSelectedFile();

						/*
						 * recorremos el archivo, lo leemos para plasmarloen el
						 * area de texto
						 */
						if (abre != null)
							{
								Scanner in = new Scanner(new FileReader(abre));
								while (in.hasNext())
									{
										String line = in.nextLine();
										String arrayline[] = line.split(",");
										reStrings = arrayline;
									}
								in.close();
							}

					} catch (IOException ex)
					{
						JOptionPane.showMessageDialog(null, ex + "" + "\nNo se ha encontrado el archivo",
								"ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
					}
				return reStrings;

			}

	}
