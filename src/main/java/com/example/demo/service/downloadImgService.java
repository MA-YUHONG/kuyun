package com.example.demo.service;

import com.example.demo.dao.mainMapper;
import com.example.demo.entity.main;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

@Service
public class downloadImgService {
    @Resource
    private mainMapper mainMapper;



    @Scheduled(fixedDelay = 10000)
    public void download() {
        List<main> list = mainMapper.selectNow();
        for (int i = 0; i < list.size(); i++) {
            try {
                if (!list.get(i).getImg().contains("toyishan")) {

                    downloadPicture(list.get(i).getImg(), list.get(i).getId());
                    updateImg(list.get(i).getId());
                }
            } catch (Exception e) {
                System.out.print("1");
            }
        }
        System.out.println("");
    }


    public void updateImg(int id) {

        mainMapper.updateImg(id);
    }


    public static void downloadPicture(String urlString, int id) throws Exception {
        String filename = "D:\\movie\\movie\\" + id + ".png";  //下载路径及下载图片名称
        URL url = null;
        String urls = urlString;
        try {
            url = new URL(urls);
            URLConnection connection = url.openConnection();
            connection.setConnectTimeout(3000);
            connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            InputStream inputStream = connection.getInputStream();
            FileOutputStream fileOutputStream = new FileOutputStream(new File(filename));
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0)
                output.write(buffer, 0, length);
            fileOutputStream.write(output.toByteArray());
            inputStream.close();
            fileOutputStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
