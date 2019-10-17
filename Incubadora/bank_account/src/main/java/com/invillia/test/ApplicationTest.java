//package com.invillia.test;
//
//import com.invillia.dao.*;
//import com.invillia.menu.Menus;
//import com.invillia.swing.Messages;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//public class ApplicationTest {
//    public static void main(String[] args) {
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bank");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//
//        ClientDAO clientDAO = new ClientDAO(entityManager);
//        AccountDAO accountDAO = new AccountDAO(entityManager);
//        Integer chosenOption;
//
//        System.out.println("---------------------DAQUI PRA BAIXO É TUDO ERRO KKK---------------------");
//
//        Messages.showMessage("Bem-vindo ao sistema bancário XURUPITA!");
//
//        do{
//            chosenOption = Messages.inputMessage(
//                    "Menu Principal:\n\n1 - Clientes\n2 - Contas\n3 - Operações\n4 - Sair");
//
//            switch (chosenOption){
//                case 1:
//                    Menus.clientMenu(clientDAO);
//                    break;
//                case 2:
//                    Menus.accountMenu(accountDAO, clientDAO);
//                    break;
//                case 3:
//                    Menus.operationMenu(accountDAO, clientDAO);
//                    break;
//                case 4:
//                    Messages.showMessage("Saindo do sistema ...");
//                    break;
//                default:
//                    Messages.showMessage("Digite alguma das opções apresentadas!");
//                    break;
//            }
//        }while(chosenOption != 4);
//
//        System.exit(0);
//    }
//}
//
