package padroesestruturais.facade;

public class CasosDeTeste {

    public static void main(String[] args) {
        testarContratacao();
        testarSalario();
        testarMultiplasContratacoes();
        testarNomeInvalido();
        testarSalarioInvalido();
        testarFuncionarioDuplicado();
        System.out.println("Todos os 6 testes passaram.");
    }

    public static void testarContratacao() {
        EmpresaFacade empresa = new EmpresaFacade();
        empresa.contratarFuncionario("Ana", 3500.0);
        verificar(empresa.verificarContratacao("Ana"), "Contratação não concluída");
        verificar(!empresa.verificarContratacao("Carlos"), "Funcionário inexistente");
    }

    public static void testarSalario() {
        EmpresaFacade empresa = new EmpresaFacade();
        empresa.contratarFuncionario("Bruno", 4200.0);
        verificar(empresa.consultarSalario("Bruno") == 4200.0, "Salário incorreto");
    }

    public static void testarMultiplasContratacoes() {
        EmpresaFacade empresa = new EmpresaFacade();
        empresa.contratarFuncionario("Ana", 3500.0);
        empresa.contratarFuncionario("Bruno", 4200.0);
        verificar(empresa.getTotalFuncionarios() == 2, "Total de funcionários incorreto");
    }

    public static void testarNomeInvalido() {
        EmpresaFacade empresa = new EmpresaFacade();
        verificarErro(() -> empresa.contratarFuncionario(" ", 3000.0));
        verificar(empresa.getTotalFuncionarios() == 0, "Cadastro inválido realizado");
    }

    public static void testarSalarioInvalido() {
        EmpresaFacade empresa = new EmpresaFacade();
        verificarErro(() -> empresa.contratarFuncionario("Ana", -100.0));
        verificar(empresa.getTotalFuncionarios() == 0, "Cadastro inválido realizado");
    }

    public static void testarFuncionarioDuplicado() {
        EmpresaFacade empresa = new EmpresaFacade();
        empresa.contratarFuncionario("Ana", 3500.0);
        verificarErro(() -> empresa.contratarFuncionario("Ana", 5000.0));
        verificar(empresa.getTotalFuncionarios() == 1, "Funcionário duplicado");
        verificar(empresa.consultarSalario("Ana") == 3500.0, "Salário original alterado");
    }

    private static void verificar(boolean condicao, String mensagem) {
        if (!condicao) {
            throw new AssertionError(mensagem);
        }
    }

    private static void verificarErro(Runnable acao) {
        try {
            acao.run();
        } catch (IllegalArgumentException e) {
            return;
        }
        throw new AssertionError("Era esperado um erro de validação");
    }
}
