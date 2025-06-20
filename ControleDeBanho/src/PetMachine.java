public class PetMachine {

    private boolean clean = true;

    private int water = 30;
    
    private int shampoo = 10;

    private Pet pet;

    public void takeAShower(){
        
        if(this.pet == null){
            System.out.println("Coloque o pet na máquina de lavar para iniciar o banho.");
            return;
        }
        
        if (this.pet.isClean()) {
            System.out.println("Esse pet já tomou banho e está limpo.");
            return;
        }
        
        if(this.water < 10){
            System.out.println("A máquina não tem água suficiente!");
            return;
        }

        if(this.shampoo < 2){
            System.out.println("A máquina não tem shampoo suficiente!");
            return;
        }

        this.water -= 10;
        this.shampoo -= 2;
        pet.setClean(true);
        System.out.println("O pet " + pet.getName() + " tomou banho e está limpo!");
    }

    public void addWater(){
        if (water == 30){
            System.out.println("A capacidade de ágúa está no maximo!");
            return;
        }

        water += 10;
    }

    public void addShampoo(){
        if (shampoo == 10){
            System.out.println("A capacidade do Shampoo está no maximo!");
            return;
        }

        shampoo += 2;
    }

    public boolean isClean() {
        return clean;
    }

    public int getWater() {
        return water;
    }

    public int getShampoo() {
        return shampoo;
    }

    public boolean hasPet() {
        return pet != null;
    }

    public void setPet(Pet pet){
        if (!this.clean) {
            System.out.println("A máquina está suja, execute a limpeza antes de colocar o PET.");
            return;
        }

        if(hasPet()){
            System.out.println("O pet " + this.pet.getName() + "está na máquina.");
            return;
        }

        this.pet = pet;
    }

    public void removePet(){
        this.clean = this.pet.isClean();
        System.out.println("O pet " + this.pet.getName() + " foi retirado da máquina.");
        this.pet = null;
    }

    public void wash(){
        this.water -= 10;
        this.shampoo -= 2;
        this.clean = true;
        System.out.println("A máquina está limpa.");
    }

    

}

