package ra.projectmodule4.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ra.projectmodule4.dao.IGenericDao;
import ra.projectmodule4.dto.request.FormLoginDTO;
import ra.projectmodule4.dto.request.FormRegisterDTO;
import ra.projectmodule4.model.User;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDao implements IGenericDao<User, Long> {
    @Autowired
    public DataSource dataSource;

    @Override
    public List<User> findAll() {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        List<User> users = new ArrayList<>();
        try {
            CallableStatement callSt = conn.prepareCall("{call findALlUser()}");
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setId(rs.getLong("id"));
                u.setFullname(rs.getString("fullName"));
                u.setUsername(rs.getString("userName"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setAvatar(rs.getString("avatar"));
                u.setStatus(rs.getBoolean("status"));
                u.setCreateAt(rs.getTimestamp("create_at"));
                users.add(u);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return users;
    }

    @Override
    public void save(User user) {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            if (user.getId() == null) {
                // thêm moi
                CallableStatement callSt = conn.prepareCall("{call insertUser(?,?,?,?)}");
                callSt.setString(1, user.getUsername());
                callSt.setString(2, user.getEmail());
                callSt.setString(3, user.getFullname());
                callSt.setString(4, user.getPassword());
                callSt.execute();
            } else {
                // cap nhat
                CallableStatement callSt = conn.prepareCall("{call updateUser(?,?,?,?,?,?,?,?)}");
                callSt.setString(1, user.getUsername());
                callSt.setString(2, user.getEmail());
                callSt.setString(3, user.getFullname());
                callSt.setString(4, user.getPassword());
                callSt.setString(5, user.getLocation());
                callSt.setString(6, user.getInfo());
                Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
                callSt.setTimestamp(7, currentTimestamp);
                callSt.setLong(8, user.getId());
//
                callSt.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    @Override
    public void delete(Long id) {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            // xóa ảnh phụ
            CallableStatement callSt = conn.prepareCall("");

            callSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public User findById(Long id) {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        User u = null;
        try {
            CallableStatement callSt = conn.prepareCall("{call findByIdUser(?)}");
            callSt.setLong(1, id);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                u = new User();
                u.setId(rs.getLong("id"));
                u.setUsername(rs.getString("userName"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setFullname(rs.getString("fullName"));
                u.setAvatar(rs.getString("avatar"));
                u.setCreateAt(rs.getTimestamp("create_at"));

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return u;
    }

    public User login(FormLoginDTO formLoginDTO) {
        User user = null;
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            CallableStatement callSt = conn.prepareCall("{call login(?,?)}");
            callSt.setString(1, formLoginDTO.getUsername());
            callSt.setString(2, formLoginDTO.getPassword());
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getLong("id"));
                user.setUsername(rs.getString("userName"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setAvatar(rs.getString("avatar"));
                user.setStatus(rs.getBoolean("status"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return user;
    }

    public User loginAdmin(FormLoginDTO formLoginDTO) {
        User user = null;
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            CallableStatement callSt = conn.prepareCall("{call login(?,?)}");
            callSt.setString(1, formLoginDTO.getUsername());
            callSt.setString(2, formLoginDTO.getPassword());
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getLong("id"));
                user.setUsername(rs.getString("userName"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setAvatar("/login/avatar.png");
                user.setStatus(true);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return user;
    }

    public boolean register(FormRegisterDTO formRegisterDTO) {
        User user = null;
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            CallableStatement callSt = conn.prepareCall("{call login(?,?)}");
            callSt.setString(1, formRegisterDTO.getUsername());
            callSt.setString(2, formRegisterDTO.getPassword());
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                return false;
            }
//            user = new User();
//            user.setId(rs.getLong("id"));
//            user.setUsername(rs.getString("userName"));
//            user.setEmail(rs.getString("email"));
//            user.setPassword(rs.getString("password"));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return true;
    }

    public void updateUserFollow(Long followerId, Long followingId, LocalDateTime createdAt) {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            CallableStatement callSt = conn.prepareCall("{call updateUserFollow(?,?,?)}");
            callSt.setLong(1, followerId);
            callSt.setLong(2, followingId);
            callSt.setTimestamp(3, Timestamp.valueOf(createdAt));
            callSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public boolean checkRelationshipExists(Long follower_id, Long following_id) {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            CallableStatement callSt = conn.prepareCall("{call checkRelationshipExists(?, ?)}");
            callSt.setLong(1, follower_id);
            callSt.setLong(2, following_id);
            ResultSet rs = callSt.executeQuery();

            // Đảm bảo rằng ResultSet chỉ trả về một bản ghi
            if (rs.next()) {
                int relationshipExists = rs.getInt("relationship_exists");
                return relationshipExists == 1;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return false;

    }

    public List<User> getFollowingsByUserId(Long follower_id) {
        Connection conn = null;
        List<User> followings = new ArrayList<>();

        try {
            conn = dataSource.getConnection();
            CallableStatement callSt = conn.prepareCall("{call getFollowingsByUserId(?)}");
            callSt.setLong(1, follower_id);
            ResultSet rs = callSt.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setUsername(rs.getString("username"));
                user.setFullname(rs.getString("fullName"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setRoleId(rs.getLong("role"));
                user.setAvatar(rs.getString("avatar"));
                user.setInfo(rs.getString("info"));
                user.setLocation(rs.getString("location"));
                user.setStatus(rs.getBoolean("status"));
                user.setCreateAt(rs.getTimestamp("create_at"));
                followings.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return followings;
    }

    public void updateStatusAcc(Long userId, Boolean status) {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            CallableStatement callSt = conn.prepareCall("{call updateStatusAcc(?,?)}");
            callSt.setLong(1, userId);
            callSt.setBoolean(2, status);

            callSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
