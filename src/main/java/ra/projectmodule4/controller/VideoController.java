package ra.projectmodule4.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ra.projectmodule4.dto.request.VideoDTO;
import ra.projectmodule4.model.User;
import ra.projectmodule4.model.Video;
import ra.projectmodule4.service.impl.VideoService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
@PropertySource("classpath:upload.properties")
public class VideoController {
    private static final Gson GSON = new GsonBuilder().create();
    @Autowired
    private VideoService videoService;
    @Value("${upload-path}")
    private String pathUpload;

    @GetMapping("/upload")
    public ModelAndView formUpload() {
        return new ModelAndView("upload", "uploadFile", new Video());
    }

    @GetMapping("/myprofile")
    public ModelAndView listVideo(HttpSession session, Model model) {
        User user = (User) session.getAttribute("userlogin");
        ModelAndView modelAndView;

        if (user == null) {
            modelAndView = new ModelAndView("myprofile");
            modelAndView.addObject("userloginWarning", "Chưa đăng nhập userlogin");
        } else {
            modelAndView = new ModelAndView("myprofile");
            List<Video> videos = videoService.findAllByUserId(user.getId());

            if (videos != null) {
                modelAndView.addObject("list", videos);
            }

            int videoCount = videoService.countVideoByUserId(user.getId());
            model.addAttribute("videoCount", videoCount);
        }

        return modelAndView;
    }

    @PostMapping("/upload")
    public String doUpload(@ModelAttribute("uploadFile") VideoDTO videoDTO, Model model, HttpSession session) {
        File file = new File(pathUpload);
        if (!file.exists()) {
            file.mkdirs();
        }
        String fileName = videoDTO.getVideoUrl().getOriginalFilename();
        try {
            FileCopyUtils.copy(videoDTO.getVideoUrl().getBytes(), new File(pathUpload + fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        Nhận về userlogin
        User user = (User) session.getAttribute("userlogin");
        Video newVideo = new Video();
        newVideo.setVideoUrl(fileName);
        newVideo.setTitle(videoDTO.getTitle());
        newVideo.setDescription(videoDTO.getDescription());
        newVideo.setUserId(user.getId());

        videoService.save(newVideo);
        return "redirect:/";
    }

    @GetMapping("/video/likeAdd/{videoId}")
    public void likeAdd(HttpServletResponse response, @PathVariable("videoId") int id, HttpSession session) {
//        Video v = videoService.findById(id);
        videoService.addLike(id);
        int newLikeCount = videoService.getLikeCount(id);
        response.setHeader("Content-Type", "application/json");
        response.setStatus(200);
        String data = GSON.toJson(newLikeCount);
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
    }

    @GetMapping("/video/decreareLike/{videoId}")
    public void decreareLike(HttpServletResponse response, @PathVariable("videoId") int id, HttpSession session) {
//        Video v = videoService.findById(id);
        videoService.decreareLike(id);
        int newLikeCount = videoService.getLikeCount(id);
        response.setHeader("Content-Type", "application/json");
        response.setStatus(200);
        String data = GSON.toJson(newLikeCount);
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
    }
}
