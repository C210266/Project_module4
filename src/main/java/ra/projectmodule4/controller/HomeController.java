package ra.projectmodule4.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ra.projectmodule4.dao.impl.CommentDao;
import ra.projectmodule4.dto.request.CommentDTO;
import ra.projectmodule4.dto.request.FormLoginDTO;
import ra.projectmodule4.dto.request.FormRegisterDTO;
import ra.projectmodule4.dto.request.VideoDTO;
import ra.projectmodule4.model.Comment;
import ra.projectmodule4.model.User;
import ra.projectmodule4.model.UserFollow;
import ra.projectmodule4.model.Video;
import ra.projectmodule4.service.impl.UserService;
import ra.projectmodule4.service.impl.VideoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private UserService userService;
    @Autowired
    private VideoService videoService;
    @Autowired
    private CommentDao commentDao;
    private static final Gson GSON = new GsonBuilder().create();


    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login", "login_form", new FormLoginDTO());
    }


    @GetMapping("/register")
    public ModelAndView register() {
        return new ModelAndView("register", "register_form", new FormRegisterDTO());
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return new ModelAndView("redirect:/login");
    }

    @PostMapping("/")
    public String handleLogin(HttpSession session, @ModelAttribute("login_form") FormLoginDTO formLoginDTO, Model model) {
        User user = userService.login(formLoginDTO);
        if (user == null || user.isStatus() == false) {
            model.addAttribute("error","Username or password is wrong");
            return "/login";
        }
        session.setAttribute("userlogin", user);

        if ("admin".equals(user.getUsername()) && "admin".equals(user.getPassword())) {
            return "redirect:/admin";
        }
        // Cập nhật danh sách followings sau khi đăng nhập thành công
        List<User> followings = userService.getFollowingsByUserId(user.getId());
        model.addAttribute("followings", followings);

        return "redirect:/";
    }

    @GetMapping("/")
    public String handleLoginTest(HttpSession session, Model model) {
        List<VideoDTO> allVideos = new ArrayList<>();
        for (User user1 : userService.findAll()) {
            List<VideoDTO> userVideos = videoService.findAllVideoDTOByUserId(user1.getId());
            allVideos.addAll(userVideos);
        }
        model.addAttribute("allVideo", allVideos);

        User user = (User) session.getAttribute("userlogin");
        if (user != null) {
            List<User> followings = userService.getFollowingsByUserId(user.getId());
            model.addAttribute("followings", followings);
        }

        return "index";
    }

    @PostMapping("/handle-register")
    public String handleRegister(HttpSession session, @ModelAttribute("register_form") FormRegisterDTO formRegisterDTO) {
        if (userService.register(formRegisterDTO)) {
            userService.saveRegister(formRegisterDTO);
            return "redirect:/login";
        }
        return "redirect:/register";

    }

    //    Following vaf Follower
    @PostMapping("/follow/{userId}")
    public String followUser(HttpServletResponse response, @PathVariable("userId") Long userId, HttpSession session, Model model) {
        User userLogin = (User) session.getAttribute("userlogin");
        if (userLogin == null) {
            // Handle case when user is not logged in
            return "redirect:/login";
        }

        User userToFollow = userService.findById(userId);
        if (userToFollow != null && !userLogin.equals(userToFollow)) {
            // Check if the follower-following relationship already exists
            boolean relationshipExists = userService.checkRelationshipExists(userLogin.getId(), userToFollow.getId());

            if (!relationshipExists) {
                userService.updateUserFollow(userLogin.getId(), userToFollow.getId(), LocalDateTime.now());
            }
        }

        response.setHeader("Content-Type", "application/json");
        response.setStatus(200);
        String data = GSON.toJson("Thanh cong");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.write(data);
            out.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            out.close();
        }
        return "redirect:/";
    }


//
//    @GetMapping("/")
//    public String home() {
//        return "index";
//    }

    @GetMapping("/home")
    public String home() {
        return "redirect:/";
    }

    @GetMapping("/explorer")
    public String explorer() {
        return "explorer";
    }

    @GetMapping("/followers")
    public String followers() {
        return "followers";
    }

    @GetMapping("/following")
    public String following() {
        return "following";
    }

    @GetMapping("/friends")
    public String friends() {
        return "friends";
    }

    @GetMapping("/favorite")
    public String favorite() {
        return "favorite";
    }

    @GetMapping("/chat")
    public String chat() {
        return "chat";
    }

    @GetMapping("/chat_")
    public String chat_() {
        return "chat_";
    }

    @GetMapping("/faq")
    public String faq() {
        return "faq";
    }

    @GetMapping("/getcoin")
    public String getcoin() {
        return "getcoin";
    }

//    @GetMapping("/myprofile")
//    public String myprofile() {
//        return "myprofile";
//    }

    @GetMapping("/notification")
    public String notification() {
        return "notification";
    }

    @GetMapping("/payment")
    public String payment() {
        return "payment";
    }

    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }

    @GetMapping("/setting")
    public String setting() {
        return "setting";
    }

    @GetMapping("/transaction")
    public String transaction() {
        return "transaction";
    }

    @GetMapping("/comment/{videoId}")
    public String comment(@PathVariable("videoId") int id, Model model) {
        Video video = videoService.findById(id);
        VideoDTO videoDTO = new VideoDTO();
        videoDTO.setId(video.getId());
        videoDTO.setUser(userService.findById(video.getUserId()));
        videoDTO.setTitle(video.getTitle());
        videoDTO.setDescription(video.getDescription());
        videoDTO.setVideoUrlNotFile(video.getVideoUrl());
        videoDTO.setLike(video.getLike());


        List<CommentDTO> comments = new ArrayList<>();

        for (Comment c : commentDao.findAll()) {
            if (c.getVideoId() == id) {
                CommentDTO commentDTO = new CommentDTO();
                commentDTO.setId(c.getId());
                commentDTO.setUser(userService.findById(c.getUserId()));
                commentDTO.setVideoId(c.getVideoId());
                commentDTO.setContent(c.getContent());
                commentDTO.setCreatedAt(c.getCreatedAt());
                comments.add(commentDTO);
            }
        }
        model.addAttribute("commentDTOList", comments);
        System.out.println(comments);
        model.addAttribute("videoDTOInfo", videoDTO);

        CommentDTO commentDTO = new CommentDTO();
        model.addAttribute("newCmtDTO", commentDTO);

        return "comment";
    }


}
