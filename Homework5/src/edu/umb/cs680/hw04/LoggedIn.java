package edu.umb.cs680.hw04;

public class LoggedIn implements State{
    private SecurityContext ctx;
    private static LoggedIn instance=null;
   /* private LoggedIn(SecurityContext ctx){
        this.ctx=ctx;
    }*/
   private LoggedIn(){ }
    public void init(SecurityContext ctx){this.ctx=ctx;}
    public static LoggedIn getInstance(){
        if (instance==null){
            instance=new LoggedIn();
        }
        return instance;
    }
    @Override
    public void login(EncryptedString pwd) {
       if(!ctx.isActive()){
            ctx.changeState(LoggedOut.getInstance());
            ctx.login(pwd);
        }
        else{
            System.out.println("already logged in");
        }
       }
    @Override
    public void logout() {
        LoggedOut instance=LoggedOut.getInstance();
        instance.init(ctx);
        ctx.changeState(instance);
        System.out.println("logged out");
    }
}
