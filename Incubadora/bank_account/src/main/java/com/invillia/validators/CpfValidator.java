package com.invillia.validators;

import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.CPFValidator;
import com.invillia.swing.Messages;

import java.util.List;

public class CpfValidator {
    public static String validateCpf(String cpf) {
        CPFValidator cpfValidator = new CPFValidator();
        List<ValidationMessage> errors = cpfValidator.invalidMessagesFor(cpf);
        if(errors.size() > 0){
            Messages.showMessage("CPF Incorreto!\nTente novamente ...");
            System.exit(0);
        }
            return cpf;
    }
}
