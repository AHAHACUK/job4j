package ru.job4j.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Bank {
    private Map<User, List<Account>> accounts;

    public void addUser(User user) {
        accounts.putIfAbsent(user, new ArrayList<Account>());
    }

    public void deleteUser(User user) {
        accounts.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        List<Account> list = getUserAccounts(passport);
        list.add(account);
    }

    public void deleteAccountFromUser(String passport, Account account) {
        List<Account> list = getUserAccounts(passport);
        if (list.contains(account)) {
            list.remove(account);
        }
    }

    public List<Account> getUserAccounts (String passport) {
        List<Account> list = new ArrayList<>();
        for (User user : accounts.keySet()) {
            if (user.getPassport().equals(passport)) {
                list = accounts.get(user);
                break;
            }
        }
        return list;
    }

    public Account getUserAccount (String passport, String requisites) {
        Account result = null;
        for (Account acc : getUserAccounts(passport)) {
            if (acc.getRequisites().equals(requisites)) {
                result = acc;
            }
        }
        return result;
    }

    public boolean transferMoney (String srcPassport, String srcRequisite, String destPassport, String destRequisite, double amount) {
        boolean result = false;
        Account srcAccount = getUserAccount(srcPassport, srcRequisite);
        Account destAccount = getUserAccount(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null) {
            result = srcAccount.transfer(destAccount, amount);;
        }
        return result;
    }
}
