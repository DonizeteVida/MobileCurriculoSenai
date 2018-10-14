package vida.donizete.com.br.mobilecurriculosenai.activity;

import android.os.Bundle;
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
import vida.donizete.com.br.mobilecurriculosenai.entities.CurriculumVitae;
import vida.donizete.com.br.mobilecurriculosenai.recycler.CurriculumVitaeAdapter;
import vida.donizete.com.br.mobilecurriculosenai.service.CurriculoService;
import vida.donizete.com.br.mobilecurriculosenai.utils.BaseActivity;
import vida.donizete.com.br.mobilecurriculosenai.utils.Perfil;

public class MainActivity extends BaseActivity {

    Retrofit retrofit;

    @BindView(R.id.recyclerViewMain)
    RecyclerView recyclerView;


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
    }

    public void doRecycler() {
        CurriculoService curriculoService = retrofit.create(CurriculoService.class);

        curriculoService.getCurriculumVitae(Perfil.getUsuario().getId()).enqueue(new Callback<List<CurriculumVitae>>() {
            @Override
            public void onResponse(Call<List<CurriculumVitae>> call, Response<List<CurriculumVitae>> response) {
                if (response.isSuccessful()) {
                    List<CurriculumVitae> list = response.body();
                    recyclerView.setAdapter(new CurriculumVitaeAdapter(MainActivity.this, list));
                }
            }

            @Override
            public void onFailure(Call<List<CurriculumVitae>> call, Throwable t) {

            }
        });
    }

}
