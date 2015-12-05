package com.kpvelocite2015.ijarak.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Laporan {

    private String idMarker;

    @Expose
    private Integer id;
    @Expose
    private Double latitude;
    @Expose
    private Double longitude;
    @Expose
    private String status;
    @SerializedName("detail_lokasi")
    @Expose
    private String detailLokasi;
    @Expose
    private String level;
    @Expose
    private String foto1;
    @Expose
    private String foto2;
    @Expose
    private String foto3;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("id_users")
    @Expose
    private Integer idUsers;

    /**
     *
     * @return
     * The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The latitude
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     *
     * @param latitude
     * The latitude
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    /**
     *
     * @return
     * The longitude
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     *
     * @param longitude
     * The longitude
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    /**
     *
     * @return
     * The status
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     * The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @return
     * The detailLokasi
     */
    public String getDetailLokasi() {
        return detailLokasi;
    }

    /**
     *
     * @param detailLokasi
     * The detail_lokasi
     */
    public void setDetailLokasi(String detailLokasi) {
        this.detailLokasi = detailLokasi;
    }

    /**
     *
     * @return
     * The level
     */
    public String getLevel() {
        return level;
    }

    /**
     *
     * @param level
     * The level
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     *
     * @return
     * The foto1
     */
    public String getFoto1() {
        return foto1;
    }

    /**
     *
     * @param foto1
     * The foto1
     */
    public void setFoto1(String foto1) {
        this.foto1 = foto1;
    }

    /**
     *
     * @return
     * The foto2
     */
    public String getFoto2() {
        return foto2;
    }

    /**
     *
     * @param foto2
     * The foto2
     */
    public void setFoto2(String foto2) {
        this.foto2 = foto2;
    }

    /**
     *
     * @return
     * The foto3
     */
    public String getFoto3() {
        return foto3;
    }

    /**
     *
     * @param foto3
     * The foto3
     */
    public void setFoto3(String foto3) {
        this.foto3 = foto3;
    }

    /**
     *
     * @return
     * The createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     *
     * @param createdAt
     * The created_at
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     *
     * @return
     * The updatedAt
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     *
     * @param updatedAt
     * The updated_at
     */
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     *
     * @return
     * The idUsers
     */
    public Integer getIdUsers() {
        return idUsers;
    }

    /**
     *
     * @param idUsers
     * The id_users
     */
    public void setIdUsers(Integer idUsers) {
        this.idUsers = idUsers;
    }

    public String getIdMarker() {
        return idMarker;
    }

    public void setIdMarker(String idMarker) {
        this.idMarker = idMarker;
    }
}