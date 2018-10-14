package com.ouyang.think_in_java4;

public enum MyTime {
    WORK_DAY("工作日") {
        @Override
        String doWhat() {
            return "work and study";
        }
    },
    WEEKEND("周末") {
        @Override
        String doWhat() {
            return "sleep and play";
        }
    }
    ;
    private String desc;
    private MyTime(String desc){
        this.desc = desc;
    }
    abstract String doWhat();

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
