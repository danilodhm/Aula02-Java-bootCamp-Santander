
public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        printEmployee(new Manager());
        printEmployee(new Salesman());
        // printEmployee(new Manager());
    }

    public static void printEmployee(Employee employee){

        System.out.printf(" ======= %s ======= \n", employee.getClass().getCanonicalName());
        if (employee instanceof Manager manager) {
            employee.setName("Joao");
            manager.setLogin("joao");
            manager.setPassword("123456");

            System.out.println(employee.getName());
            System.out.println(manager.getLogin());
            System.out.println(manager.getPassword());

        }
        System.out.println(" ============== ");

    }
}
