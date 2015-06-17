package recruiterbox.webcrawler;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCrawler {
	
	private static final String SPRING_CONFIGURATION_FILE = "spring.xml";
	private static final String INITIAL_URL = "http://yahoo.com/"; 
	private static final String SPIDER_BEAN = "spider";

	public static void main(String[] args) {
	  
		ApplicationContext ctx = new ClassPathXmlApplicationContext(SPRING_CONFIGURATION_FILE); 
		Spider spider = (Spider) ctx.getBean(SPIDER_BEAN);
		spider.startCrawling(INITIAL_URL);
	}
}
