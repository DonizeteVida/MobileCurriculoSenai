package vida.donizete.com.br.mobilecurriculosenai;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import vida.donizete.com.br.mobilecurriculosenai.entities.Usuario;
import vida.donizete.com.br.mobilecurriculosenai.service.UsuarioService;
import vida.donizete.com.br.mobilecurriculosenai.utils.BaseActivity;
import vida.donizete.com.br.mobilecurriculosenai.utils.StringToMD5;

public class MainActivity extends BaseActivity {

    Retrofit retrofit;

    @BindView(R.id.editText1)
    EditText cpfDigitado;

    @BindView(R.id.editText2)
    EditText passDigitado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setUpToolbar();

        retrofit = retrofitGetInstance();

    }

    @OnClick(R.id.buttonLogin)
    public void login() {

        String cpf = cpfDigitado.getText().toString().trim();
        final String pass = StringToMD5.convertStringToMd5(passDigitado.getText().toString().trim());

        retrofit.create(UsuarioService.class).getUsuario(cpf).enqueue(new Callback<Usuario>() {

            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if (response.isSuccessful()) {
                    Usuario usuario = response.body();

                    if (usuario.getSenha().equals(pass)) {
                        mens("Sucesso, senhas iguais ! \n Bem vindo, " + usuario.getNome());
                    } else {
                        mens("Usuario e/ou senha incorretos !");
                    }
                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                mens("Falha ao conectar ao serviço: " + t.toString());
            }
        });
    }

    private void mens(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

}
