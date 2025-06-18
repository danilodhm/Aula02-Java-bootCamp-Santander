public class Main {
    public static void main(String[] args) {
        var male = new Person("João", 12);
        // male.age = 12;
        var female = new Person("Maria", 12);
        // female.age = 10;
        System.out.println("Male name: " + male.getName() + " age: " + male.getAge());
        System.out.println("Female name: " + female.getName() + " age: " + female.getAge());
    }
}
