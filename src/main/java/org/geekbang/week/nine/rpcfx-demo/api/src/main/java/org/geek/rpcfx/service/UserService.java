package org.geek.rpcfx.service;

import org.geek.rpcfx.pojo.User;

/**
 * 描述:
 *
 * @author lil
 */
public interface UserService {

    User findById(Integer id);
}
