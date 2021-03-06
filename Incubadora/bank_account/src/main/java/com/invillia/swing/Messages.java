package com.invillia.swing;

import com.invillia.domain.Account;
import com.invillia.domain.Client;

import javax.swing.*;
import java.util.List;

public class Messages {
    public static Integer inputMessage(String message){
        String userAnswer = JOptionPane.showInputDialog(null, message);
        if(userAnswer.equals("")){
            return 0;
        }else{
            return Integer.parseInt(userAnswer);
        }
    }

    public static void showMessage(String message){
        JOptionPane.showMessageDialog(null, message);
    }

    public static void clientListMessage(List<Client> clients){
        StringBuilder stringBuilder = new StringBuilder();
        clients.forEach(client -> stringBuilder
                .append("ID do Cliente: " + client.getId())
                .append(" -- Nome: " + client.getName())
                .append(" -- CPF: " + client.getCpf())
                .append(" -- RG: " + client.getRg())
                .append("\n\n")
        );
        showMessage(stringBuilder.toString());
    }

    public static void accountListMessage(List<Account> accounts){
        StringBuilder stringBuilder = new StringBuilder();
        accounts.forEach(account -> stringBuilder
                .append("ID da Conta: " + account.getId())
                .append(" -- Número da Conta: " + account.getNumber())
                .append(" -- Agência: " + account.getAgency())
                .append(" -- Tipo: Conta " + account.getType())
                .append(" -- Saldo da Conta: R$" + account.getBalance())
                .append(" -- Limite Cheque Especial: R$" + account.getSpecialLimit())
                .append("\n")
                .append("ID do Cliente: " + account.getClient().getId())
                .append(" -- Nome do Cliente: " + account.getClient().getName())
                .append("\n\n")
        );
        showMessage(stringBuilder.toString());
    }

    public static void clientFindByIdMessage(Client client){
        showMessage("ID do Cliente: " + client.getId()
                + " -- Nome: " + client.getName()
                + " -- CPF: " + client.getCpf()
                + " -- RG: " + client.getRg()
        );
    }

    public static void accountFindByIdMessage(Account account){
        showMessage("ID da Conta: " + account.getId()
                + " -- Número da Conta: " + account.getNumber()
                + " -- Agência: " + account.getAgency()
                + " -- Tipo: Conta " + account.getType()
                + " -- Saldo da Conta: R$" + account.getBalance()
                + " -- Limite Cheque Especial: R$" + account.getSpecialLimit()
                + "\n"
                + "ID do Cliente: " + account.getClient().getId()
                + " -- Nome do Cliente: " + account.getClient().getName()
        );
    }

    public static String daoStringInputMessage(String message) {
        return JOptionPane.showInputDialog(null, message);
    }

    public static Long daoLongInputMessage(String message) {
        return Long.parseLong(JOptionPane.showInputDialog(null, message));
    }

    public static Double daoDoubleInputMessage(String message) {
        Double value = Double.parseDouble(JOptionPane.showInputDialog(null, message));
        if(value == null){
            return 0.00;
        }else {
            return value;
        }
    }

    public static int daoInputOption(String message, String title, String[] options){
        return  JOptionPane.showOptionDialog(null, message, title, JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
    }
}
