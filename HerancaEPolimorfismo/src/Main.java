
public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        printEmployee(new Manager());
        printEmployee(new Salesman());
        // printEmployee(new Manager());
    }

    public static void printEmployee(Employee employee){

        System.out.printf(" ======= %s ======= \n", employee.getClass().getCanonicalName());
        switch (employee){
            case Manager manager -> {
                manager.setCode("123");
                manager.setName("João");
                manager.setSalary(5000);
                manager.setLogin("joao");
                manager.setPassword("123456");
                manager.setCommission(1200);

                System.out.println(manager.getCode());
                System.out.println(manager.getSalary());
                System.out.println(manager.getName());
                System.out.println(manager.getLogin());
                System.out.println(manager.getPassword());
                System.out.println(manager.getCommission());
            }
            case Salesman salesman -> {
                salesman.setCode("456");
                salesman.setName("João");
                salesman.setSalary(5000);
                salesman.setPercentComition(10);
                
                System.out.println(salesman.getCode());
                System.out.println(salesman.getSalary());
                System.out.println(salesman.getName());
                System.out.println(salesman.getPercentComition());

            }
        }
        System.out.println(" ============== ");
    }
}
