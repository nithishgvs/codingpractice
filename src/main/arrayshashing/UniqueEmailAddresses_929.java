package main.arrayshashing;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses_929 {

    public int numUniqueEmails(String[] emails) {

        Set<String> uniqueEmails = new HashSet<>();

        for (int i = 0; i < emails.length; i++) {
            int index = emails[i].lastIndexOf(".");
            String prefix = emails[i].substring(0, index);
            int atIndex = prefix.indexOf("@");
            String domainName = prefix.substring(atIndex);
            prefix = prefix.substring(0, atIndex);
            int plusIndex = prefix.indexOf("+");
            if (plusIndex != -1) {
                prefix = prefix.substring(0, plusIndex);
            }
            prefix = prefix.replaceAll("[.]", "");
            uniqueEmails.add(prefix + domainName + ".com");
        }

        return uniqueEmails.size();
    }

    @Test
    public void test() {
        String[] emails = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        String[] emails2 = {"linqmafia@leet+code.com", "linqmafia@code.com"};
        //["test.email+alex@leetcode.com", "test.email@leetcode.com"]
        //["linqmafia@leet+code.com","linqmafia@code.com"]
        System.out.println(numUniqueEmails(emails));
    }
}
