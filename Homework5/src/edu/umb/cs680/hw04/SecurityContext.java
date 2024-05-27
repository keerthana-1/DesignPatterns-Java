package edu.umb.cs680.hw04;

public class SecurityContext {
    State state;
    String user;
    EncryptedString pwd;
    public SecurityContext(String user, EncryptedString pwd){
        this.user=user;
        this.pwd=pwd;
        LoggedOut instance=LoggedOut.getInstance();
        instance.init(this);
        state = instance;
    }
    public State getState(){
        return this.state;
    }
    public EncryptedString getPwd(){
        return pwd;
    }
    public void changeState(State newState){
        this.state=newState;
        System.out.println("state changed");
    }
    public void login(EncryptedString pwd){
        state.login(pwd);
    }
    public void logout(){
        state.logout();
    }
    
    public boolean isActive(){
        if(this.state instanceof LoggedIn)
            return true;
        else
            return false;

    }

}
