package com.svalero.appropav2.domain;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity
public class Ropa {

    @PrimaryKey(autoGenerate = true)
    private long idRopa;
    @ColumnInfo
    private String nombre;
    @ColumnInfo
    private String code;
    @ColumnInfo
    private String fechaAlta;
    @ColumnInfo
    private double precio;
    @ColumnInfo
    private boolean hayStock;

    public Ropa() {
    }

    public Ropa(String nombre,String code,String fechaAlta, double precio, boolean hayStock) {
        this.nombre = nombre;
        this.code = code;
        this.fechaAlta = fechaAlta;
        this.precio = precio;
        this.hayStock = hayStock;
    }

    public long getIdRopa() {
        return idRopa;
    }

    public void setIdRopa(long idRopa) {
        this.idRopa = idRopa;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isHayStock() {
        return hayStock;
    }

    public void setHayStock(boolean hayStock) {
        this.hayStock = hayStock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
