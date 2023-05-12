package com.svalero.appropav2.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.svalero.appropav2.R;
import com.svalero.appropav2.contract.ArticuloDetailsContract;
import com.svalero.appropav2.contract.ModifyArticuloContract;
import com.svalero.appropav2.domain.Ropa;
import com.svalero.appropav2.presenter.ArticuloDetailsPresenter;
import com.svalero.appropav2.presenter.ModifyArticuloPresenter;

public class ArticuloDetailsView extends AppCompatActivity implements ArticuloDetailsContract.View, ModifyArticuloContract.View {

    private ArticuloDetailsContract.Presenter presenter;
    private ModifyArticuloContract.Presenter modifyPresenter;
    private long idRopa;
    private Ropa loadedArticulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articulo_details);

        presenter = new ArticuloDetailsPresenter(this);
        modifyPresenter = new ModifyArticuloPresenter(this);


        SharedPreferences preferences = getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE);
        String username = preferences.getString("username","");
        String password = preferences.getString("password", "");

        Intent intent = getIntent();
        idRopa = intent.getLongExtra("idRopa", 0);

        Toast.makeText(this, "Received idRopa: " + idRopa, Toast.LENGTH_SHORT).show();

        Log.d("ArticuloDetailsView", "idRopa: " + idRopa);

        presenter.loadArticulo(idRopa);
    }


    public void modifyArticulo(View view) {
        Log.d("ArticuloDetailsView", "modifyArticulo clicked");

        Intent intent = getIntent();

        idRopa = intent.getLongExtra("idRopa",0);
        if (idRopa == 0) {
            return;
        }



        EditText nombreField = findViewById(R.id.et_articulo_nombre);
        EditText codigoField = findViewById(R.id.et_articulo_code);
        EditText fechaField = findViewById(R.id.et_articulo_fecha);
        EditText precioField = findViewById(R.id.et_articulo_precio);
        EditText hasStockField = findViewById(R.id.et_articulo_has_stock);

        Ropa updatedArticulo = new Ropa();

        updatedArticulo.setNombre(nombreField.getText().toString());
        updatedArticulo.setCode(codigoField.getText().toString());
        updatedArticulo.setFechaAlta(fechaField.getText().toString());
        updatedArticulo.setPrecio(Double.parseDouble(precioField.getText().toString()));
        updatedArticulo.setHayStock(hasStockField.getText().toString().isEmpty());


        modifyPresenter.modifyArticulo(updatedArticulo, idRopa);
    }


    @Override
    public void showArticulo(Ropa ropa) {
        EditText etNombre = findViewById(R.id.et_articulo_nombre);
        EditText etCode = findViewById(R.id.et_articulo_code);
        EditText etFecha = findViewById(R.id.et_articulo_fecha);
        EditText etPrecio = findViewById(R.id.et_articulo_precio);

        etNombre.setText(ropa.getNombre());
        etCode.setText(ropa.getCode());
        etFecha.setText(ropa.getFechaAlta());
        etPrecio.setText((int) ropa.getPrecio());

        loadedArticulo = ropa;
    }
    public void goBackButton(View view) {
        onBackPressed();
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

}
