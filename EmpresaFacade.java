package padroesestruturais.facade;

public class EmpresaFacade {

    private RecursosHumanos recursosHumanos = new RecursosHumanos();
    private Financeiro financeiro = new Financeiro();
    private Tecnologia tecnologia = new Tecnologia();

    public void contratarFuncionario(String nome, double salario) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome inválido");
        }
        if (salario <= 0) {
            throw new IllegalArgumentException("Salário inválido");
        }
        if (recursosHumanos.possuiFuncionario(nome)) {
            throw new IllegalArgumentException("Funcionário já cadastrado");
        }
        recursosHumanos.cadastrarFuncionario(nome);
        financeiro.registrarSalario(nome, salario);
        tecnologia.criarAcesso(nome);
    }

    public boolean verificarContratacao(String nome) {
        return recursosHumanos.possuiFuncionario(nome) && tecnologia.possuiAcesso(nome);
    }

    public double consultarSalario(String nome) {
        return financeiro.consultarSalario(nome);
    }

    public int getTotalFuncionarios() {
        return recursosHumanos.getTotalFuncionarios();
    }
}
