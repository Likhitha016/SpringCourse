package SpringAOPDemo.DAO;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public boolean addAccount(boolean k) {
        k=true;
        System.out.println(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");
        return k;

    }

    public boolean addSillyMember() {

        System.out.println(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");

        return true;
    }

    public void goToSleep() {

        System.out.println(getClass() + ": I'm going to sleep now...");

    }
}