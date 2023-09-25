package ra.projectmodule4.dto.request;

import org.springframework.validation.Errors;

public class FormLoginDTO {
    private String username;
    private String password;
    private String email;

    public FormLoginDTO(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public FormLoginDTO() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

//    public void checkValidate(Errors errors) {
//        if(this.username.trim().equals("")){
//            errors.reject("username","username.empty");
//        }
//    }
}
