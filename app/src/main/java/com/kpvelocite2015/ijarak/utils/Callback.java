package com.kpvelocite2015.ijarak.utils;

import com.kpvelocite2015.ijarak.model.WebServiceResponse;

import retrofit.client.Response;

public abstract class Callback<T> implements retrofit.Callback<WebServiceResponse<T>> {

    public abstract void success(T t);
    public abstract void failure(WebServiceResponse error);

    @Override
    public void success(WebServiceResponse<T> tWebServiceResponse, Response response) {
        if (tWebServiceResponse.getStatusCode() == 200) {
            success(tWebServiceResponse.getResult());
        } else {
            failure(tWebServiceResponse);
        }
    }
}