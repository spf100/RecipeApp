package Model;

public class User{
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    public User(){
    }

    public User(String username, String password, String firstName, String lastName){
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
    public String getFirstName(){return firstName;}
    public String getLastName(){return lastName;}

    public void setPassword(String password) {
        this.password = password;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public void setFirstName(String firstName){this.firstName = firstName;}
    public void setLastName(String lastName){this.lastName = lastName;}

}
