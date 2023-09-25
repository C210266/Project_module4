package ra.projectmodule4.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ra.projectmodule4.dao.IGenericDao;
import ra.projectmodule4.dto.request.VideoDTO;
import ra.projectmodule4.model.Comment;
import ra.projectmodule4.model.Video;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class VideoDao implements IGenericDao<Video, Integer> {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserDao userDao;

    @Override
    public List<Video> findAll() {
        return null;
    }

    @Override
    public void save(Video video) {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            if (video.getId() == 0) {
                // thêm moi
                CallableStatement callSt = conn.prepareCall("{call insertVideo(?,?,?,?)}");
                callSt.setLong(1, video.getUserId());
                callSt.setString(2, video.getTitle());
                callSt.setString(3, video.getDescription());
                callSt.setString(4, video.getVideoUrl());

                callSt.execute();
            } else {
                // cap nhat
                CallableStatement callSt = conn.prepareCall("{call updateVideo(?,?,?,?,?)}");
                callSt.setInt(1, video.getId());
                callSt.setLong(2, video.getUserId());
                callSt.setString(3, video.getTitle());
                callSt.setString(4, video.getDescription());
                callSt.setString(5, video.getVideoUrl());
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
    public Video findById(Integer integer) {
        Video video = null;
        Connection conn = null;
        try {
            // mỏ kết nối
            conn = dataSource.getConnection();

            // chuẩn bị câu lệnh
            CallableStatement callSt = conn.prepareCall("{call findByIdVideo(?)}");
            callSt.setInt(1, integer);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                video = new Video();
                video.setId(rs.getInt("id"));
                video.setUserId(rs.getLong("userId"));
                video.setTitle(rs.getString("title"));
                video.setDescription(rs.getString("description"));
                video.setVideoUrl(rs.getString("videoUrl"));
                video.setLike(rs.getInt("like"));

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
        return video;
    }

    @Override
    public void delete(Integer integer) {
        Connection conn = null;
        try {
            // mỏ kết nối
            conn = dataSource.getConnection();
            // chuẩn bị câu lệnh
            CallableStatement callSt = conn.prepareCall("{call deleteVideo(?)}");
            callSt.setInt(1, integer);
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

    public List<Video> findAllByUserId(Long aLong) {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        List<Video> videos = new ArrayList<>();
        try {
            CallableStatement callSt = conn.prepareCall("{call findAllByUserId(?)}");
            callSt.setLong(1, aLong);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Video v = new Video();
                v.setId(rs.getInt("id"));
                v.setDescription(rs.getString("description"));
                v.setTitle(rs.getString("title"));
                v.setVideoUrl(rs.getString("videoUrl"));
                v.setLike(rs.getInt("like"));


                videos.add(v);
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
        return videos;
    }

    public List<VideoDTO> findAllVideoDTOByUserId(Long aLong) {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        List<VideoDTO> videos = new ArrayList<>();
        try {
            CallableStatement callSt = conn.prepareCall("{call findAllByUserId(?)}");
            callSt.setLong(1, aLong);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                VideoDTO v = new VideoDTO();
                v.setId(rs.getInt("id"));
                v.setUser(userDao.findById(rs.getLong("userId")));
                v.setVideoUrlNotFile(rs.getString("videoUrl"));
                v.setTitle(rs.getString("title"));
                v.setDescription(rs.getString("description"));
                v.setLike(rs.getInt("like"));
                videos.add(v);
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
        return videos;
    }

    public void addLike(int videoId) {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            CallableStatement callSt = conn.prepareCall("{call addLike(?)}");
            callSt.setInt(1, videoId);
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

    public void decreareLike(int videoId) {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            CallableStatement callSt = conn.prepareCall("{call decreareLike(?)}");
            callSt.setInt(1, videoId);
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

    public int getLikeCount(int videoId) {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        int likeCount = 0;
        try {
            CallableStatement callSt = conn.prepareCall("{call getVideoLikeCount(?,?)}");
            callSt.setInt(1, videoId);
            callSt.registerOutParameter(2, Types.INTEGER);
            callSt.execute();
            likeCount = callSt.getInt(2);
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
        return likeCount;
    }

    public List<Comment> findAllCommentByVideoId(int videoId) {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        List<Comment> cmt = new ArrayList<>();
        try {
            CallableStatement callSt = conn.prepareCall("{call findAllCmtByVideoId(?)}");
            callSt.setInt(1, videoId);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Comment c = new Comment();
                c.setUserId(rs.getLong("user_id"));
                c.setContent(rs.getString("content"));
                c.setVideoId(videoId);
                c.setCreatedAt(rs.getObject("created_at", LocalDateTime.class)); // Sử dụng getObject để lấy giá trị và chuyển thành LocalDateTime
                cmt.add(c);
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
        return cmt;
    }

    public int countVideoByUserId(Long userId) {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        int videoCount = 0;
        try {
            CallableStatement callSt = conn.prepareCall("{call countVideoByUserId(?)}");
            callSt.setLong(1, userId);
            callSt.execute();
            ResultSet resultSet = callSt.getResultSet();
            if (resultSet.next()) {
                videoCount = resultSet.getInt(1);
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
        return videoCount; // Trả về số lượng video
    }

}
