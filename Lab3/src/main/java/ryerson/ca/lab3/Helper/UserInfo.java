package ryerson.ca.lab3.Helper;

public class UserInfo {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String username;
    private String password;

    public UserInfo(String firstName, String lastName, String email, String phone, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }

}
