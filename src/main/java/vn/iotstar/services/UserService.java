package vn.iotstar.services;

import vn.iotstar.entity.Users;

public interface UserService {
    Users login(String username, String password);

    Users get(String username);

    void insert(Users user);

    boolean register(String email, String password, String username, String
            fullname, String phone);

    boolean checkExistEmail(String email);

    boolean checkExistUsername(String username);

    boolean checkExistPhone(String phone);

    Users getUserByEmail(String email);

    boolean updatePasswordByEmail(String email, String newPassword);
}
