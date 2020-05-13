package SpringAnnotations;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
public static void main(String args[]) {
	ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
	Coach c=context.getBean("tennisCoach",Coach.class);
	List<FortuneService> fslist = c.getDailyFortune();
	System.out.println(c.getDailyWorkout());
	for(FortuneService fs: fslist) {
		System.out.println(fs.getFortune());
	}
	context.close();
}
}
