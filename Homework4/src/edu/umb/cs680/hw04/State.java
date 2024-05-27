package edu.umb.cs680.hw04;

public interface State {

    public void login(EncryptedString pwd);
    public void logout();
}
