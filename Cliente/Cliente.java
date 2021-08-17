/* COM242 - SISTEMAS DISTRIBUIDOS 
   Atividade 3 
   Fernando José Ferreira Neto - 2018001665.
   01/06/2021
*/

import java.rmi.*;
import java.util.Scanner;

public class Cliente
{
	public Cliente()
	{
		System.out.println("Executando Cliente... \n");
		try
		{   // Acessa o servidor de nomes para localização das funções remotas
			msi = (InterfaceServidorMat) Naming.lookup("rmi://192.168.1.5/ServidorMat_1");
      
		}
		catch (Exception e)
		{
			System.out.println("Falhou a execucao do Cliente.\n"+e);				
			System.out.println("Certifique se a aplicacao no servidor esta em execucao.\n");				
			System.exit(0);
		}
	}
	
	public static void main (String[] argv)
	{
		Cliente c = new Cliente();
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Entre com os coeficientes a, b e c separados por espaco:");
		double x = keyboard.nextDouble();
		double y = keyboard.nextDouble();
    double z = keyboard.nextDouble();
		System.out.println("");
		
		try
		{   // Cada chamada de uma função remota é uma instância da classe Cliente
      double resultados[] = c.calcula_equacao(x, y, z);
      System.out.println("X1 = "+ resultados[0]);
      System.out.println("X2 = "+ resultados[1]);

		}
		catch (Exception e)
		{
			System.out.println("Excepção durante chamadas remotas:" +e);
		}
	}

	private InterfaceServidorMat msi; // A interface para o objecto remoto
	
	
	// Chamada as funções remotas para realização das operações matemáticas
	public double[] calcula_equacao(double a, double b, double c) throws RemoteException{
		 return msi.calcula_equacao(a, b, c);
	}
	
}