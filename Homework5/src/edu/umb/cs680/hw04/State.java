package edu.umb.cs680.hw04;

public interface State {

    public abstract void login(EncryptedString pwd);
    public abstract void logout();
}
