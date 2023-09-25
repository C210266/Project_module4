package ra.projectmodule4.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.projectmodule4.dto.request.CommentDTO;
import ra.projectmodule4.model.Comment;
import ra.projectmodule4.model.User;
import ra.projectmodule4.model.Video;
import ra.projectmodule4.service.impl.CommentService;
import ra.projectmodule4.service.impl.UserService;
import ra.projectmodule4.service.impl.VideoService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private UserService userService;
    @Autowired
    private VideoService videoService;
    private static final Gson GSON = new GsonBuilder().create();

//    @GetMapping("/{videoId}")
//    public String commentHome(@PathVariable("videoId") int videoId, Model model) {
//        Video video = videoService.findById(videoId);
//        model.addAttribute("video", video);
//
//        return "comment";
//    }

    @PostMapping("/commentAdd/{videoId}")
    public void uploadCmt(HttpServletResponse response, HttpSession session, @PathVariable("videoId") int videoId, @RequestParam("content") String content, Model model) {
        User user = (User) session.getAttribute("userlogin");
        if (user == null) {
            // Người dùng chưa đăng nhập, hiển thị thông báo hoặc xử lý tương ứng
            response.setStatus(401); // Unauthorized status code
            return;
        }
        commentService.addComment(videoId, user.getId(), content);
        Comment newComment = new Comment(videoId, user.getId(), content);

        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setUser(userService.findById(newComment.getUserId()));
        commentDTO.setVideoId(newComment.getVideoId());
        commentDTO.setContent(newComment.getContent());

        response.setHeader("Content-Type", "application/json");
        response.setStatus(200);
        List<CommentDTO> commentDTOList = (List<CommentDTO>) model.getAttribute("commentDTOList");
        commentDTOList.add(commentDTO);
        String data = GSON.toJson(content);
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.write(data);
            out.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (out != null) {
                out.close();
            }
        }

    }
}
