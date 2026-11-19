package padroesestruturais.facade;

import java.util.HashMap;
import java.util.Map;

public class Financeiro {

    private Map<String, Double> salarios = new HashMap<>();

    public void registrarSalario(String nome, double salario) {
        salarios.put(nome, salario);
    }

    public double consultarSalario(String nome) {
        return salarios.getOrDefault(nome, 0.0);
    }
}
