package padroesestruturais.facade;

import java.util.HashSet;
import java.util.Set;

public class Tecnologia {

    private Set<String> acessos = new HashSet<>();

    public void criarAcesso(String nome) {
        acessos.add(nome);
    }

    public boolean possuiAcesso(String nome) {
        return acessos.contains(nome);
    }
}
