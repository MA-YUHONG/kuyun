package com.example.demo.controller;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

import com.example.demo.service.downloadImgService;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.service.okService;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.service.kuyunService;
import org.springframework.stereotype.Controller;

@Controller
public class test {
    @Autowired
    private kuyunService kuyunService;
    @Autowired
    private okService okService;
    @Autowired
    private downloadImgService downloadImgService;

    @RequestMapping({"/index/{start}/{end}"})
    @ResponseBody
    public void index1(@PathVariable("start") final int start, @PathVariable("end") final int end) throws IOException {


        System.out.println("酷云资源");
        try {
            this.kuyunService.start(start, end);
        } catch (IOException e) {
            e.printStackTrace();
        }



        System.out.println("ok资源");
        try {
            this.okService.start(start, end);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping({"/one"})
    @ResponseBody
    public void index1() {
        System.out.println("one");
    }

    private static boolean isTimeRange() throws ParseException {
        final SimpleDateFormat df = new SimpleDateFormat("HH:mm");
        final Date now = df.parse(df.format(new Date()));
        final Date begin = df.parse("4:00");
        final Date end = df.parse("5:00");
        final Calendar nowTime = Calendar.getInstance();
        nowTime.setTime(now);
        final Calendar beginTime = Calendar.getInstance();
        beginTime.setTime(begin);
        final Calendar endTime = Calendar.getInstance();
        endTime.setTime(end);
        return nowTime.before(endTime) && nowTime.after(beginTime);
    }

    @RequestMapping({"/down"})
    @ResponseBody
    public void update(int i ) {

//        downloadImgService.down(i);
    }


}
