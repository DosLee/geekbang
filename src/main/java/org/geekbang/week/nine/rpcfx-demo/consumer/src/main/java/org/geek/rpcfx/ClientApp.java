package org.geekbang.week.nine.rpcfx;

import org.geek.rpcfx.client.Rpcfx;
import org.geek.rpcfx.pojo.User;
import org.geek.rpcfx.service.UserService;

/**
 * 描述:
 *
 * @author lil
 */
public class ClientApp {
    public static void main(String[] args) {
        UserService userService = Rpcfx.create(UserService.class, "http://localhost:8080/");
        User user = userService.findById(1);
        System.out.println("find user from server: " + user.getName());
    }
}
