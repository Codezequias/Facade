package padroesestruturais.facade;

import java.util.ArrayList;
import java.util.List;

public class RecursosHumanos {

    private List<String> funcionarios = new ArrayList<>();

    public void cadastrarFuncionario(String nome) {
        funcionarios.add(nome);
    }

    public boolean possuiFuncionario(String nome) {
        return funcionarios.contains(nome);
    }

    public int getTotalFuncionarios() {
        return funcionarios.size();
    }
}
