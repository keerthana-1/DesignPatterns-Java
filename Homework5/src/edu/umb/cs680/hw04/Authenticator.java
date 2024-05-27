package edu.umb.cs680.hw04;

public class Authenticator {

    public static boolean authenticate(SecurityContext ctx,EncryptedString pwd){

        if(ctx.getPwd().password.equals(pwd.password)){
            return true;
        }
        return false;
    }
}
