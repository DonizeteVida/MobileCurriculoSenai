package vida.donizete.com.br.mobilecurriculosenai.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import vida.donizete.com.br.mobilecurriculosenai.entities.Usuario;

public interface UsuarioService {

    public static String BASE_URL = "http://10.0.2.2:8080/MOBILE_API-MAVEN-SCCV/ws/";

    @GET("usuario/{cpf}/busca")
    Call<Usuario> getUsuario(@Path("cpf") String cpf);
}
