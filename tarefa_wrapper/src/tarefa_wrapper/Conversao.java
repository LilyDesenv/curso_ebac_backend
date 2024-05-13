package tarefa_wrapper;

public class Conversao {

    public static void main(String[] args){
        int numero = 5;
        char letra = 'a';
        double decimal = 1.5;
        boolean condicional = true;

        System.out.println("***Valores primitivos***" +
                "\nint: " + numero +
                "\nchar: " + letra +
                "\ndouble: " + decimal +
                "\nboolean: " + condicional);
        converteValores(numero,letra,decimal,condicional);
    }

    private static void converteValores(int numero, char letra, double decimal, boolean condicional){
        Integer number = numero;
        Character letter = letra;
        Double decima = decimal;
        Boolean conditional = condicional;

        System.out.println("\n***Valores Wrapper***" +
                "\nInteger: " + number +
                "\nCharacter: " + letter +
                "\nDouble: " + decima +
                "\nBoolean: " + conditional);
    }
}
