package com.zhan.redis;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	
	private Logger logger = LoggerFactory.getLogger(RedisTest.class);
	
	@Test
	public void testRedisSet () throws InterruptedException {
		ValueOperations<String, Object> ops = this.redisTemplate.opsForValue();
		ops.set("name", "chen云展", 10, TimeUnit.SECONDS);
		
		Thread.sleep(9000);
		
		Object object = ops.get("name");
		logger.error("==========================================================="+object);
	}
	
	
	
	
	@Test
	public void testSaveUser() {
		ValueOperations<String, Object> ops = this.redisTemplate.opsForValue();
		
		Jackson2JsonRedisSerializer<User> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<User>(User.class);
		this.redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
		
		Role r = new Role();
		r.setUserId(11);
		r.setUserName("角色");
		
		ops.set("user", new User(10, "chenyunzhan",r));
		
		
		Object object = ops.get("user");
    	logger.error("==========================================================="+object);
	}
	
	
	
	@Test
	public void testSonar() throws Exception{
		InputStream is = new ByteArrayInputStream(new byte[] {1,2,3});
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		
		BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(os);
            byte[] buff = new byte[2048];
            int bytesRead;
            // Simple read/write loop.
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
            
            bos.flush();
            
            System.out.println("a");
            
            logger.error("===========================================================");
            logger.info("===========================================================");
	    	logger.error("==========================================================="+os.toByteArray());
            
        } catch (final IOException e) {
            throw e;
        } finally {
        	
        }
	}
}
