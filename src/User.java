public class User {
    String name;
    String pass;
    User(String username, String password){
        this.name = username;
        this.pass = password;
    }

    public String getName (){
        return this.name;
    }
    public String getPass (){
        return this.pass;
    }
}
