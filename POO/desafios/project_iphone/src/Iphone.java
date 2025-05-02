

public class Iphone implements ReprodutorMusical, AparelhoTelefonico, NavegadorInternet {
    public void tocar() {
        System.out.println("Tocando música...");
    }
    public void pausar() {
        System.out.println("Música pausada.");
    }
    public void selecionarMusica(String musica) {
        System.out.println("Selecionando música: " + musica);
    }
    public void ligar() {
        System.out.println("Ligando...");
    }
    public void atender() {
        System.out.println("Atendendo chamada...");
    }
    public void iniciarCorreioVoz() {
        System.out.println("Iniciando correio de voz...");
    }
    public void exibirPagina(String url) {
        System.out.println("Exibindo página: " + url);
    }
    public void adicionarNovaAba() {
        System.out.println("Adicionando nova aba...");
    }
    public void atualizarPagina() {
        System.out.println("Atualizando página...");
    }

}