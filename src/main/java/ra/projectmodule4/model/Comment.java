package ra.projectmodule4.model;

import java.time.LocalDateTime;

public class Comment {
    private int id;
    private Long userId;
    private int videoId;
    private String content;
    private LocalDateTime createdAt; // Thời gian comment được tạo

    public Comment(int id, Long userId, int videoId, String content, LocalDateTime createdAt) {
        this.id = id;
        this.userId = userId;
        this.videoId = videoId;
        this.content = content;
        this.createdAt = createdAt;
    }

    public Comment( int videoId, Long userId, String content) {
        this.userId = userId;
        this.videoId = videoId;
        this.content = content;
    }

    public Comment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
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