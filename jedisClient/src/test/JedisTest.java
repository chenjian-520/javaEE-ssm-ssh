package test;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisTest {
	
	//直接连接
	@Test
	public void test(){
		Jedis jedis = new Jedis("192.168.66.101",6379);
		String v1 = jedis.get("k");
		System.out.println("k1="+v1);
		jedis.set("k2","v3");
		jedis.close();
	}
	
	
	//池连接
	@Test
	public void testPoll(){
		JedisPool pool = new JedisPool("192.168.66.101",6379);
		Jedis jedis = pool.getResource();
		String v1 = jedis.get("k2");
		System.out.println("k2="+v1);
		jedis.close();
		pool.close();
	}

}

