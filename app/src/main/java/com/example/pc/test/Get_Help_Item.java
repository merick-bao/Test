package com.example.pc.test;

/**
 * Created by pc on 2017/3/8.
 */

public class Get_Help_Item {
    private String get_help_describe;
    private String getGet_help_reward;
    private String get_help_time;

    public Get_Help_Item(String get_help_describe, String getGet_help_reward, String get_help_time) {
        this.get_help_describe = get_help_describe;
        this.getGet_help_reward = getGet_help_reward;
        this.get_help_time = get_help_time;
    }

    public String getGet_help_describe() {
        return get_help_describe;
    }

    public void setGet_help_describe(String get_help_describe) {
        this.get_help_describe = get_help_describe;
    }

    public String getGetGet_help_reward() {
        return getGet_help_reward;
    }

    public void setGetGet_help_reward(String getGet_help_reward) {
        this.getGet_help_reward = getGet_help_reward;
    }

    public String getGet_help_time() {
        return get_help_time;
    }

    public void setGet_help_time(String get_help_time) {
        this.get_help_time = get_help_time;
    }
}
