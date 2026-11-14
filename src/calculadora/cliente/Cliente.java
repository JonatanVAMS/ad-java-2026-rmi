package calculadora.cliente;

import calculadora.comum.Calculadora;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {
    public static void main(String[] args) {
        try {
            String ipServidor = (args.length > 0) ? args[0] : "localhost";
            System.out.println("Conectando ao servidor em: " + ipServidor);

            Registry registry = LocateRegistry.getRegistry(ipServidor, 1099);
            Calculadora calc = (Calculadora) registry.lookup("ServicoCalculadora");

            System.out.println("Soma (15 + 25): " + calc.somar(15, 25));
            System.out.println("Subtracao (25 - 15): " + calc.subtrair(25, 15));
            System.out.println("Multiplicacao (15 * 25): " + calc.multiplicar(15, 25));
            System.out.println("Divisao (25 / 5): " + calc.dividir(25, 5));

        } catch (Exception e) {
            System.err.println("Erro no cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
