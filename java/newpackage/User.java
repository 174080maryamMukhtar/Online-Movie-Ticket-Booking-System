
package newpackage;



public class User {
    private String type;
    private String name;
    private int age;
    private String username;
    private String password;
    private String email;
    private String contactNumber;
    User(String n,int a,String uname,String pass,String em,String contact,String t)
    {
        name=n;
        age=a;
        username=uname;
        password=pass;
        email=em;
        contactNumber=contact;
        type=t;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    
}
