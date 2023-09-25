package ra.projectmodule4.model;

import java.util.Date;
import java.util.Set;

public class User {
    private Long id;
    private String username;
    private String email;
    private String fullname;
    private String password;
    private String avatar = "/login/avatar.png";
    private String info;
    private String location;
    private Long roleId = 2L;
    private boolean status ;

    private Date createAt = new Date();

    public User(Long id, String username, String email, String fullname, String password, String avatar, String info, String location, Long roleId, boolean status, Date createAt) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.fullname = fullname;
        this.password = password;
        this.avatar = avatar;
        this.info = info;
        this.location = location;
        this.roleId = roleId;
        this.status = status;
        this.createAt = createAt;
    }

    public User() {
    }

    public String getInfo() {
        return info;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
