package tarefa_calculo_media;

public class Media {

    public static void main(String[] args){
        double nota1 = 5.7;
        double nota2 = 8.3;
        double nota3 = 9.4;
        double nota4 = 6.6;

        double resultado = calculaMedia(nota1,nota2,nota3,nota4);

        System.out.println("A média final foi de: "+resultado);

    }

    private static double calculaMedia(double n1,double n2,double n3,double n4){
        double media = (n1+n2+n3+n4)/4;
        return  media;
    }

}
