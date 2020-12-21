package edu.njust.service;

public class test {
    public static void main(String[] args){
        LoginService loginService=new LoginService();
        //String rightPassword=loginService.login("918106840236","");
        //System.out.println(rightPassword);
        boolean isLoginSuccess=loginService.login("918106840236","840236");
        debug(isLoginSuccess);
    }

    public static void debug(Object o){
        System.out.println(o.toString());
    }
}
