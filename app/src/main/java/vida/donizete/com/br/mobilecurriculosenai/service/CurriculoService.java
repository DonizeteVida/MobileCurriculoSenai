package vida.donizete.com.br.mobilecurriculosenai.service;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import vida.donizete.com.br.mobilecurriculosenai.entities.CurriculumVitae;
import vida.donizete.com.br.mobilecurriculosenai.entities.Experiencia;
import vida.donizete.com.br.mobilecurriculosenai.entities.Formacao;

public interface CurriculoService {

    @GET("curriculumvitae/{idUser}/busca")
    Call<List<CurriculumVitae>> getCurriculumVitae(@Path("idUser") Integer id);

    @GET("{idCurriculo}/experiencia/busca")
    Call<List<Experiencia>> getExperiencias(@Path("idCurriculo") Integer idCurriculo);

    @GET("{idCurriculo}/formacao/busca")
    Call<List<Formacao>> getFormacoes(@Path("idCurriculo") Integer idCurriculo);
}
