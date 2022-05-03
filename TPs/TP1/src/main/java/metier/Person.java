package metier;

import org.springframework.stereotype.Component;

@Component
public class Person {

    private String name ;
    private int age ;

    // le constructeur :
    public Person(String name, int age) {
        this.name = name ;
        this.age = age ;
    }
    public Person(){}

    // les getters et les setters :
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
