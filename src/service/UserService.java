package service;

import dto.mapper.UserMapper;
import dto.request.UserRequest;
import model.Designation;
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

    public boolean login(int uId, String password) throws Exception {
        User usr = userRepository.getUserById(uId);
        if (!usr.getPassword().equals(password)) throw new Exception("UserId or Password Incorrect");
        return true;
    }

    public User signIn(UserRequest user) throws Exception{
        if (!validateUser(user)) throw new Exception("Invalid User Details Provided");
        User userEntity = UserMapper.toEntity(user);
        try {
            System.out.println(user.getDesignation());
            userEntity.setDesignation(Designation.valueOf(user.getDesignation()));
        } catch (Exception e) {
            throw new Exception("Invalid Designation Specified.");
        }
        userEntity.setPendingAmt(0.0);
        userRepository.addUser(userEntity);
        return userEntity;
    }

    private boolean validateUser(UserRequest user) {
        if (user.getUserName() == null || user.getUserName().isEmpty()) return false;
        if (user.getPassword() == null || user.getPassword().isEmpty()) return false;
        if (user.getDesignation() == null || user.getDesignation().isEmpty()) {
            user.setDesignation("GUEST");
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Designation.valueOf("Guest"));
    }
}
