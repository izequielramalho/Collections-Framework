package estudos.Izequiel.collectionsFramework.lists;

import java.util.*;

/**
 * Dados as seguintes informações sobre meus gatos, crie uma lista
 * e ordene esta lista exibindo:
 * (nome - idade - cor);
 * <p>
 * Gato 1 = Jon, idade 18, cor: Preto
 * Gato 2 = Simba, idade 6, cor: Tigrado
 * Gato 3 = Jon, idade 12, cor: Amarelo
 *
 */
public class ExemploList {

    public static void main(String[] args) {

        List<Gato> meusGatos = new ArrayList<>() {{
            add(new Gato("Jon", 18, "Preto"));
            add(new Gato("Simba", 6, "Tigrado"));
            add(new Gato("Jon", 12, "Amarelo"));
        }};

        System.out.println("--\tOrdem Inserção\t---");
        System.out.println(meusGatos);                    //ordem da escrita

        System.out.println("--\tOrdem Aleatória\t---");
        Collections.shuffle(meusGatos);             //desse jeito vai aleatório
        System.out.println(meusGatos);


        System.out.println("--\tOrdem Natural\t---");
        Collections.sort(meusGatos);                  //por comparação de NOMES
        System.out.println(meusGatos);


        System.out.println("--\tOrdem Idade\t---");
        Collections.sort(meusGatos, new ComparatoIdade());
        //       meusGatos.sort(new ComparatoIdade());           //os dois servem para printar por idade
        System.out.println(meusGatos);


        System.out.println("--\tOrdem Cor\t---");
//        Collections.sort(meusGatos, new ComparatorCor());
        meusGatos.sort(new ComparatorCor());
        System.out.println(meusGatos);



       System.out.println("--\tOrdem Nome/Cor/Idade\t---");
       Collections.sort(meusGatos, new ComparatorNomeCorIdade());
       //meusGatos.sort(new COmparatorNomeCorIdade());
        System.out.println(meusGatos);

    }
}

class Gato implements Comparable<Gato> {

    private String nome;
    private Integer idade;
    private String cor;

    public Gato(String nome, int idade, String cor) {
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getCor() {
        return cor;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cor='" + cor + '\'' +
                '}';
    }

    @Override
    public int compareTo(Gato gato) {
        return this.getNome().compareToIgnoreCase(gato.getNome());
    }
}

class ComparatoIdade implements Comparator<Gato> {
    @Override
    public int compare(Gato g1, Gato g2) {
        return Integer.compare(g1.getIdade(), g2.getIdade());
    }
}

class ComparatorCor implements Comparator<Gato> {

    @Override
    public int compare(Gato g1, Gato g2) {
        return g1.getCor().compareToIgnoreCase(g2.getCor());
    }
}

class ComparatorNomeCorIdade implements Comparator<Gato>{

    @Override
    public int compare(Gato g1, Gato g2) {

        int nome = g1.getNome().compareToIgnoreCase(g2.getNome());
        if (nome != 0) return nome;

        int cor = g1.getCor().compareToIgnoreCase(g2.getCor());
        if(cor != 0) return cor;

        return Integer.compare(g1.getIdade(), g2.getIdade());



    }
}