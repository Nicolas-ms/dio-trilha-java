package list.Ordenacao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Pessoa implements Comparable<Pessoa>
{
    //atributos

    private String nome;
    private int idade;
    private double altura;

    public Pessoa(String nome, int idade, double altura) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public double getAltura() {
        return altura;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", altura=" + altura +
                '}';
    }
    public int compareTo(Pessoa pessoa){
        return Integer.compare(idade, pessoa.getIdade());
    }
    static class ComparatorPorAltura implements Comparator<Pessoa>{
        @Override
        public int compare(Pessoa o1, Pessoa o2){
            return 0;
        }
    }
}
