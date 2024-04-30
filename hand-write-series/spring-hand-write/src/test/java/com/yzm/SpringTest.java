package com.yzm;

import com.yzm.config.Configuration;
import com.yzm.context.ApplicationContext;
import org.junit.Test;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/29
 */
public class SpringTest {

    @Test
    public void test() throws ClassNotFoundException {
        ApplicationContext applicationContext = new ApplicationContext(Configuration.class);
    }
}
