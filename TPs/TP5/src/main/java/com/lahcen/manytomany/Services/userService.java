package com.lahcen.manytomany.Services;

import com.lahcen.manytomany.Entities.User;

public interface userService {
    void saveUser(User user);
    void addUserToGroupe(String username, String groupeName);
}
