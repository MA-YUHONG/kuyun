package com.example.demo.service;

import com.example.demo.entity.webs;

import java.util.List;

import com.example.demo.tool.tools;

import java.util.ArrayList;

import com.example.demo.entity.main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.IOException;

import okhttp3.Response;
import okhttp3.RequestBody;
import okhttp3.Request;
import okhttp3.OkHttpClient;
import com.example.demo.dao.websMapper;
import com.example.demo.dao.urldizhiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.dao.mainMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class kuyunService {
    @Autowired
    private mainMapper mainMapper;
    @Autowired
    private urldizhiMapper urldizhiMapper;
    @Autowired
    private websMapper websMapper;
    static OkHttpClient clients;


    public kuyunService() {
        super();
    }

    public static String Get(final String url) throws IOException {
        final Request request = new Request.Builder().url(url).method("GET", (RequestBody) null).addHeader("Cookie", "ASPSESSIONIDQSCBBBRC=LGEOKLIADNKDFNBFIAFAJFNF; __tins__19534235=%7B%22sid%22%3A%201604397224794%2C%20%22vd%22%3A%201%2C%20%22expires%22%3A%201604399024794%7D; __51cke__=; __51laig__=1").build();
        String info;
        try {
            final Response response = kuyunService.clients.newCall(request).execute();
            final byte[] b = response.body().bytes();
            info = new String(b, "gbk");
        } catch (Exception e) {
            System.out.print("x");
            Get(url);
            return null;
        }
        return info;
    }

    public void start(final int start, final int end) throws IOException {
        final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final String startime = df.format(new Date());
        System.out.println("开始时间" + startime);
        for (int i = start; i <= end; ++i) {
            String url = "http://www.kuyunzy1.com/list/?0-" + i + ".html";
            String ret = Get(url);
            if (ret == null) {
                System.out.print("x");
                url = "http://www.kuyunzy1.com/list/?0-" + i + ".html";
                ret = Get(url);
            }
            final Pattern pattern = Pattern.compile("align=\"left\"><a href=\"(.*?)html");
            Matcher matcher = null;
            try {
                matcher = pattern.matcher(ret);
            } catch (Exception e) {
                System.out.print("x");
                url = "http://www.kuyunzy1.com/list/?0-" + i + ".html";
                ret = Get(url);
            }
            while (matcher.find()) {
                final String url2 = "http://www.kuyunzy1.com" + matcher.group().substring(22);
                this.godown(url2);
            }
            System.out.println(i + "页完毕");
        }
        System.out.println("结束时间" + df.format(new Date()));
    }

    public void godown(final String url) throws IOException {
        final main main = new main();
        final List<String> m3u8list = new ArrayList<String>();
        final List<String> mp4list = new ArrayList<String>();
        String ret;
        for (ret = Get(url); ret == null; ret = Get(url)) {
            System.out.println("x");
        }
        final Pattern pattern1 = Pattern.compile("<!--影片名称开始代码-->(.*?)<!--影片名称结束代码-->");
        final Matcher matcher1 = pattern1.matcher(ret);
        if (matcher1.find()) {
            main.setName(matcher1.group().substring(15, matcher1.group().length() - 15));
        }
        final Pattern pattern2 = Pattern.compile("<!--影片备注开始代码-->(.*?)<!--影片备注结束代码-->");
        final Matcher matcher2 = pattern2.matcher(ret);
        if (matcher2.find()) {
            main.setBeizhu(matcher2.group().substring(15, matcher2.group().length() - 15));
        }
        final Pattern pattern3 = Pattern.compile("<!--影片演员开始代码-->(.*?)<!--影片演员结束代码-->");
        final Matcher matcher3 = pattern3.matcher(ret);
        if (matcher3.find()) {
            main.setYanyuan(matcher3.group().substring(15, matcher3.group().length() - 15));
        }
        final Pattern pattern4 = Pattern.compile("searchword=(.*?)</a> ");
        final Matcher matcher4 = pattern4.matcher(ret);
        if (matcher4.find()) {
            final String group4 = matcher4.group();
            final String[] split4 = group4.split(">");
            main.setDaoyan(split4[1].substring(0, split4[1].length() - 3));
        }
        final Pattern pattern5 = Pattern.compile("<!--影片类型开始代码-->(.*?)<!--影片类型结束代码-->");
        final Matcher matcher5 = pattern5.matcher(ret);
        if (matcher5.find()) {
            main.setMovietype(matcher5.group().substring(15, matcher5.group().length() - 15));
        }
        final Pattern pattern6 = Pattern.compile("<!--影片地区开始代码-->(.*?)<!--影片地区结束代码-->");
        final Matcher matcher6 = pattern6.matcher(ret);
        if (matcher6.find()) {
            main.setPlace(matcher6.group().substring(15, matcher6.group().length() - 15));
        }
        final Pattern pattern7 = Pattern.compile("<!--影片更新时间开始代码-->(.*?)<!--影片更新时间结束代码-->");
        final Matcher matcher7 = pattern7.matcher(ret);
        if (matcher7.find()) {
            final String temp = matcher7.group().substring(17, matcher7.group().length() - 17);
            main.setGengxintime(tools.checktime(temp));
        }
        final Pattern pattern8 = Pattern.compile("<!--影片状态开始代码-->(.*?)<!--影片状态结束代码-->");
        final Matcher matcher8 = pattern8.matcher(ret);
        if (matcher8.find()) {
            main.setZhuangtai(matcher8.group().substring(15, matcher8.group().length() - 15));
        }
        final Pattern pattern9 = Pattern.compile("<!--影片语言开始代码-->(.*?)<!--影片语言结束代码-->");
        final Matcher matcher9 = pattern9.matcher(ret);
        if (matcher9.find()) {
            main.setLanguage(matcher9.group().substring(15, matcher9.group().length() - 15));
        }
        final Pattern pattern10 = Pattern.compile("<!--上映日期开始代码-->(.*?)<!--上映日期结束代码-->");
        final Matcher matcher10 = pattern10.matcher(ret);
        if (matcher10.find()) {
            main.setShangyingtime(matcher10.group().substring(15, matcher10.group().length() - 15));
        }
        final Pattern pattern11 = Pattern.compile("<!--影片介绍开始代码-->(.*?)<!--影片介绍结束代码-->");
        final Matcher matcher11 = pattern11.matcher(ret);
        if (matcher11.find()) {
            String temp2 = matcher11.group().substring(15, matcher11.group().length() - 15);
            if (temp2.length() > 2000) {
                temp2 = temp2.substring(0, 2000);
            }
            main.setJuqing(temp2);
        }
        final Pattern pattern12 = Pattern.compile("<!--影片图片开始代码-->(.*?)<!--影片图片结束代码-->");
        final Matcher matcher12 = pattern12.matcher(ret);
        if (matcher12.find()) {
            main.setImg(matcher12.group().substring(15, matcher12.group().length() - 15));
        }
        main.setHot((int) (1.0 + Math.random() * 29501.0));
        final Pattern pattern13 = Pattern.compile("<a>(.*?).m3u8</a>");
        final Matcher matcher13 = pattern13.matcher(ret);
        while (matcher13.find()) {
            String temp3 = matcher13.group();
            if (temp3.length() > 200) {
                temp3 = temp3.substring(0, 200);
            }
            m3u8list.add(temp3.substring(3, temp3.length() - 4));
        }
        final Pattern pattern14 = Pattern.compile("<a>(.*?).mp4</a>");
        final Matcher matcher14 = pattern14.matcher(ret);
        while (matcher14.find()) {
            String temp4 = matcher14.group();
            if (temp4.length() > 200) {
                temp4 = temp4.substring(0, 200);
            }
            mp4list.add(temp4.substring(3, temp4.length() - 4));
        }
        this.isExits(main, m3u8list, mp4list);
    }

    public void isExits(final main main, final List<String> m3u8List, final List<String> mp4List) {
        final String temps = main.getName();
        final main exist = this.mainMapper.isExist(temps);
        if (exist == null) {
            final Date date = new Date();
            final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            final String data = formatter.format(date);
            final int retnum = this.mainMapper.addMain(main.getName(), main.getBeizhu(), main.getImg(), main.getYanyuan(), main.getDaoyan(), main.getMovietype(), main.getPlace(), main.getGengxintime(), main.getZhuangtai(), main.getLanguage(), main.getShangyingtime(), main.getJuqing(), data, main.getHot());
            if (retnum == 0) {
                System.out.println("添加失败" + main.toString());
                return;
            }
            final int retid = this.mainMapper.selectId(main.getName());
            final String current = String.valueOf(System.currentTimeMillis());
            final int retnum2 = this.websMapper.addWeb(retid, "酷云", current);
            if (retnum2 > 0) {
                if (m3u8List.size() >= mp4List.size()) {
                    for (int i = 0; i < m3u8List.size(); ++i) {
                        String tempmp4 = "null$null";
                        if (i < mp4List.size()) {
                            tempmp4 = mp4List.get(i);
                        }
                        final String[] m3u8sp = m3u8List.get(i).split("\\$");
                        final String[] mp4sp = tempmp4.split("\\$");
                        this.urldizhiMapper.addUrdizhi(current, m3u8sp[0], m3u8sp[1], mp4sp[0], mp4sp[1]);
                    }
                }
                if (m3u8List.size() < mp4List.size()) {
                    for (int i = 0; i < mp4List.size(); ++i) {
                        String tempm3u8 = "null$null";
                        if (i < m3u8List.size()) {
                            tempm3u8 = m3u8List.get(i);
                        }
                        final String[] mp4sp2 = mp4List.get(i).split("\\$");
                        final String[] m3u8sp2 = tempm3u8.split("\\$");
                        this.urldizhiMapper.addUrdizhi(current, m3u8sp2[0], m3u8sp2[1], mp4sp2[0], mp4sp2[1]);
                    }
                }
            }
            System.out.print("-");
        } else {
            final int retid2 = this.mainMapper.selectId(main.getName());
            final webs webs = this.websMapper.select(Integer.valueOf(retid2), "酷云");
            if (webs == null) {
                final int mainid = this.mainMapper.selectId(main.getName());
                final String current2 = String.valueOf(System.currentTimeMillis());
                final int retnum3 = this.websMapper.addWeb(mainid, "酷云", current2);
                if (retnum3 > 0) {
                    if (m3u8List.size() >= mp4List.size()) {
                        for (int j = 0; j < m3u8List.size(); ++j) {
                            String tempmp5 = "null$null";
                            if (j < mp4List.size()) {
                                tempmp5 = mp4List.get(j);
                            }
                            final String[] m3u8sp3 = m3u8List.get(j).split("\\$");
                            final String[] mp4sp3 = tempmp5.split("\\$");
                            this.urldizhiMapper.addUrdizhi(current2, m3u8sp3[0], m3u8sp3[1], mp4sp3[0], mp4sp3[1]);
                        }
                    }
                    if (m3u8List.size() < mp4List.size()) {
                        for (int j = 0; j < mp4List.size(); ++j) {
                            String tempm3u9 = "null$null";
                            if (j < m3u8List.size()) {
                                tempm3u9 = m3u8List.get(j);
                            }
                            final String[] mp4sp4 = mp4List.get(j).split("\\$");
                            final String[] m3u8sp4 = tempm3u9.split("\\$");
                            this.urldizhiMapper.addUrdizhi(current2, m3u8sp4[0], m3u8sp4[1], mp4sp4[0], mp4sp4[1]);
                        }
                    }
                }
                System.out.print("-");
            } else {
                final int retnum4 = this.urldizhiMapper.delteUrlid(webs.getUrlid());
                if (m3u8List.size() >= mp4List.size()) {
                    for (int k = 0; k < m3u8List.size(); ++k) {
                        String tempmp6 = "null$null";
                        if (k < mp4List.size()) {
                            tempmp6 = mp4List.get(k);
                        }
                        final String[] m3u8sp5 = m3u8List.get(k).split("\\$");
                        final String[] mp4sp5 = tempmp6.split("\\$");
                        this.urldizhiMapper.addUrdizhi(webs.getUrlid(), m3u8sp5[0], m3u8sp5[1], mp4sp5[0], mp4sp5[1]);
                    }
                }
                if (m3u8List.size() < mp4List.size()) {
                    for (int k = 0; k < mp4List.size(); ++k) {
                        String tempm3u10 = "null$null";
                        if (k < m3u8List.size()) {
                            tempm3u10 = m3u8List.get(k);
                        }
                        final String[] mp4sp6 = mp4List.get(k).split("\\$");
                        final String[] m3u8sp6 = tempm3u10.split("\\$");
                        this.urldizhiMapper.addUrdizhi(webs.getUrlid(), m3u8sp6[0], m3u8sp6[1], mp4sp6[0], mp4sp6[1]);
                    }
                }
                System.out.print("-");
            }
        }
    }

    static {
        kuyunService.clients = new OkHttpClient();
    }
}
