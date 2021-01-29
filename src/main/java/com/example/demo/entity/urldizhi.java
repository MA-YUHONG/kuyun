package com.example.demo.entity;

public class urldizhi {
    private Integer id;

    private String urlid;

    private String urlBeizhu;

    private String url;

    private String xiazaiBeizhu;

    private String xiazaiurl;

    public String toString() {
        return "urldizhi{id=" + this.id + ", urlid='" + this.urlid + '\'' + ", urlBeizhu='" + this.urlBeizhu + '\'' + ", url='" + this.url + '\'' + ", xiazaiBeizhu='" + this.xiazaiBeizhu + '\'' + ", xiazaiurl='" + this.xiazaiurl + '\'' + '}';
    }

    public String getXiazaiBeizhu() {
        return this.xiazaiBeizhu;
    }

    public void setXiazaiBeizhu(String xiazaiBeizhu) {
        this.xiazaiBeizhu = xiazaiBeizhu;
    }

    public String getUrlBeizhu() {
        return this.urlBeizhu;
    }

    public void setUrlBeizhu(String urlBeizhu) {
        this.urlBeizhu = urlBeizhu;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrlid() {
        return this.urlid;
    }

    public void setUrlid(String urlid) {
        this.urlid = urlid;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = (url == null) ? null : url.trim();
    }

    public String getXiazaiurl() {
        return this.xiazaiurl;
    }

    public void setXiazaiurl(String xiazaiurl) {
        this.xiazaiurl = (xiazaiurl == null) ? null : xiazaiurl.trim();
    }
}
