package cn.byau.entity;


/**
 * 教研分类表
 */
public class JysKind {


    private  Integer id;

    private  String kindId;// 分类编号

    private  String kindName;  //分类名

    private  String kindRemark;//附件说明
    public JysKind() {

    }

    public JysKind(Integer id, String kindId, String kindName, String kindRemark) {
        this.id = id;
        this.kindId = kindId;
        this.kindName = kindName;
        this.kindRemark = kindRemark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKindId() {
        return kindId;
    }

    public void setKindId(String kindId) {
        this.kindId = kindId;
    }

    public String getKindName() {
        return kindName;
    }

    public void setKindName(String kindName) {
        this.kindName = kindName;
    }

    public String getKindRemark() {
        return kindRemark;
    }

    public void setKindRemark(String kindRemark) {
        this.kindRemark = kindRemark;
    }
}
