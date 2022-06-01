/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import jakarta.inject.Named;

/**
 *
 * @author yunus
 */
@Named(value="um")
public class UserManager {

    private String username;
    private String password;

    public UserManager() {
    }

    public void register() {
        System.out.println("---------REGİSTER-------");

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
