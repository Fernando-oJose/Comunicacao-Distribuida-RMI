/* COM242 - SISTEMAS DISTRIBUIDOS 
   Atividade 3 
   Fernando José Ferreira Neto - 2018001665.
   01/06/2021
*/

import java.rmi.*;

// Definição da interface que descreve os objetos remotos que poderao ser acessados pelo cliente
public interface InterfaceServidorMat extends Remote
{
    public double delta(double a, double b, double c) throws RemoteException;
    public double[] calcula_equacao(double a, double b, double c) throws RemoteException;
    
}