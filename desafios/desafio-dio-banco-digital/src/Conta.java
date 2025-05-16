public abstract class Conta implements IConta {

    private static int SEQUENCIAL = 1;
    private static int AGENCIA_PADRAO = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;

    public Conta() {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
    }

    public void imprimirExtrato() {
        System.out.printf("Saldo atual: %.2f\n", this.saldo);
        System.out.printf("Numero : %d\n", this.numero);
        System.out.printf("Agencia : %d\n", this.agencia);
        System.out.println("---------------------------------------");
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

}
