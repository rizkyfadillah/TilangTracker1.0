package com.kpvelocite2015.ijarak.model;

import com.google.gson.annotations.Expose;

public class Register {

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