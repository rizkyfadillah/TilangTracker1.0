package com.kpvelocite2015.ijarak.api;

import com.kpvelocite2015.ijarak.model.Lapor;
import com.kpvelocite2015.ijarak.model.Laporan;
import com.kpvelocite2015.ijarak.model.Login;
import com.kpvelocite2015.ijarak.model.Register;
import com.kpvelocite2015.ijarak.model.User;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;
import retrofit.http.Path;
import retrofit.mime.TypedFile;

/**
 * Created by hallidafykzir on 7/1/2015.
 */
public class WebServiceHelper {

    private static final String API_ENDPOINT_LOCALHOST = "http://10.0.2.2/laundrybar/public";
    private static WebServiceHelper instance;

    private Services services;

    public static WebServiceHelper getInstance() {
        if (instance == null) instance = new WebServiceHelper();
        return instance;
    }

    private WebServiceHelper(){
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(API_ENDPOINT_LOCALHOST).build();
        services = restAdapter.create(Services.class);
    }

    public Services getServices() {
        return services;
    }

    public interface Services{

        @GET("/getuser/{id}")
        void getUserByIdLocalhost(@Path("id") int id, Callback<User> callback);

        @GET("/laporann")
        void getAllLaporanLocalhost(Callback<List<Laporan>> callback);

        @GET("/getLaporanUser/{id}")
        void getLaporanById(@Path("id") int id, Callback<List<Laporan>> callback);

        @FormUrlEncoded
        @POST("user/daftar")
        void createUser(@Field("name") String name, @Field("lokasi") String lokasi, @Field("no_hp") String no_hp, @Field("password") String password, @Field("password_confirm") String password_confirm, Callback<Register> callback);

        @Multipart
        @POST("/postlaporan")
        void createLaporan(@Part("latitude") double latitude, @Part("longitude") double longitude, @Part("detail_lokasi") String alamat,
                           @Part("level") String level, @Part("foto1") TypedFile foto1, @Part("foto2") TypedFile foto2,
                           @Part("foto3") TypedFile foto3, @Part("id_users") int id_users , Callback<Lapor> callback);

        @Multipart
        @POST("/loginn")
        void login(@Part("email") String email, @Part("password") String password, Callback<Login> callback);
    }

}