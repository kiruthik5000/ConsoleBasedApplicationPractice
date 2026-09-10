package dto.mapper;

import dto.request.UserRequest;
import model.User;

public class UserMapper {
    public static User toEntity(UserRequest userRequest) {
        return new User(
                userRequest.getUserName(),
                0,
                userRequest.getDesignation(),
                0.0,
                null
        );
    }
}
