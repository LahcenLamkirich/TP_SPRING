package com.lahcen.manytomany.Services;

import com.lahcen.manytomany.Entities.Groupe;
import com.lahcen.manytomany.Entities.User;
import com.lahcen.manytomany.Repositories.GroupeRepository;
import com.lahcen.manytomany.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class userServiceImp implements userService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    GroupeRepository groupeRepository;

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void addUserToGroupe(String username, String groupeName) {
        User user = userRepository.findByUsername(username);
        Groupe groupe = groupeRepository.findByGroupeName(groupeName);

        groupe.getUsers().add(user);

    }

}
