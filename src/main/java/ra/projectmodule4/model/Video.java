package ra.projectmodule4.model;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class Video {
    private int id;
    private int like;
    private List<Comment> cmtList;
    private Long userId;
    private String videoUrl;
    private String title;
    private String description;

    public Video(int id, int like, List<Comment> cmtList, Long userId, String videoUrl, String title, String description) {
        this.id = id;
        this.like = like;
        this.cmtList = cmtList;
        this.userId = userId;
        this.videoUrl = videoUrl;
        this.title = title;
        this.description = description;
    }

    public Video() {
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }


    public List<Comment> getCmtList() {
        return cmtList;
    }

    public void setCmtList(List<Comment> cmtList) {
        this.cmtList = cmtList;
    }

    public int getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
