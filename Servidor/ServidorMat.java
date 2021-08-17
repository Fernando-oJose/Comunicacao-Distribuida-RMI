/* COM242 - SISTEMAS DISTRIBUIDOS 
   Atividade 3 
   Fernando José Ferreira Neto - 2018001665.
   01/06/2021
*/

import java.rmi.*;
import java.rmi.server.*;
import java.lang.Math;

// Classe no servidor que implementa os métodos remotos
public class ServidorMat extends UnicastRemoteObject implements InterfaceServidorMat
{
    public ServidorMat() throws RemoteException
    {
        System.out.println("Novo Servidor instanciado...");
    }
	
    public double delta(double a, double b, double c) throws RemoteException
    {
        System.out.println("Valores recebidos do cliente: a = " + a + ", b = " + b + " e c =" + c);

        double passo1 = b*b;
        double passo2 = 4*a*c;

        double res_delta = passo1-passo2;

		return res_delta;
    }
	
    public double[] calcula_equacao(double a, double b,double c) throws RemoteException
    {
        double raizes[] = new double[2];

        System.out.println("Valores recebidos do cliente: a = " + a + "  b = " + b + "  c =  "+ c);

        double var_delta = delta(a, b, c);
        
        raizes[0] = (-b -(Math.sqrt(var_delta))) /(2 * a);
        raizes[1] = (-b +(Math.sqrt(var_delta))) / (2 * a);
		return raizes;
    }
    
} 