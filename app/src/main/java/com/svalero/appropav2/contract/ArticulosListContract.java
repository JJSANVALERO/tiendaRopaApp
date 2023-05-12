package com.svalero.appropav2.contract;

import com.svalero.appropav2.domain.Ropa;

import java.util.List;

public interface ArticulosListContract {

    interface Model {
        interface OnLoadArticulosListener {
            void onLoadArticulosSuccess(List<Ropa>listaRopa);
            void onLoadArticulosError(String message);
        }
        void loadAllArticulos(OnLoadArticulosListener listener);
        Ropa loadArticuloByNombre(String nombre);
        List<Ropa> getAll();
        Ropa getById(long id);
        void insert(Ropa ropa);
        boolean deleteArticulo(String nombre);
        void update(Ropa ropa);



    }

    interface View {
        void showArticulos(List<Ropa> listaRopa);
        void showMessage(String message);

    }

    interface Presenter {
        void loadAllArticulos();
        void loadArticuloByNombre(String nombre);
        void deleteArticulo(Ropa ropa);
    }
}
