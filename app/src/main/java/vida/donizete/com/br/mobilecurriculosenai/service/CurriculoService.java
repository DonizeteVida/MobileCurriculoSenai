package vida.donizete.com.br.mobilecurriculosenai.service;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import vida.donizete.com.br.mobilecurriculosenai.entities.CurriculumVitae;

public interface CurriculoService {

    @GET("curriculumvitae/{idUser}/busca")
    Call<List<CurriculumVitae>> getCurriculumVitae(@Path("idUser") Integer id);
}
