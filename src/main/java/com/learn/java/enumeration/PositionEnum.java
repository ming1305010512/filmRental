package com.learn.java.enumeration;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2019/1/10
 * @Time:11:54
 */
public enum PositionEnum {
    //演播部
    YBB_MANAGER("YBB_MANAGER"),YBB_ASMANAGER("YBB_ASMANAGER"),
    //调度部
    DDB_MANAGER("DDB_MANAGER"),DDB_ASMANAGER("DDB_ASMANAGER"),
    //制片部
    ZPB_MANAGER("ZPB_MANAGER"),ZPB_ASMANAGER("ZPB_ASMANAGER"),
    //导摄部
    DSB_MANAGER("DSB_MANAGER"),DSB_ASMANAGER("DSB_ASMANAGER"),
    //综合部
    ZHB_MANAGER("ZHB_MANAGER"),ZHB__ASMANAGER("ZHB__ASMANAGER"),
    //演艺部
    YYB_MANAGER("YYB_MANAGER"),YYB_ASMANAGER("YYB_ASMANAGER"),
    //内容部
    NRB__MANAGER("NRB__MANAGER"),NRB__ASMANAGER("NRB__ASMANAGER"),
    //服化部
    FHB_MANAGER("FHB_MANAGER"),FHB_ASMANAGER("FHB_ASMANAGER");

    private String value;

    private PositionEnum(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
