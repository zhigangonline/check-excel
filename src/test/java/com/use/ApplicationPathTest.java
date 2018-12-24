package com.use;

import com.use.util.ProjectPathUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ApplicationPathTest {


    @Test
    public void testApplicationContext() {
        System.out.println(ProjectPathUtil.getApplicationPath());
        Assert.assertEquals("http://10.23.1.124:8080/online-hall/", ProjectPathUtil.getApplicationPath());
    }
}
