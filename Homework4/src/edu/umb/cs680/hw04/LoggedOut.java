package edu.umb.cs680.hw04;

public class LoggedOut implements State {

    private SecurityContext ctx;
    private static LoggedOut instance=null;

    /*LoggedOut(SecurityContext ctx ){
        this.ctx=ctx;
    }*/
    private LoggedOut(){ }
    public void init(SecurityContext ctx){this.ctx=ctx;}
    public static LoggedOut getInstance(){
        if (instance==null){
            instance=new LoggedOut();
        }
        return instance;
    }
    @Override
    public void login(EncryptedString pwd) {

        if(Authenticator.authenticate(ctx,pwd)){
            LoggedIn instance=LoggedIn.getInstance();
            instance.init(ctx);
            ctx.changeState(instance);
            System.out.println("logged in");
        }
        else{
            System.out.println("Authentication failed");
            throw new RuntimeException("Authentication failed");

        }
    }
    @Override
    public void logout() {
        System.out.println("already logged out");
    }
}
