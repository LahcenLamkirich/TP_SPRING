package presentation;

import metier.IMetier;
import metier.IMetierImpl;
import metier.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class presentationSpring {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = (Person) context.getBean("Person");
        System.out.println("The age: " + person.getAge());
        System.out.println("The name: " + person.getName());
        System.out.println("*******************");
        IMetier metier = (IMetier) context.getBean("metier");
        System.out.println("La Version dynamique :");
        System.out.println(metier.calcule());

    }
}
