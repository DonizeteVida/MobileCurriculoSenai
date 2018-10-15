package vida.donizete.com.br.mobilecurriculosenai.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import vida.donizete.com.br.mobilecurriculosenai.R;
import vida.donizete.com.br.mobilecurriculosenai.callback.CurriculoCallback;
import vida.donizete.com.br.mobilecurriculosenai.entities.CurriculumVitae;
import vida.donizete.com.br.mobilecurriculosenai.recycler.CurriculumVitaeAdapter;
import vida.donizete.com.br.mobilecurriculosenai.service.CurriculoService;
import vida.donizete.com.br.mobilecurriculosenai.utils.BaseActivity;
import vida.donizete.com.br.mobilecurriculosenai.utils.Perfil;

public class MainActivity extends BaseActivity implements CurriculoCallback {

    Retrofit retrofit;

    @BindView(R.id.recyclerViewMain)
    RecyclerView recyclerView;

    @BindView(R.id.swipe)
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setUpToolbar();
        setUpMenu();

        retrofit = retrofitGetInstance();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        doRecycler();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                doRecycler();
            }
        });
    }

    public void doRecycler() {
        CurriculoService curriculoService = retrofit.create(CurriculoService.class);

        curriculoService.getCurriculumVitae(Perfil.getUsuario().getId()).enqueue(new Callback<List<CurriculumVitae>>() {
            @Override
            public void onResponse(Call<List<CurriculumVitae>> call, Response<List<CurriculumVitae>> response) {
                if (response.isSuccessful()) {
                    List<CurriculumVitae> list = response.body();
                    recyclerView.setAdapter(new CurriculumVitaeAdapter(MainActivity.this, list, MainActivity.this));
                    swipeRefreshLayout.setRefreshing(false);
                }
            }

            @Override
            public void onFailure(Call<List<CurriculumVitae>> call, Throwable t) {

            }
        });
    }

    @Override
    public void verExperiencia(CurriculumVitae c) {
        Intent i = new Intent(this, InformacaoSolicitada.class);
        i.putExtra("info", 1);
        i.putExtra("curriculo", c);
    }

    @Override
    public void verFormacao(CurriculumVitae c) {
        Intent i = new Intent(this, InformacaoSolicitada.class);
        i.putExtra("info", 2);
        i.putExtra("curriculo", c);
    }
}
