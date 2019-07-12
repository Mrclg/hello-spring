package com.guang.threaddemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;

@SpringBootApplication
@RestController
@Slf4j
public class ThreadDemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ThreadDemoApplication.class, args);
    }

    @Resource(name = "consumerQueueThreadPool")
    private ExecutorService consumerQueueThreadPool;

    public void run(String... args) throws Exception {
        //消费队列
        for (int i = 0; i < 5; i++) {
            consumerQueueThreadPool.execute(new ConsumerQueueThread());
        }
    }
}
