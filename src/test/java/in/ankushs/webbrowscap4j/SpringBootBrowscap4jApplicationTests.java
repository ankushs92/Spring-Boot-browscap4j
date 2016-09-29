package in.ankushs.webbrowscap4j;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import in.ankushs.webbrowscap4j.service.BrowscapService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringBootBrowscap4jApplication.class)
@WebAppConfiguration
public class SpringBootBrowscap4jApplicationTests {

	@Autowired
	BrowscapService browscapService;
	
	static Executor executor = Executors.newFixedThreadPool(10);
	@Test
	public void contextLoads() throws InterruptedException {
		
		String random = "";
		String iphone = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.80 Safari/537.36";
		String macbook = "Mozilla/5.0 (compatible; MSIE 10.0; Windows Phone 8.0; Trident/6.0; IEMobile/10.0; ARM; Touch; NOKIA; Lumia 520)";
		browscapService.getBrowerCapabilities(iphone);
		browscapService.getBrowerCapabilities(macbook);
		
		
		for(int i = 0; i< 20000; i ++){
			executor.execute(()->{
				browscapService.getBrowerCapabilities(RandomStringUtils.randomAlphanumeric(100));
			});
		}
		
		Thread.sleep(10000000);
	}

}
