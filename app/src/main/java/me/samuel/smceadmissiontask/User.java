package me.samuel.smceadmissiontask;

import java.util.HashMap;
import java.util.Map;


public class User {
    private String fname;
    private String email;
    private String password;
    private String dobname;
    private String phone;
    private String schoolname;
    private String groupname;
    private String addressname;


    public  User(){

}


    public User(String fname, String email, String password, String dobname, String phone, String schoolname, String groupname, String addressname) {
        this.fname = fname;
        this.email = email;
        this.password = password;
        this.dobname = dobname;
        this.phone = phone;
        this.schoolname = schoolname;
        this.groupname = groupname;
        this.addressname = addressname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDobname() {
        return dobname;
    }

    public void setDobname(String dobname) {
        this.dobname = dobname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getAddressname() {
        return addressname;
    }

    public void setAddressname(String addressname) {
        this.addressname = addressname;
    }
}

/*    public HashMap<String, Object> getAsMap(){
        HashMap<String, Object> userAsMap = new HashMap<>();
        userAsMap.put("username",username);
        userAsMap.put("password",password);
        userAsMap.put("age",age);
        userAsMap.put("name",name);

        //Add or remove more key value pair

        return userAsMap;
    }*/