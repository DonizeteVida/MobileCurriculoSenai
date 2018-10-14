package vida.donizete.com.br.mobilecurriculosenai.activity;

import android.os.Bundle;



import butterknife.ButterKnife;
import vida.donizete.com.br.mobilecurriculosenai.R;
import vida.donizete.com.br.mobilecurriculosenai.utils.BaseActivity;

public class MainActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setUpToolbar();
    }

}
