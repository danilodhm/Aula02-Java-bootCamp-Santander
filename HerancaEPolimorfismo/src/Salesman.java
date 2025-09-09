public non-sealed class Salesman extends Employee{

    private double percentComition;

    private double soldAmount;

    public Salesman(String name, String code, String address, int age, double salary, double percentComition,
                    double soldAmount) {
        super(name, code, address, age, salary);
        this.percentComition = percentComition;
        this.soldAmount = soldAmount;
    }
    
    public Salesman() {
    }

    @Override
    public String getCode(){
        return "SL_" + super.getCode();
    }
    
    public double getPercentComition() {
        return percentComition;
    }

    public void setPercentComition(double percentComition) {
        this.percentComition = percentComition;
    }

    public double getSoldAmount() {
        return soldAmount;
    }

    public void setSoldAmount(double soldAmount) {
        this.soldAmount = soldAmount;
    }

    @Override
    public double getFullSalary() {
        return this.salary + getFullSalary() + ((soldAmount * percentComition) / 100);
    }

    
}
