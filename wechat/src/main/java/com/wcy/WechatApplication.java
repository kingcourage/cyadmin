package com.wcy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.core.StringRedisTemplate;

@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
@ServletComponentScan
public class WechatApplication/* implements CommandLineRunner*/{
    @Autowired
    private StringRedisTemplate template;

    public static void main(String[] args) {
        SpringApplication.run(WechatApplication.class, args);
    }

  /*  @Override
    public void run(String... args) throws Exception {
        ValueOperations<String, String> ops = this.template.opsForValue();
        String key = "spring.boot.redis.test";
        if (!this.template.hasKey(key)) {
            ops.set(key, "fooaaa");
           template.opsForValue().set("wcy","kingcourage");
        }
        System.out.println("Found key " + key + ", value=" + ops.get(key));
        System.out.println("wcy:"+template.opsForValue().get("wcy"));
    }*/

}
