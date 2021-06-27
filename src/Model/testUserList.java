package Model;

import java.util.HashMap;

public class testUserList {
    HashMap<String, String> testUser = new HashMap<>();

    public testUserList(){
        createTestUserList();
    }
    public void createTestUserList(){
        testUser.put("test", "password");
        testUser.put("test1", "password1");
        testUser.put("test2", "password2");
        testUser.put("test3", "password3");
        testUser.put("test4", "password4");
        testUser.put("test5", "password5");
        testUser.put("test6", "password6");
    }

    public boolean hasUser(String username){
        return testUser.containsKey(username);
    }
    public boolean isPassword(String username, String password){
        return testUser.get(username).equals(password);
    }
    public void setTestUserList(HashMap<String, String> userList){
        this.testUser = userList;
    }

}
