package cn.itcast;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author z
 */
@SpringBootApplication
@MapperScan(basePackages = {"cn.itcast.dao", "cn.itcast.mapper"})
public class Web8Application {

    public static void main(String[] args) {
        SpringApplication.run(Web8Application.class, args);
    }

}
