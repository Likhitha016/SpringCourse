package SpringAOPDemo;

import SpringAOPDemo.DAO.AccountDAO;
import SpringAOPDemo.DAO.MembershipDAO;
import SpringAOPDemo.DemoConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        //get accountDAO bean
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
        //get Membership bean
        MembershipDAO themembershipDAO=context.getBean("membershipDAO",MembershipDAO.class);
        Account myacc=new Account();

        myacc.setName("xyz");
        myacc.setLevel("xxx");
        theAccountDAO.addAccount(myacc,true);
        themembershipDAO.addAccount(true);
//        System.out.println("\nlet's call it again!\n");
//        theAccountDAO.addAccount();
        theAccountDAO.setName("Savings");
        theAccountDAO.setServiceCode("gold");
        String name=theAccountDAO.getName();
        String code=theAccountDAO.getServiceCode();

        themembershipDAO.addSillyMember();
        themembershipDAO.goToSleep();

        context.close();
    }
}
