package vida.donizete.com.br.mobilecurriculosenai.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import vida.donizete.com.br.mobilecurriculosenai.R;
import vida.donizete.com.br.mobilecurriculosenai.entities.Usuario;
import vida.donizete.com.br.mobilecurriculosenai.service.UsuarioService;
import vida.donizete.com.br.mobilecurriculosenai.utils.BaseActivity;
import vida.donizete.com.br.mobilecurriculosenai.utils.StringToMD5;

public class LoginActivity extends BaseActivity {

    Retrofit retrofit;

    @BindView(R.id.editText1)
    EditText editTextCpf;

    @BindView(R.id.editText2)
    EditText editTextPass;

    @BindView(R.id.progressBar2)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        setUpToolbar();

        retrofit = retrofitGetInstance();
    }

    @OnClick(R.id.buttonLogin)
    public void doLogin() {

        progressBar.setVisibility(View.VISIBLE);

        String cpf = editTextCpf.getText().toString().trim();
        final String pass = StringToMD5.convertStringToMd5(editTextPass.getText().toString().trim());


        UsuarioService usuarioService = retrofit.create(UsuarioService.class);

        Call<Usuario> usuarioCall = usuarioService.getUsuario(cpf);

        usuarioCall.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if (response.isSuccessful()) {
                    Usuario usuario = response.body();
                    if (usuario.getSenha().equals(pass)) {
                        longMens("Sucesso, senhas iguais !");
                    }
                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                longMens("Falha ao conectar ao serviço: " + t.toString());
            }
        });

    }


}
