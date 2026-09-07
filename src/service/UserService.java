package service;

import model.User;
import repository.UserRepository;

import java.util.List;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // getAllUsers
    public List<User> getAllUsers() {
        return userRepository.getUsers();
    }

    public boolean login(String uId, String) {

    }
}
