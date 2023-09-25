package ra.projectmodule4.dto.request;

import org.springframework.web.multipart.MultipartFile;
import ra.projectmodule4.model.User;

public class VideoDTO {
    private int id;
    private User user;
    private MultipartFile videoUrl;
    private String title;
    private String description;
    private String videoUrlNotFile;
    private int like;
    private String cmt;


    public VideoDTO(MultipartFile videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getVideoUrlNotFile() {
        return videoUrlNotFile;
    }

    public void setVideoUrlNotFile(String videoUrlNotFile) {
        this.videoUrlNotFile = videoUrlNotFile;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public String getCmt() {
        return cmt;
    }

    public void setCmt(String cmt) {
        this.cmt = cmt;
    }

    public VideoDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public MultipartFile getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(MultipartFile videoUrl) {
        this.videoUrl = videoUrl;
    }
}
