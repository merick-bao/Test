package com.example.pc.test;

/**
 * Created by pc on 2016/12/18.
 */

public class Use_Star {
    //用户之星
    private String use_star_name;
    private String use_star_head;
    private String use_star_introduce;
    private int use_star_sexid;
    private String use_star_score;

    public Use_Star(String use_star_name, String use_star_head, String use_star_introduce,int use_star_sexid,String use_star_score){
        this.use_star_head = use_star_head;
        this.use_star_name = use_star_name;
        this.use_star_introduce = use_star_introduce;
        this.use_star_sexid = use_star_sexid;
        this.use_star_score = use_star_score;
    }


    public String getUse_star_name() {
        return use_star_name;
    }

    public String getUse_star_head() {
        return use_star_head;
    }

    public String getUse_star_introduce() {
        return use_star_introduce;
    }

    public int getUse_star_sexid() {
        return use_star_sexid;
    }

    public String getUse_star_score() {
        return use_star_score;
    }
}
