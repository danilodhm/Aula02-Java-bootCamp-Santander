import java.time.OffsetDateTime;

public class Person {
    
    final String name;

    Integer age;

    private int lastYearAgeInc = OffsetDateTime.now().getYear();

    public Person(String name, Integer age){
        this.name = name;
        this.age = 1;
    }
       
    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void incAge(){
        if(this.lastYearAgeInc >= OffsetDateTime.now().getYear()) return;
        this.age += 1;
        this.lastYearAgeInc = OffsetDateTime.now().getYear();

    }

}
