package colecoes_parte1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Colecoes {

    public static void main(String[] args){
        System.out.println("***** Lista de Nomes *******");

        Scanner s = new Scanner(System.in);

        System.out.println("Informe os nomes da lista (Separados por vírgula)");
        String nomes = s.nextLine();


        ordenaEImprimeLista(adicionaArray(nomes));

    }

    private static List<String> adicionaArray(String nomes){
        List<String> listaDeNomes = new ArrayList<String>();
        String[] n = nomes.split(",");
        for (String nome : n){
           listaDeNomes.add(nome);
        }
        return listaDeNomes;
    }

    private static void ordenaEImprimeLista(List<String> lista){
        Collections.sort(lista);
        System.out.println("**** Lista Ordenada ***");
        System.out.println(lista);
    }

}
