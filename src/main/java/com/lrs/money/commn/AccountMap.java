package com.lrs.money.commn;

import org.springframework.util.StringUtils;

import java.util.TreeMap;

/**
 * @program: money
 * @description:
 * @author: alei
 * @create: 2019-10-11 21:14
 **/

public class AccountMap {

    public static TreeMap<String, String> accounts = new TreeMap<>();;

    public static TreeMap<String, String> getAccount(){
        TreeMap<String, String> accountMap = new TreeMap<>();
        if (accounts == null || accounts.size() < 1){
            return null;
        }
        String account = accounts.firstKey();
        if (StringUtils.isEmpty(account)){
            return null;
        }
        String password = accounts.get(account);

        if (StringUtils.isEmpty(password)){
            return null;
        }

        accountMap.put("account", account);
        accountMap.put("password", password);

        String remove = accounts.remove(account);
        if (StringUtils.isEmpty(remove)){
            return null;
        }

        return accountMap;
    }

}
