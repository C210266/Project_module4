package ra.projectmodule4.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ra.projectmodule4.dao.IGenericDao;
import ra.projectmodule4.model.Comment;
import ra.projectmodule4.model.User;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class CommentDao implements IGenericDao<Comment, Integer> {
    @Autowired
    public DataSource dataSource;

    @Override
    public List<Comment> findAll() {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        List<Comment> comments = new ArrayList<>();
        try {
            CallableStatement callSt = conn.prepareCall("{call findAllCmt()}");
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Comment c = new Comment();
                c.setId(rs.getInt("id"));
                c.setUserId(rs.getLong("user_id"));
                c.setVideoId(rs.getInt("video_id"));
                c.setContent(rs.getString("content"));
                c.setCreatedAt(rs.getObject("created_at", LocalDateTime.class));
                comments.add(c);
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
        return comments;
    }


    @Override
    public void save(Comment comment) {

    }

    @Override
    public Comment findById(Integer integer) {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }

    public void addComment(int videoId, Long userId, String content) {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            CallableStatement callSt = conn.prepareCall("{call addComment(?,?,?)}");
            callSt.setInt(1, videoId);
            callSt.setLong(2, userId);
            callSt.setString(3, content);
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
