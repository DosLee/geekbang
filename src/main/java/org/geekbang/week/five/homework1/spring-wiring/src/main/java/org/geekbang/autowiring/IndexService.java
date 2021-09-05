package org.geekbang.autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:
 * 调用AutoWiring
 *
 * @author lil
 */
@Service
public class IndexService {

    @Autowired
    private AutoWiringService autoWiringService;

    public void recordLog() {
        autoWiringService.print();
    }
}
