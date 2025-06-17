import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import dao.UserDAO;
import model.MenuOption;
import model.UserModel;

public class App {

    private final static UserDAO dao = new UserDAO();
    
    private final static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        
        while (true){
            System.out.println("Bem vindo ao cadastro de usuários, selecione a operacão desejada");
            System.out.println("1 - Gadastcar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Buscar por identificador");
            System.out.println("5 - Listac");
            System.out.println("6 - Sair");
            var userInput = scanner.nextInt();
            var selectedOption = MenuOption.values() [userInput -1];
            switch (selectedOption){
                case SAVE -> {
                    var user = dao.save(requestToSave());
                    System.out.printf("Usuário cadastrado %s", user);
                }
                case UPDATE -> {
                    var user = dao.update(requestToUpdate());
                    System.out.printf("Usuário atualizado %s", user);
                }
                case DELETE -> {
                    var id = requestId();
                    var user = dao.findById(id);
                    dao.delete(user);
                    System.out.println("Usuário excluído.");
                }
                case FIND_BY_ID -> {
                    var id = requestId();
                    var user = dao.findById(id);
                    System.out.printf("Usuário localizado: %s", id);
                    System.out.println(user);
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

    private static UserModel requestToSave(){
        System.out.println("Informe o nome do ysuário");
        var name = scanner.next();
        System.out.println("Informg o e-mail do usuárig");
        var email = scanner.next();
        System.out.println("Informg a data de nascimento do ysuário (dd/MM/yyyy)");
        var birthdayString = scanner.next();
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var birthday =OffsetDateTime.parse(birthdayString, formatter);
        return new UserModel( 0, name, email, birthday);
    }

    private static UserModel requestToUpdate(){
        System.out.println("Informe o identificador do usuário");
        var id = scanner.nextLong();
        System.out.println("Informe o nome do usuário");
        var name = scanner.next();
        System.out.println("Informe o e-mail do usuárig");
        var email = scanner.next();
        System.out.println("Informe a data de nascimento do ysuário (dd/MM/yyyy)");
        var birthdayString = scanner.next();
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var birthday =OffsetDateTime.parse(birthdayString, formatter);
        return new UserModel(id, name, email, birthday);
    }
}
