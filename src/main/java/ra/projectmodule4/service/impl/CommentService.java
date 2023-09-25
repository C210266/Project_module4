package ra.projectmodule4.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ra.projectmodule4.dao.impl.CommentDao;
import ra.projectmodule4.model.Comment;
import ra.projectmodule4.service.IGenericService;

import java.util.List;

@Service
public class CommentService implements IGenericService<Comment, Integer> {
    @Autowired
    private CommentDao commentDao;

    @Override
    public List<Comment> findAll() {
        return commentDao.findAll();
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
    public void addComment(int videoId,Long userId,String content){
         commentDao.addComment(videoId,userId,content);
    }
}
