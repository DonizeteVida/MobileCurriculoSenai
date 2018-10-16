package vida.donizete.com.br.mobilecurriculosenai.activity;

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
import vida.donizete.com.br.mobilecurriculosenai.entities.CurriculumVitae;
import vida.donizete.com.br.mobilecurriculosenai.entities.Experiencia;
import vida.donizete.com.br.mobilecurriculosenai.entities.Formacao;
import vida.donizete.com.br.mobilecurriculosenai.recycler.ExperienciaAdapter;
import vida.donizete.com.br.mobilecurriculosenai.recycler.FormacaoAdapter;
import vida.donizete.com.br.mobilecurriculosenai.service.CurriculoService;
import vida.donizete.com.br.mobilecurriculosenai.utils.BaseActivity;

public class InformacaoSolicitada extends BaseActivity {

    CurriculumVitae c;
    Integer info;
    Retrofit retrofit;

    @BindView(R.id.recyclerViewInfo)
    RecyclerView recyclerView;

    @BindView(R.id.refreshInfo)
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacao_solicitada);
        ButterKnife.bind(this);

        c = (CurriculumVitae) getIntent().getSerializableExtra("curriculo");
        info = (Integer) getIntent().getSerializableExtra("info");

        retrofit = retrofitGetInstance();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        if (info == 0) {
            getExperiencia();
        } else if (info == 1) {
            getFormacao();
        }

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (info == 0) {
                    getExperiencia();
                } else if (info == 1) {
                    getFormacao();
                }
            }
        });
    }

    public void getExperiencia() {
        CurriculoService curriculoService = retrofit.create(CurriculoService.class);

        Call<List<Experiencia>> listCall = curriculoService.getExperiencias(c.getId());

        listCall.enqueue(new Callback<List<Experiencia>>() {
            @Override
            public void onResponse(Call<List<Experiencia>> call, Response<List<Experiencia>> response) {
                if (response.isSuccessful()) {
                    List<Experiencia> lista = response.body();
                    recyclerView.setAdapter(new ExperienciaAdapter(lista, InformacaoSolicitada.this));
                } else {
                    longMens("Erro ao baixar experiencias !");
                }
                swipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<List<Experiencia>> call, Throwable t) {
                swipeRefreshLayout.setRefreshing(false);
                longMens("Erro: " + t.toString());
            }
        });
    }

    public void getFormacao() {
        CurriculoService curriculoService = retrofit.create(CurriculoService.class);

        Call<List<Formacao>> listCall = curriculoService.getFormacoes(c.getId());

        listCall.enqueue(new Callback<List<Formacao>>() {
            @Override
            public void onResponse(Call<List<Formacao>> call, Response<List<Formacao>> response) {
                if (response.isSuccessful()) {
                    List<Formacao> lista = response.body();
                    recyclerView.setAdapter(new FormacaoAdapter(lista, InformacaoSolicitada.this));
                } else {
                    longMens("Erro ao baixar formações !");
                }
                swipeRefreshLayout.setRefreshing(false);

            }

            @Override
            public void onFailure(Call<List<Formacao>> call, Throwable t) {
                swipeRefreshLayout.setRefreshing(false);
                longMens("Erro: " + t.toString());
            }
        });
    }

}
