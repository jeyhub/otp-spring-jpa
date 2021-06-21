package com.egov.otp.example.repository;

import com.egov.otp.example.entity.ProcessOtp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OtpRepository extends JpaRepository<ProcessOtp,Integer> {

}
