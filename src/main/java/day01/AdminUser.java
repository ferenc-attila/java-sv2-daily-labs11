package day01;

public class AdminUser implements User {

    private String email;
    private String password;

    public AdminUser(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String getUserEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        String star = "*";
        return star.repeat(password.length());
    }
}
