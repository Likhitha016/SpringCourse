package SpringAOPDemo;

import SpringAOPDemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
@Component
public class AroundDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =new AnnotationConfigApplicationContext(DemoConfig.class);
        TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        System.out.println("\nMain Program: AroundDemoApp");

        System.out.println("Calling getFortune");

        String data = theFortuneService.getFortune();

        System.out.println("\nMy fortune is: " + data);

        System.out.println("Finished");

        // close the context
        context.close();
    }

}
