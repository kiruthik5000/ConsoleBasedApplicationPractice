package repository;

import model.User;

import java.util.*;

public interface UserRepository {
   public List<User> getUsers();
   public boolean addUser(User user);
   public User getUserById(int id);
}
