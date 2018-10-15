package vida.donizete.com.br.mobilecurriculosenai.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import vida.donizete.com.br.mobilecurriculosenai.R;
import vida.donizete.com.br.mobilecurriculosenai.entities.CurriculumVitae;

public class InformacaoSolicitada extends AppCompatActivity {

    CurriculumVitae c;
    Integer info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacao_solicitada);

        c = (CurriculumVitae) getIntent().getSerializableExtra("curriculo");
        info = (Integer) getIntent().getSerializableExtra("info");

    }
}
