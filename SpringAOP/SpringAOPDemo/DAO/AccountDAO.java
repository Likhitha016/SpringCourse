package SpringAOPDemo.DAO;

import SpringAOPDemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {
    String name;
    String serviceCode;
    public void addAccount(Account acc,boolean b) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    public String getName() {
        System.out.println("Inside getName"+getClass());
        return name;
    }

    public void setName(String name) {
        System.out.println("Inside setName"+getClass());
        this.name = name;
    }


    public String getServiceCode() {
        System.out.println("Inside getServiceCode"+getClass());
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println("Inside setServiceCode"+getClass());
        this.serviceCode = serviceCode;
    }

    public List<Account> findAccounts(boolean check) {
        List<Account> myAccounts = new ArrayList<>();
        if (check) {
            throw new RuntimeException("No soup for you!!!");
        }

            // create sample accounts
        Account temp1 = new Account("John", "Silver");
        Account temp2 = new Account("Madhu", "Platinum");
        Account temp3 = new Account("Luca", "Gold");

        // add them to our accounts list
        myAccounts.add(temp1);
        myAccounts.add(temp2);
        myAccounts.add(temp3);


        return myAccounts;
    }
}
