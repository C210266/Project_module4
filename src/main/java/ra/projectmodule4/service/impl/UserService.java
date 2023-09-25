package ra.projectmodule4.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.projectmodule4.dao.impl.UserDao;
import ra.projectmodule4.dto.request.FormLoginDTO;
import ra.projectmodule4.dto.request.FormRegisterDTO;
import ra.projectmodule4.model.User;
import ra.projectmodule4.service.IGenericService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;


    public List<User> findAll() {
        return userDao.findAll();
    }

    public void save(User user) {
        userDao.save(user);
    }

    public void saveLogin(FormLoginDTO formLoginDTO) {
        User user = new User();
        user.setUsername(formLoginDTO.getUsername());
        user.setEmail(formLoginDTO.getEmail());
        user.setPassword(formLoginDTO.getPassword());
        userDao.save(user);
    }

    public void saveRegister(FormRegisterDTO formRegisterDTO) {
        User user = new User();
        user.setUsername(formRegisterDTO.getUsername());
        user.setEmail(formRegisterDTO.getEmail());
        user.setPassword(formRegisterDTO.getPassword());
        user.setFullname(formRegisterDTO.getFullname());

        userDao.save(user);
    }

    public User findById(Long aLong) {
        return userDao.findById(aLong);
    }

    public void delete(Long aLong) {

    }

    public User login(FormLoginDTO formLoginDTO) {
        return userDao.login(formLoginDTO);

    }

    public User loginAdmin(FormLoginDTO formLoginDTO) {
        return userDao.loginAdmin(formLoginDTO);
    }

    public boolean register(FormRegisterDTO formRegisterDTO) {
        return userDao.register(formRegisterDTO);
    }

    public void updateUserFollow(Long follower, Long following, LocalDateTime createdAt) {
        userDao.updateUserFollow(follower, following, createdAt);
    }

    public boolean checkRelationshipExists(Long follower_id, Long following_id) {
        return userDao.checkRelationshipExists(follower_id, following_id);
    }

    public List<User> getFollowingsByUserId(Long follower_id) {
        return userDao.getFollowingsByUserId(follower_id);
    }
    public void updateStatusAcc(Long userId , Boolean status){
         userDao.updateStatusAcc(userId,status);
    }
}
