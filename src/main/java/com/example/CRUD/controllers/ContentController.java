package com.example.CRUD.controllers;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContentController {

  @GetMapping("/home")
  public String handleWelcome() {
    return "home";
  }

  @GetMapping("/admin/home")
  public String handleAdminHome() {
    return "home_admin";
  }

  @GetMapping("/user/home")
  public String handleUserHome() {
    return "home_user";
  }

  @GetMapping("/login")
  public String handleLogin() {
    return "custom_login";
  }

  @GetMapping("/authenticate")
  public String getMethodName() {
      return "home";
  }
}