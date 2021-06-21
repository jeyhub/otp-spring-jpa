package com.egov.otp.example.service;

import com.egov.otp.example.entity.ProcessOtp;
import com.egov.otp.example.repository.OtpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class OtpService {

    @Autowired
    private OtpRepository otpRepository;

    public ProcessOtp saveOtp(ProcessOtp processOtp){
        processOtp.setOtp(String.valueOf(otpSender(6)));
        return otpRepository.save(processOtp);
    }

//    public List<ProcessOtp> saveAllOtps(List<ProcessOtp> processOtpList){
//        return otpRepository.saveAll(processOtpList);
//    }

    public List<ProcessOtp> getOtps() {
        return otpRepository.findAll();
    }

    public String deleteOtp(int id) {
        otpRepository.deleteById(id);

        return "ID=" + id +  " OTP has been removed";
    }

    public static char[] otpSender(int length){
        char[] otp = new char[length];
        String nums = "0123456789";
        Random rand = new Random();

        for (int i = 0; i < length; i++) {
            otp[i] = nums.charAt(rand.nextInt(nums.length()));
        }
        return otp;
    }
}