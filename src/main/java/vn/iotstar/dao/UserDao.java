package vn.iotstar.dao;

import vn.iotstar.entity.Users;

public interface UserDao {
    Users get(String username);

    void insert(Users user);

    boolean checkExistEmail(String email);

    boolean checkExistUsername(String username);

    boolean checkExistPhone(String phone);

    Users getUserByEmail(String email);

    boolean updatePasswordByEmail(String email, String newPassword);
}
