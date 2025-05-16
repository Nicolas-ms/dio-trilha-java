public class ContaPoupanca extends Conta{
    public ContaPoupanca() {
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("Extrato Conta Poupança: ");
        super.imprimirExtrato();

    }
}
