package org.geek.rpcfx;


import org.geek.rpcfx.pojo.User;
import org.geek.rpcfx.service.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public User findById(Integer id) {
        return new User(id, "lisi" + System.currentTimeMillis());
    }
}
