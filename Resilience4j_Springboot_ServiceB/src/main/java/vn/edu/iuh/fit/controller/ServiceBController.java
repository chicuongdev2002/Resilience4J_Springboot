package vn.edu.iuh.fit.controller;import org.springframework.web.bind.annotation.GetMapping;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RestController;@RestController@RequestMapping("/b")public class ServiceBController {    @GetMapping    public String hello() {        return "Gọi từ service B";    }}