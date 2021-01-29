package com.example.demo.entity;

public class main {
    private Integer id;

    private String beizhu;

    private String name;

    private String yanyuan;

    private String daoyan;

    private String movietype;

    private String place;

    private String gengxintime;

    private String zhuangtai;

    private String language;

    private String shangyingtime;

    private String juqing;

    private String data;

    private String img;

    private int hot;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBeizhu() {
        return this.beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = (beizhu == null) ? null : beizhu.trim();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = (name == null) ? null : name.trim();
    }

    public String getYanyuan() {
        return this.yanyuan;
    }

    public void setYanyuan(String yanyuan) {
        this.yanyuan = (yanyuan == null) ? null : yanyuan.trim();
    }

    public String getDaoyan() {
        return this.daoyan;
    }

    public void setDaoyan(String daoyan) {
        this.daoyan = (daoyan == null) ? null : daoyan.trim();
    }

    public String getMovietype() {
        return this.movietype;
    }

    public void setMovietype(String movietype) {
        this.movietype = (movietype == null) ? null : movietype.trim();
    }

    public String getPlace() {
        return this.place;
    }

    public void setPlace(String place) {
        this.place = (place == null) ? null : place.trim();
    }

    public String getGengxintime() {
        return this.gengxintime;
    }

    public void setGengxintime(String gengxintime) {
        this.gengxintime = (gengxintime == null) ? null : gengxintime.trim();
    }

    public String getZhuangtai() {
        return this.zhuangtai;
    }

    public void setZhuangtai(String zhuangtai) {
        this.zhuangtai = (zhuangtai == null) ? null : zhuangtai.trim();
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String language) {
        this.language = (language == null) ? null : language.trim();
    }

    public String getShangyingtime() {
        return this.shangyingtime;
    }

    public void setShangyingtime(String shangyingtime) {
        this.shangyingtime = (shangyingtime == null) ? null : shangyingtime.trim();
    }

    public String getJuqing() {
        return this.juqing;
    }

    public void setJuqing(String juqing) {
        this.juqing = (juqing == null) ? null : juqing.trim();
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = (data == null) ? null : data.trim();
    }

    public String getImg() {
        return this.img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getHot() {
        return this.hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }

    public String toString() {
        return "main{id=" + this.id + ", beizhu='" + this.beizhu + '\'' + ", name='" + this.name + '\'' + ", yanyuan='" + this.yanyuan + '\'' + ", daoyan='" + this.daoyan + '\'' + ", movietype='" + this.movietype + '\'' + ", place='" + this.place + '\'' + ", gengxintime='" + this.gengxintime + '\'' + ", zhuangtai='" + this.zhuangtai + '\'' + ", language='" + this.language + '\'' + ", shangyingtime='" + this.shangyingtime + '\'' + ", juqing='" + this.juqing + '\'' + ", data='" + this.data + '\'' + ", img='" + this.img + '\'' + ", hot=" + this.hot + '}';
    }
}