package in.ankushs.webbrowscap4j.config;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.guava.GuavaCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;

import com.google.common.cache.CacheBuilder;

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
	
	@Bean(name="browscapCache")
  	public SimpleCacheManager buildBrowscapCache(){
  		final SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
  		final GuavaCache userCache = new GuavaCache("browscapCache",CacheBuilder.newBuilder()
  												  .concurrencyLevel(3) //Choose per your own will.
  									 			  .maximumSize(500).build()); 
  		simpleCacheManager.setCaches(Arrays.asList(userCache));
  		return simpleCacheManager;
  	}
}
