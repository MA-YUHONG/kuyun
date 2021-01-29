package com.example.demo.core;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
@Component
public class autoJob {
//@Scheduled(fixedDelay = 5000,initialDelay = 0)
   public void downloadImg(){

    Date date=new Date();
    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("HH:mm:ss");
    System.out.println(simpleDateFormat.format(date));
    }
}
