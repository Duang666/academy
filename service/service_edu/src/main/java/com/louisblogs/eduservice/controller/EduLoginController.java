package com.louisblogs.eduservice.controller;

import com.louisblogs.commonutils.R;
import org.springframework.web.bind.annotation.*;

/**
 * @description：登录 前端控制器
 * @author     ：luqi
 * @date       ：2021/4/3 17:45
 */

@RestController
@RequestMapping("/eduservice/user")
//@CrossOrigin // 解决跨域问题
public class EduLoginController {

  // login
  @PostMapping("login")
  public R login() {
    return R.ok().data("token", "admin");
  }

  // info
  @GetMapping("info")
  public R info() {
    return R.ok()
        .data("roles", "[admin]")
        .data("name", "[name]")
        .data(
            "avatar",
            "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3691038151,4046555315&fm=26&gp=0.jpg");
  }
}
