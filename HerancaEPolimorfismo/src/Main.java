
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
                manager.setCommission(5000.0);

                System.out.println("Code: " + manager.getCode());
                System.out.println("Nome: " + manager.getName());
                System.out.println("Login: " + manager.getLogin());
                System.out.println("Senha: " + manager.getPassword());
                System.out.println("Salario: " + manager.getSalary());
                System.out.println("Comissão " + manager.getCommission());
            }
            case Salesman salesman -> {
                salesman.setCode("456");
                salesman.setName("Lucas");
                salesman.setSalary(1800);
                salesman.setPercentComition(10);
                salesman.setSoldAmount(1000);
                
                System.out.println("Code: " + salesman.getCode());
                System.out.println("Nome: " + salesman.getName());
                System.out.println("Salario " + salesman.getSalary());
                System.out.println("Vendas: " + salesman.getSoldAmount());
                System.out.println("Comissão: " + salesman.getPercentComition());
                
            }
        }
        System.out.println("Total Salario: " + employee.getFullSalary());
        System.out.println("Extra + Salario " + employee.getFullSalary(500));
        System.out.println(" ============== ");
    }
}
