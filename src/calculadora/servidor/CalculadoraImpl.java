package calculadora.servidor;

import calculadora.comum.Calculadora;
import java.rmi.RemoteException;
import java.rmi.server.RemoteServer;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;

public class CalculadoraImpl extends UnicastRemoteObject implements Calculadora {

    public CalculadoraImpl() throws RemoteException {
        super(1099);
    }

    private String obterHostCliente() {
        try {
            return RemoteServer.getClientHost();
        } catch (ServerNotActiveException e) {
            return "Local";
        }
    }

    @Override
    public int somar(int a, int b) throws RemoteException {
        System.out.println("[" + obterHostCliente() + "] Pedido de soma recebido: " + a + " + " + b);
        return a + b;
    }

    @Override
    public int subtrair(int a, int b) throws RemoteException {
        System.out.println("[" + obterHostCliente() + "] Pedido de subtracao recebido: " + a + " - " + b);
        return a - b;
    }

    @Override
    public int multiplicar(int a, int b) throws RemoteException {
        System.out.println("[" + obterHostCliente() + "] Pedido de multiplicacao recebido: " + a + " * " + b);
        return a * b;
    }

    @Override
    public double dividir(int a, int b) throws RemoteException {
        System.out.println("[" + obterHostCliente() + "] Pedido de divisao recebido: " + a + " / " + b);
        if (b == 0) {
            throw new RemoteException("Divisao por zero nao permitida!");
        }
        return (double) a / b;
    }
}
