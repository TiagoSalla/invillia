package com.invillia.menu;

import com.invillia.dao.*;
import com.invillia.domain.*;
import com.invillia.swing.Messages;
import com.invillia.validators.CpfValidator;

public class Menus {
    public static void clientMenu(ClientDAO clientDAO){
        Integer menuChosenOption;
        do {
            menuChosenOption = Messages.inputMessage("Menu de Clientes:\n\n1 - Inserir\n2 - Listar\n" +
                    "3 - Pesquisar\n4 - Editar\n5 - Excluir\n6 - Retornar ao Menu Principal");
            switch (menuChosenOption){
                case 1:
                    clientDAO.insert(new Client(
                        Messages.daoStringInputMessage("Insira o nome do cliente:"),
                        CpfValidator.validateCpf(Messages.daoStringInputMessage("Insira o CPF do cliente:")),
                        Messages.daoStringInputMessage("Insira o RG do cliente:")));
                        Messages.showMessage("Cliente inserido com sucesso!");
                    break;
                case 2:
                    clientDAO.listAll();
                    break;
                case 3:
                    clientDAO.listById(Messages.daoLongInputMessage("Qual o ID do cliente?"));
                    break;
                case 4:
                    clientDAO.update(Messages.daoLongInputMessage("Qual o ID do cliente?"));
                    Messages.showMessage("Cliente alterado com sucesso!");
                    break;
                case 5:
                    clientDAO.deleteById(Messages.daoLongInputMessage("Digite o ID desejado:"));
                    Messages.showMessage("Cliente excluido com sucesso!");
                    break;
                case 6:
                    Messages.showMessage("Retornando ao Menu Principal ...");
                    break;
                default:
                    Messages.showMessage("Digite alguma das opções apresentadas!");
                    break;
            }
        }while (menuChosenOption != 6) ;
    }

    public static void accountMenu(AccountDAO accountDAO, ClientDAO clientDAO){
        Integer menuChosenOption;
        do {
            menuChosenOption = Messages.inputMessage("Menu de Contas:\n\n1 - Inserir\n2 - Listar\n" +
                    "3 - Pesquisar\n4 - Excluir\n5 - Retornar ao Menu Principal");
            switch (menuChosenOption){
                case 1:
                    String[] options = {"Corrente", "Poupança"};
                    accountDAO.insert(new Account(
                            Messages.daoLongInputMessage("Insira o número da conta:"),
                            Messages.daoLongInputMessage("Insira a agência da conta:"),
                            options[Messages.daoInputOption("Escolha o tipo da Conta:",
                                    "Escolha de Tipo de Conta", options)],
                            Messages.daoDoubleInputMessage("Essa conta possui saldo inicial? Se sim, digite-o."),
                            Messages.daoDoubleInputMessage(
                                    "Essa conta possui limite de cheque especial? Se sim, digite-o"),
                            clientDAO.findById(Messages.daoLongInputMessage(
                                    "Insira o ID do cliente a ser vinculado a essa conta:"))));
                    Messages.showMessage("Conta inserida com sucesso!");
                    break;
                case 2:
                    accountDAO.listAll();
                    break;
                case 3:
                    accountDAO.listById(Messages.daoLongInputMessage("Digite o ID desejado:"));
                    break;
                case 4:
                    accountDAO.deleteById(Messages.daoLongInputMessage("Digite o ID desejado:"));
                    Messages.showMessage("Conta excluida com sucesso!");
                    break;
                case 5:
                    Messages.showMessage("Retornando ao Menu Principal ...");
                    break;
                default:
                    Messages.showMessage("Digite alguma das opções apresentadas!");
                    break;
            }
        }while (menuChosenOption != 5) ;
    }

    public static void operationMenu(AccountDAO accountDAO, ClientDAO clientDAO){
        Integer menuChosenOption;
        do {
            menuChosenOption = Messages.inputMessage("Menu de Operações:\n\n1 - Depositar\n2 - Sacar\n" +
                    "3 - Verificar Saldo\n4 - Verificar Limite do Cheque Especial\n" +
                    "5 - Retornar ao Menu Principal");
            switch (menuChosenOption){
                case 1:
                    accountDAO.deposit(Messages.daoLongInputMessage("Qual é o ID da conta que deseja depositar?"));
                    break;
                case 2:
                    accountDAO.withdraw(Messages.daoLongInputMessage("Qual é o ID da conta que deseja sacar?"));
                    break;
                case 3:
                    accountDAO.verifyBalance(Messages.daoLongInputMessage("Qual é o ID da conta?"));
                    break;
                case 4:
                    accountDAO.verifySpecialLimit(Messages.daoLongInputMessage("Qual é o ID da conta?"));
                    break;
                case 5:
                    Messages.showMessage("Retornando ao Menu Principal ...");
                    break;
                default:
                    Messages.showMessage("Digite alguma das opções apresentadas!");
                    break;
            }
        }while (menuChosenOption != 5) ;
    }


}
