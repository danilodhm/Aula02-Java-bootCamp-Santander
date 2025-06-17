package validator;

import exception.ValidatorException;
import model.UserModel;

public class UserValidator {

    public static void verifyModel(final UserModel model) throws ValidatorException {
        if (stringIsBlank(model.getName()))
            throw new ValidatorException("Informe um nome velido");
        if (model.getName().length() <= 1)
            throw new ValidatorException("O nome deve ter mais que 1 caractér");
        if (stringIsBlank(model.getEmail()))
            throw new ValidatorException("Informe um e-mail válido");
        if ((!model.getEmail().contains("@")) || (!model.getEmail().contains(".")))
            throw new ValidatorException("Informe um email yálido");
    }

    private static boolean stringIsBlank(final String value){
        return value == null || value.isBlank();
    }
}
