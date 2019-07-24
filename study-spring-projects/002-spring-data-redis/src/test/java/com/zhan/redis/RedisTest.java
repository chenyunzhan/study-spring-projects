package com.zhan.redis;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class RedisTest {
	
	@Autowired RedisTemplate<String, Object> redisTemplate;
	
	@Test
	public void testRedisSet () throws InterruptedException {
		ValueOperations<String, Object> ops = this.redisTemplate.opsForValue();
		ops.set("name", "chen云展", 10, TimeUnit.SECONDS);
		
		Thread.sleep(9000);
		
		Object object = ops.get("name");
		System.out.println(object);
	}
	
	
	
	
	@Test
	public void testSaveUser() {
		ValueOperations<String, Object> ops = this.redisTemplate.opsForValue();
		
		//this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
		Jackson2JsonRedisSerializer<User> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<User>(User.class);
		this.redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
		
		Role r = new Role();
		r.setUserId(11);
		r.setUserName("角色");
		
		ops.set("user", new User(10, "chenyunzhan",r));
		
		
		Object object = ops.get("user");
		System.out.println(object);
	}
}
