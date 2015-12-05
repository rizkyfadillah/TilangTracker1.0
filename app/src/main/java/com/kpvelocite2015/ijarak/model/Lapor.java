package com.kpvelocite2015.ijarak.model;

import com.google.gson.annotations.Expose;

/**
 * Created by hallidafykzir on 8/31/2015.
 */
public class Lapor {

    @Expose
    private Integer success;

    /**
     *
     * @return
     * The success
     */
    public Integer getSuccess() {
        return success;
    }

    /**
     *
     * @param success
     * The success
     */
    public void setSuccess(Integer success) {
        this.success = success;
    }
}
