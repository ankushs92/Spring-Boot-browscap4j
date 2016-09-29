package in.ankushs.webbrowscap4j.config;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import in.ankushs.browscap4j.domain.Browscap;

@Configuration
public class AppConfig {
	@Autowired
	private  ResourceLoader resourceLoader;
		
	@Bean
	public Browscap getBrowscap() throws IOException{
		final File browscapCsv = resourceLoader.getResource("classpath:/browscap.csv").getFile();
		final Browscap browscap = new Browscap(browscapCsv);
		return browscap;
	}
	
	@Bean
	public RedisTemplate<String,String> configureRedisTemplate(){
		final RedisTemplate<String,String> redisTemplate = new RedisTemplate<String,String>();
		redisTemplate.setConnectionFactory(configureRedisConnectionFactory());
		//JSON representation of Developer class will be stored in Redis. 
		redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<BrowserCapabilities2>(BrowserCapabilities2.class));
		return redisTemplate;
	}
	
	@Bean
	public RedisConnectionFactory configureRedisConnectionFactory(){
		//Set of Defaults
		final JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
		return jedisConnectionFactory;
	}
	
	@Bean
	public RedisCacheManager configureCacheManager(){
		final RedisCacheManager redisCacheManager = new RedisCacheManager(configureRedisTemplate());
		return redisCacheManager;
	}

}
