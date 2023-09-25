package ra.projectmodule4.dto.request;

import ra.projectmodule4.model.User;
import ra.projectmodule4.model.Video;

import java.time.LocalDateTime;

public class CommentDTO {
    private int id;
    private User user;
    private int videoId;
    private String content;
    private LocalDateTime createdAt; // Thời gian comment được tạo

    public CommentDTO() {
    }

    public CommentDTO(int id, User user, int videoId, String content, LocalDateTime createdAt) {
        this.id = id;
        this.user = user;
        this.videoId = videoId;
        this.content = content;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
