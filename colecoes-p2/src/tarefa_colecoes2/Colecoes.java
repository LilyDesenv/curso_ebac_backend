package tarefa_colecoes2;

import java.util.*;

public class Colecoes {

    public static void main(String[] args){

        System.out.println("***** Lista de Nomes ****");

        Scanner s = new Scanner(System.in);

        System.out.println("Informe o nome e o sexo das Pessoas separados por traço '-' e cada uma serpadado por vígula \nEx: Fulano-M,Fulana-F");
        String nomes = s.nextLine();

        List<String> listaNomesSeparada = separaNomes(nomes);
        List<String> listaMasculino = criaListaPorGenero("M",listaNomesSeparada);
        List<String> listaFeminino = criaListaPorGenero("F",listaNomesSeparada);

        System.out.println("\n***** Masculino *****");
        listaMasculino.stream().forEach(System.out::println);
        System.out.println("\n***** Feminino *****");
        listaFeminino.stream().forEach(System.out::println);


    }
    //método que pega toda a string lida do console e separa em um array verificando pela vírgula
    private static List<String> separaNomes(String nomes){
        List<String> listaDeNomes = new ArrayList<String>();
        String[] arrayNomes = nomes.split(",");
        for (String n : arrayNomes){
            listaDeNomes.add(n);
        }
        return listaDeNomes;
    }

    //método que varre a lista anterior e separa cada registro pelo traço e verifica se a segunda informação
    //do novo array é igual ao genero passado para colocar o nome na lista de retorno
    private static List<String> criaListaPorGenero(String genero, List<String> nomes){
        List<String> nomesPorGenero = new ArrayList<String>();
        for(String n : nomes) {
            String[] nomesArray = n.split("-");
            if (nomesArray[1].equalsIgnoreCase(genero)) {
                nomesPorGenero.add(nomesArray[0]);
            }
        }
        return nomesPorGenero;
    }

}
