package ra.projectmodule4.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.projectmodule4.dto.request.VideoDTO;
import ra.projectmodule4.model.User;
import ra.projectmodule4.model.Video;
import ra.projectmodule4.service.impl.UserService;
import ra.projectmodule4.service.impl.VideoService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private VideoService videoService;

    private static final Gson GSON = new GsonBuilder().create();

    @GetMapping("/user")
    public String admin(HttpSession session, Model model) {
        List<User> userList = userService.findAll();
        System.out.println(userList);// Lấy danh sách người dùng từ service
        model.addAttribute("userList", userList);
        return "admin/user";
    }


    @GetMapping("/video")
    public String video(HttpSession session, Model model) {
        List<VideoDTO> allVideos = new ArrayList<>();
        for (User user1 : userService.findAll()) {
            List<VideoDTO> userVideos = videoService.findAllVideoDTOByUserId(user1.getId());
            allVideos.addAll(userVideos);
        }
        model.addAttribute("allVideos", allVideos);

        VideoDTO videoDTO = new VideoDTO();
        model.addAttribute("videoDTO", videoDTO);
        return "admin/video";
    }

    @GetMapping("/admin")
    public String adminDashboard(HttpSession session, Model model) {
//        User user = (User) session.getAttribute("userlogin");
//        if (user == null || !("admin".equals(user.getUsername()) && "admin".equals(user.getPassword()))) {
//            return "redirect:/";
//        }
//
//        // Xử lý cho trang dashboard của admin

        return "admin/index";
    }

    @GetMapping("/video/delete/{videoId}")
    public String deleteVideo(@PathVariable("videoId") int videoId, HttpServletResponse response) {
        videoService.delete(videoId);
        return "redirect:/video";
    }

    @GetMapping("/unlock_acc/{id}")
    public String unlockAcc(@PathVariable("id") Long userId){
        userService.updateStatusAcc(userId,true);
        return "redirect:/user";
    }
    @GetMapping("/block_acc/{id}")
    public String blockAcc(@PathVariable("id") Long userId){
        userService.updateStatusAcc(userId,false);
        return "redirect:/user";
    }
}
