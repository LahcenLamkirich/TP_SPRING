package com.lahcen.manytomany;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lahcen.manytomany.Entities.Groupe;
import com.lahcen.manytomany.Entities.InheritanceTest.Enseignant;
import com.lahcen.manytomany.Entities.InheritanceTest.Etudiant;
import com.lahcen.manytomany.Entities.InheritanceTest.Person;
import com.lahcen.manytomany.Entities.InheritanceTest.personRepository;
import com.lahcen.manytomany.Entities.User;
import com.lahcen.manytomany.Repositories.GroupeRepository;
import com.lahcen.manytomany.Repositories.UserRepository;
import com.lahcen.manytomany.Services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.rmi.runtime.Log;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("users")

public class ManyTomanyApplication {

    @Autowired
    private userService userservice ;
    @Autowired
    GroupeRepository groupeRepository ;
    @Autowired
    UserRepository userRepository ;
    @Autowired
    personRepository personRepo ;

    public static void main(String[] args) {
        SpringApplication.run(ManyTomanyApplication.class, args);
    }

    @Bean
    CommandLineRunner start(){
        return args -> {

            userservice.saveUser(new User(null, "Lahcen", "123", null));
            userservice.saveUser(new User(null, "Atika", "456", null));
            groupeRepository.save(new Groupe(null, "Informatique", null));
            groupeRepository.save(new Groupe(null, "Industriel", null));


            userservice.addUserToGroupe("Lahcen", "Informatique");
            userservice.addUserToGroupe("Atika", "Informatique");

            List<User> users = userRepository.findAllUsers();
            users.forEach(user -> System.out.println(user));

            // Test Inheritance :
            /* add new Student */
            Etudiant etu = new Etudiant();
            etu.setName("Lahcen");
            etu.setAge(21);
            etu.setNote(18);
            personRepo.save(etu);
            /* add new Prof */
            Enseignant prof = new Enseignant();
            prof.setName("Youssfi");
            prof.setAge(35);
            prof.setMatiere("Spring Boot");
            personRepo.save(prof);

        };
    }


}
