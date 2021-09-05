package org.geekbang.autowiring;

import org.springframework.stereotype.Service;

/**
 * 描述:
 * 自动化装配
 *
 * @author lil
 */
@Service
public class AutoWiringService {

    public void print() {
        System.out.println("自动化装配方式");
    }
}
