package com.xy.sczl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.xy.sczl.common.redis.RedisCache;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SczlWebApplicationTests {

	@Autowired
	RedisCache redisCache;
	
	@Test
	public void contextLoads() {
		String key = "123";
		redisCache.setString(key, "dddd");
		System.err.println(redisCache.getString(key));
	}

}
