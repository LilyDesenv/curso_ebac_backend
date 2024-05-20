package br.com.lyly;

import br.com.lyly.dao.ClienteMapDAO;
import br.com.lyly.dao.IClienteDAO;
import br.com.lyly.model.Cliente;

import javax.swing.*;

public class App {

    private static  IClienteDAO clienteDAO;
    public static void main(String[] args) {
        clienteDAO = new ClienteMapDAO();
        String telaOpcoes = JOptionPane.showInputDialog(null,
                "********Digite uma das opções abaixo*******" +
                        "\n1 - Cadastro" +
                        "\n2 - Consultar" +
                        "\n3 - Excluir" +
                        "\n4 - Alterar" +
                        "\n5 - Sair",
                "Cadastro",
                JOptionPane.INFORMATION_MESSAGE);

        while(!isOpcaoValida(telaOpcoes)){
            JOptionPane.showMessageDialog(null, "Opção inválida!!","Erro",JOptionPane.INFORMATION_MESSAGE);
            if(telaOpcoes.equals("")){
                sair();
            }
            telaOpcoes = JOptionPane.showInputDialog(null,
                    "********Digite uma das opções abaixo*******" +
                            "\n1 - Cadastro" +
                            "\n2 - Consultar" +
                            "\n3 - Excluir" +
                            "\n4 - Alterar" +
                            "\n5 - Sair",
                    "Cadastro",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        while(isOpcaoValida(telaOpcoes)){
            if(telaOpcoes.equals("1")){
                String dados = JOptionPane.showInputDialog(null,
                        "Digite os dados do Cliente separados por vírgula" +
                                "\nEx: Nome,CPF,Telefone,Endereço,Número,Cidade,Estado",
                        "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                cadastrar(dados);

            }else if(telaOpcoes.equals("2")){
                String dados = JOptionPane.showInputDialog(null,
                        "Digite o CPF do Cliente (somente números)",
                        "Consultar", JOptionPane.INFORMATION_MESSAGE);
                consultar(dados);

            }else if(telaOpcoes.equals("3")){
                String dados = JOptionPane.showInputDialog(null,
                        "Digite o CPF do Cliente (somente números)",
                        "Excluir", JOptionPane.INFORMATION_MESSAGE);
                excluir(dados);

            }else if(telaOpcoes.equals("4")){
                String dados = JOptionPane.showInputDialog(null,
                        "Digite os dados do Cliente separados por vírgula" +
                                "\nEx: Nome,CPF,Telefone,Endereço,Número,Cidade,Estado",
                        "Editar", JOptionPane.INFORMATION_MESSAGE);
                alterar(dados);

            }else if(telaOpcoes.equals("5")){
                sair();
            }

            telaOpcoes = JOptionPane.showInputDialog(null,
                    "********Digite uma das opções abaixo*******" +
                            "\n1 - Cadastro" +
                            "\n2 - Consultar" +
                            "\n3 - Excluir" +
                            "\n4 - Alterar" +
                            "\n5 - Sair",
                    "Cadastro",
                    JOptionPane.INFORMATION_MESSAGE);
        }

    }




    public static Boolean isOpcaoValida(String opcao){
        return opcao.equals("1") || opcao.equals("2") || opcao.equals("3") ||
                opcao.equals("4") || opcao.equals("5");
    }

    public static void sair(){
        JOptionPane.showMessageDialog(null, "Até logo!","Saindo",JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    public static void cadastrar(String dados){
        String[] dadosSeparados = dados.split(",");
        if(dadosSeparados.length < 7
        || !isNumerico(dadosSeparados[1])
        || !isNumerico(dadosSeparados[2])
        || !isNumerico(dadosSeparados[4])){
            JOptionPane.showMessageDialog(null, "Por favor informe todos os dados corretamente!","Erro",JOptionPane.ERROR_MESSAGE);
        }else{
        Cliente cliente = new Cliente(
                dadosSeparados[0],
                dadosSeparados[1],
                dadosSeparados[2],
                dadosSeparados[3],
                dadosSeparados[4],
                dadosSeparados[5],
                dadosSeparados[6]
        );
            Boolean isCadastrado = clienteDAO.cadastrar(cliente);
            if(isCadastrado){
                JOptionPane.showMessageDialog(null, "Cliente Cadastrado com Sucesso!","Sucesso",JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Cliente Já está Cadastrado!","Atenção",JOptionPane.WARNING_MESSAGE);
            }
        }
    }


    private static void consultar(String dados) {
        if(isNumerico(dados)){
            Cliente consultar = clienteDAO.consultar(Long.parseLong(dados));
            if(consultar != null){
                JOptionPane.showMessageDialog(null,""+consultar.toString(),"Consulta",JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null,"Cliente não Encontrado!!","Consulta",JOptionPane.INFORMATION_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Por favor o CPF corretamente! (somente números)","Erro",JOptionPane.ERROR_MESSAGE);

        }
    }

    private static void alterar(String dados) {
        String[] dadosSeparados = dados.split(",");
        if(dadosSeparados.length < 7
                || !isNumerico(dadosSeparados[1])
                || !isNumerico(dadosSeparados[2])
                || !isNumerico(dadosSeparados[4])){
            JOptionPane.showMessageDialog(null, "Por favor informe todos os dados corretamente!","Erro",JOptionPane.ERROR_MESSAGE);
        }else{
            Cliente cliente = new Cliente(
                    dadosSeparados[0],
                    dadosSeparados[1],
                    dadosSeparados[2],
                    dadosSeparados[3],
                    dadosSeparados[4],
                    dadosSeparados[5],
                    dadosSeparados[6]
            );
            clienteDAO.alterar(cliente);
            JOptionPane.showMessageDialog(null, "Cliente Alterado com Sucesso!","Sucesso",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void excluir(String dados) {
        if(isNumerico(dados)){
            clienteDAO.excluir(Long.parseLong(dados));
            JOptionPane.showMessageDialog(null, "Cliente Excluído com Sucesso!","Sucesso",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Por favor o CPF corretamente! (somente números)","Erro",JOptionPane.ERROR_MESSAGE);
        }
    }

    private static boolean isNumerico(String str){
        return str != null && str.matches("[0-9]+");
    }
}
