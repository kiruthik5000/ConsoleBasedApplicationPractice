package repository.impl;

import model.Designation;
import model.User;
import repository.UserRepository;

import java.util.*;

public class UserRepositoryImpl implements UserRepository {
    private int nextUid = 103;
    Map<Integer, User> userMap;

    public UserRepositoryImpl() {
        userMap = new LinkedHashMap<>();
        userMap.put(101, new User("kiruthik", 101,"pass",100.00, Designation.FACULTY));
        userMap.put(102, new User("Nadish", 102, "pass",0.00, Designation.STUDENT));
    }

    @Override
    public List<User> getUsers() {
        return new ArrayList<>(userMap.values());
    }

    @Override
    public boolean addUser(User user) {
        user.setUId(nextUid);
        userMap.put(user.getUId(), user);
        nextUid++;
        return true;
    }

    @Override
    public User getUserById(int id) {
        if (!userMap.containsKey(id)) throw new IllegalArgumentException("Invalid Id provided User does not found");
        return userMap.get(id);
    }
}
