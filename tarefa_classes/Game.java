package tarefa_classes;

public class Game { 

    /* Declaração das variáveis */
    private int codigo;
    private String nome;
    private String plataforma;
    private String tipo;
    private String distribuidora;
    private double valor;


    /* Getters e Setters */
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDistribuidora() {
        return distribuidora;
    }

    public void setDistribuidora(String distribuidora) {
        this.distribuidora = distribuidora;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    /* Métodos */
    public void aplicaDesconto(int descontoPorcentagem, double valor){
        double descontoDecimal = descontoPorcentagem / 100;
        double desconto = valor * descontoDecimal;
        double valorFinal = valor - desconto;
        setValor(valorFinal);
    }
}
