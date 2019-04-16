package com.eutopia;

import com.eutopia.config.RedisConfig;
import com.eutopia.lock.RedisTool;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class DistributedLockTest {

    @Autowired
    private RedisTool redisTool;

    @Test
    public void lockA() {
        String clientA = "A";
        System.out.println(redisTool.tryGetDistributedLock("tx", clientA, 5 * 60 * 1000));
    }

    @Test
    public void lockB() {
        String clientB = "B";
        System.out.println(redisTool.tryGetDistributedLock("tx", clientB, 5 * 60 * 1000));
    }

    @Test
    public void releaseA() {
        String clientA = "A";
        System.out.println(redisTool.releaseDistributedLock("tx", clientA));
    }

    @Test
    public void releaseB() {
        String clientB = "B";
        System.out.println(redisTool.releaseDistributedLock("tx", clientB));
    }
}
