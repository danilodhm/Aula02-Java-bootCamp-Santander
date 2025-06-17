import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import dao.UserDAO;
import exception.EmptyStorageException;
import exception.UserNotFoundException;
import exception.ValidatorException;
import model.MenuOption;
import model.UserModel;
import validator.UserValidator;

public class App {

    private final static UserDAO dao = new UserDAO();
    
    private final static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws ValidatorException {
        
        while (true){
            System.out.println("Bem vindo ao cadastro de usuários, selecione a operacão desejada");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Buscar por identificador");
            System.out.println("5 - Listar");
            System.out.println("6 - Sair");
            var userInput = scanner.nextInt();
            var selectedOption = MenuOption.values() [userInput -1];
            switch (selectedOption){
                case SAVE -> {
                    var user = dao.save(requestToSave());
                    System.out.printf("Usuário cadastrado %s", user);
                }
                case UPDATE -> {
                    try{
                        var user = dao.update(requestToUpdate());
                        System.out.printf("Usuário atualizado %s", user);
                    } catch (UserNotFoundException | EmptyStorageException ex){
                        System.out.println(ex.getMessage());
                    }
                }
                case DELETE -> {
                    try {
                        var id = requestId();
                        var user = dao.findById(id);
                        dao.delete(user);
                        System.out.println("Usuário excluído.");
                    } catch (UserNotFoundException | EmptyStorageException ex){
                        System.out.println(ex.getMessage());
                    }
                }
                case FIND_BY_ID -> {
                    try{
                        var id = requestId();
                        var user = dao.findById(id);
                        System.out.printf("Usuário localizado: %s", id);
                        System.out.println(user);
                    }catch (UserNotFoundException | EmptyStorageException ex){
                        System.out.println(ex.getMessage());
                    }
                }
                case FIND_ALL -> {
                    var users = dao.findAll();
                    System.out.println("Usuários cadastrados localizado: ");
                    System.out.println("============================");
                    users.forEach(System.out::println);
                    System.out.println("============================");
                    
                }
                case EXIT -> System.exit(0);
            }
        }
    }


    private static long requestId(){
        System.out.println("Informe o identificador do usuário");
        return scanner.nextLong();
    }

    private static UserModel requestToSave() throws ValidatorException{
        System.out.println("Informe o nome do ysuário");
        var name = scanner.next();
        System.out.println("Informg o e-mail do usuárig");
        var email = scanner.next();
        System.out.println("Informg a data de nascimento do ysuário (dd/MM/yyyy)");
        var birthdayString = scanner.next();
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var birthday =LocalDate.parse(birthdayString, formatter);
        return validateInputs(0, name, email, birthday);
    }

    private static UserModel validateInputs(final long id, final String name,
            final String email, final LocalDate birthday) throws ValidatorException {
        var user = new UserModel(  0, name, email, birthday);
        UserValidator.verifyModel(user);
        return user;
    }



    private static UserModel requestToUpdate() throws ValidatorException{
        System.out.println("Informe o identificador do usuário");
        var id = scanner.nextLong();
        System.out.println("Informe o nome do usuário");
        var name = scanner.next();
        System.out.println("Informe o e-mail do usuárig");
        var email = scanner.next();
        System.out.println("Informe a data de nascimento do ysuário (dd/MM/yyyy)");
        var birthdayString = scanner.next();
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var birthday = LocalDate.parse(birthdayString, formatter);
        return validateInputs(0, name, email, birthday);
    }
}
