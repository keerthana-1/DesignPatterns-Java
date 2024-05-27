package edu.umb.cs680.hw04;

public class Main {
    public static void main(String[] args) {
        SecurityContext sc=new SecurityContext("keerthana",new EncryptedString("abc123"));
        sc.logout();
        sc.login(new EncryptedString("abc123"));
        sc.logout();
        sc.login(new EncryptedString("abc123"));
        System.out.println("Hello world!");
    }
}