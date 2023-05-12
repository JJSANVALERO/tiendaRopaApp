package com.svalero.appropav2.model;

import android.util.Log;

import com.svalero.appropav2.api.AppRopaApi;
import com.svalero.appropav2.api.AppRopaApiInterface;
import com.svalero.appropav2.contract.ArticulosListContract;
import com.svalero.appropav2.domain.Ropa;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticulosListModel implements ArticulosListContract.Model {

    @Override
    public void loadAllArticulos(ArticulosListContract.Model.OnLoadArticulosListener listener) {
        AppRopaApiInterface appRopaApiInterface = AppRopaApi.buildInstance();
        Call<List<Ropa>> callArticulos = appRopaApiInterface.getArticulos();
        Log.d("Articulos", "LLamada desde model");

        callArticulos.enqueue(new Callback<List<Ropa>>() {
            @Override
            public void onResponse(Call<List<Ropa>> call, Response<List<Ropa>> response) {
                Log.d("Articulos", "LLamada desde model ok");

                List<Ropa> listaRopa = response.body();
                listener.onLoadArticulosSuccess(listaRopa);

            }

            @Override
            public void onFailure(Call<List<Ropa>> call, Throwable t) {
                Log.d("Articulos", "LLamada desde model error");
                t.printStackTrace();

                String message = "Error invocando a la operacion";
                listener.onLoadArticulosError(message);

            }
        });
    }

    @Override
    public Ropa loadArticuloByNombre(String nombre) {
        return null;
    }

    @Override
    public List<Ropa> getAll() {
        return null;
    }

    @Override
    public Ropa getById(long idArticulo) {
        return null;
    }


    @Override
    public void insert(Ropa ropa) {

    }

    @Override
    public boolean deleteArticulo(String nombre) {
        return false;
    }


    @Override
    public void update(Ropa ropa) {

    }
}