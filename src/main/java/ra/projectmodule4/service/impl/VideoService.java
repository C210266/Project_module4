package ra.projectmodule4.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.projectmodule4.dao.impl.VideoDao;
import ra.projectmodule4.dto.request.VideoDTO;
import ra.projectmodule4.model.Comment;
import ra.projectmodule4.model.Video;
import ra.projectmodule4.service.IGenericService;

import java.util.List;

@Service
public class VideoService implements IGenericService<Video, Integer> {
    @Autowired
    private VideoDao videoDao;

    @Override
    public List<Video> findAll() {
        return null;
    }

    @Override
    public void save(Video video) {
        videoDao.save(video);
    }

    @Override
    public Video findById(Integer integer) {
        return videoDao.findById(integer);
    }

    @Override
    public void delete(Integer integer) {
        videoDao.delete(integer);
    }

    public List<Video> findAllByUserId(Long aLong) {

        return videoDao.findAllByUserId(aLong);
    }

    public List<VideoDTO> findAllVideoDTOByUserId(Long aLong) {

        return videoDao.findAllVideoDTOByUserId(aLong);
    }

    //    Tang like
    public void addLike(int videoId) {
        videoDao.addLike(videoId);
    }

    //Giam like
    public void decreareLike(int videoId) {
        videoDao.decreareLike(videoId);
    }

    public int getLikeCount(int videoId) {
        return videoDao.getLikeCount(videoId);

    }

    public List<Comment> findAllCommentByVideoId(int videoId) {
        return videoDao.findAllCommentByVideoId(videoId);
    }

    public int countVideoByUserId(Long userId) {
        return videoDao.countVideoByUserId(userId);
    }

}
