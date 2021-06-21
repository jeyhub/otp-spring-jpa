package com.egov.otp.example.controller;

import com.egov.otp.example.entity.ProcessOtp;
import com.egov.otp.example.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OtpController {

    @Autowired
    private OtpService otpService;

    @PostMapping("/addOtp")
    public ProcessOtp addOtp(@RequestBody ProcessOtp processOtp){
        return otpService.saveOtp(processOtp);
    }

    @GetMapping("/otp")
    public ProcessOtp otp(){
        ProcessOtp pr = new ProcessOtp();
        pr.setOtp("45646546");
        return pr;
    }
//    @PostMapping("/addOtps")
//    public List<ProcessOtp> addOtps(@RequestBody List<ProcessOtp> processOtpList){
//        return otpService.saveAllOtps(processOtpList);
//    }

    @GetMapping("/otps")
    public List<ProcessOtp> findAllOtps(){
        return otpService.getOtps();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteOtp(@PathVariable int id){
        return otpService.deleteOtp(id);
    }
}