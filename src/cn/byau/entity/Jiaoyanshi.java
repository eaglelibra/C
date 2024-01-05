package cn.byau.entity;


public class Jiaoyanshi {



    private  Integer id;

    private  String jysdh; //教研室代号


     private  String jysmc;//教研室名称
    private  String kch;//课程号

    private  String xydh;//学院代号

    private  String zydh; //专业代号

    private  String jyskindId;//关联分类表
    private JysKind jysKind;


    public Jiaoyanshi() {

    }

    public Jiaoyanshi(Integer id, String jysdh, String jysmc, String kch, String xydh, String zydh, String jyskindId, JysKind jysKind) {
        this.id = id;
        this.jysdh = jysdh;
        this.jysmc = jysmc;
        this.kch = kch;
        this.xydh = xydh;
        this.zydh = zydh;
        this.jyskindId = jyskindId;
        this.jysKind = jysKind;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJysdh() {
        return jysdh;
    }

    public void setJysdh(String jysdh) {
        this.jysdh = jysdh;
    }

    public String getJysmc() {
        return jysmc;
    }

    public void setJysmc(String jysmc) {
        this.jysmc = jysmc;
    }

    public String getKch() {
        return kch;
    }

    public void setKch(String kch) {
        this.kch = kch;
    }

    public String getXydh() {
        return xydh;
    }

    public void setXydh(String xydh) {
        this.xydh = xydh;
    }

    public String getZydh() {
        return zydh;
    }

    public void setZydh(String zydh) {
        this.zydh = zydh;
    }

    public String getJyskindId() {
        return jyskindId;
    }

    public void setJyskindId(String jyskindId) {
        this.jyskindId = jyskindId;
    }

    public JysKind getJysKind() {
        return jysKind;
    }

    public void setJysKind(JysKind jysKind) {
        this.jysKind = jysKind;
    }
}
