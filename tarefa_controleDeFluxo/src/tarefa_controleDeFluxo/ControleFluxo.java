package tarefa_controleDeFluxo;

import java.util.Scanner;

public class ControleFluxo {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("****Verifique a nota final****");
        System.out.println("Informe a nota do primeiro Bimestre");
        double nota1 = s.nextDouble();
        System.out.println("Informe a nota do segundo Bimestre");
        double nota2 = s.nextDouble();
        System.out.println("Informe a nota do terceiro Bimestre");
        double nota3 = s.nextDouble();
        System.out.println("Informe a nota do quarto Bimestre");
        double nota4 = s.nextDouble();

        double mediaFinal = calculaMedia(nota1, nota2, nota3, nota4);
        resultadoFinal(mediaFinal);

    }

    private static double calculaMedia(double n1, double n2, double n3, double n4){
        double media;
        media = (n1+n2+n3+n4) / 4;
        return media;
    }

    private static void resultadoFinal(double m){
        if(m < 5){
            System.out.println("A média final foi de: " + String.format("%.2f",m) + "\nO(A) Aluno(a) está Reprovado!");
        } else if (m >=5 && m < 7) {
            System.out.println("A média final foi de: " + String.format("%.2f",m) + "\nO(A) Aluno(a) está em Recuperação!");
        } else{
            System.out.println("A média final foi de: " + String.format("%.2f",m) + "\nO(A) Aluno(a) está Aprovado!");
        }
    }
}
