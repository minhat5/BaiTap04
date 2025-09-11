package vn.iotstar.services.impl;

import vn.iotstar.dao.UserDao;
import vn.iotstar.dao.impl.UserDaoImpl;
import vn.iotstar.entity.Users;
import vn.iotstar.services.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public Users login(String username, String password) {
        Users user = this.get(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    @Override
    public Users get(String username) {
        return userDao.get(username);
    }

    @Override
    public void insert(Users user) {
        userDao.insert(user);
    }

    @Override
    public boolean register(String email, String password, String username, String fullname, String phone) {
        if (userDao.checkExistUsername(username)) {
            return false;
        }
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        userDao.insert(new Users(email, username, fullname, password, null, 1, phone, date));
        return true;
    }

    @Override
    public boolean checkExistEmail(String email) {
        return userDao.checkExistEmail(email);
    }

    @Override
    public boolean checkExistUsername(String username) {
        return userDao.checkExistUsername(username);
    }

    @Override
    public boolean checkExistPhone(String phone) {
        return userDao.checkExistPhone(phone);
    }

    @Override
    public Users getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    @Override
    public boolean updatePasswordByEmail(String email, String newPassword) {
        return userDao.updatePasswordByEmail(email, newPassword);
    }

    @Override
    public void update(Users user) {
        userDao.update(user);
    }
}
