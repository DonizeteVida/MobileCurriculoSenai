package vida.donizete.com.br.mobilecurriculosenai.service;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import vida.donizete.com.br.mobilecurriculosenai.entities.Usuario;

public interface UsuarioService {

    String BASE_URL = "http://10.87.210.5/MOBILE_API-MAVEN-SCCV/ws/";

    @GET("usuario/{cpf}/busca")
    Call<Usuario> getUsuario(@Path("cpf") String cpf);

}
