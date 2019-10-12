package com.lrs.money.controller;


import com.lrs.money.commn.AccountMap;
import com.lrs.money.commn.ResultMsg;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.TreeMap;

/**
 * @program: money
 * @description:
 * @author: alei
 * @create: 2019-10-11 21:11
 **/

@RestController
@RequestMapping("/AccountController")
public class AccountController {

    @RequestMapping("/getAccount")
    public ResultMsg getAccount(){

        TreeMap<String, String> accountMap = AccountMap.getAccount();
        TreeMap<String, String> data = new TreeMap<>();
        String account = null;
        String password = null;

        if (accountMap == null || accountMap.size() != 2){

            System.out.println("帐号不足！待添加");
            return new ResultMsg("333", "帐号不足！待添加", null);
        }else {
            account = accountMap.get("account");
            password = accountMap.get("password");

        }

        if (StringUtils.isEmpty(account) || StringUtils.isEmpty(password)){
            return new ResultMsg("444", "系统错误", null);
        }


        return new ResultMsg("200", "获取成功", account, password);
    }

    @RequestMapping("/putAccount")
    public ResultMsg putAccount(String str){
        if (StringUtils.isEmpty(str)){
            return new ResultMsg("777", "上传数据为空", null);
        }
        String s = "\\r\\n";
        String[] strs = str.split("\\r\\n");
        if (strs == null || strs.length < 1){
            return new ResultMsg("775", "上传数据无法识别", null);

        }

        Integer count = 0;
        for (int i = 0; i < strs.length; i++) {
            String accountStr = strs[i];
            if (StringUtils.isEmpty(accountStr)){
                continue;
            }

            String[] split = accountStr.split("--");
            if (split == null || split.length < 2){
                continue;
            }

            String account = split[0];
            String password = split[1];

            if (StringUtils.isEmpty(account) || StringUtils.isEmpty(password)){
                continue;
            }

            account = account.replaceAll(" ", "").replace(" ", "");
            password = password.replaceAll(" ", "").replace(" ", "");

            if (StringUtils.isEmpty(account) || StringUtils.isEmpty(password)){
                continue;
            }

            String put = AccountMap.accounts.put(account, password);
            if (!StringUtils.isEmpty(s)){
                System.out.println("成功添加帐号：" + account + "\t\t密码为：" + password);
                System.out.println("*****************************************");
                count ++;
            }




        }

        if (count < 1){
            return new ResultMsg("777", "上传数据为空", null);
        }else {
            return new ResultMsg("200", "成功上传" + count + "个帐号", count);
        }

    }

    @RequestMapping("/getAccountNum")
    public ResultMsg getAccountNum(){
        int size = AccountMap.accounts.size();
        return new ResultMsg("200", "当前剩余帐号个数为" + size + "个", size);
    }

    public static void main(String[] args) {

        String str = " 3366756 -- dfasfere \r\n 3379658 -- dfjsadkfdj";
        String[] split = str.split("\r\n");
        System.out.println(str);


    }

}
