package vida.donizete.com.br.mobilecurriculosenai.recycler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import vida.donizete.com.br.mobilecurriculosenai.R;
import vida.donizete.com.br.mobilecurriculosenai.entities.CurriculumVitae;

public class CurriculumVitaeAdapter extends RecyclerView.Adapter<CurriculumVitaeAdapter.CurriculumVitaeHolder> {

    Context context;
    List<CurriculumVitae> curriculumVitaeList;

    public CurriculumVitaeAdapter(Context context, List<CurriculumVitae> curriculumVitaeList) {
        this.context = context;
        this.curriculumVitaeList = curriculumVitaeList;
    }

    @NonNull
    @Override
    public CurriculumVitaeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.curriculum_vitae_adapter, parent, false);
        return new CurriculumVitaeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CurriculumVitaeHolder holder, int position) {
        CurriculumVitae c = curriculumVitaeList.get(position);

        holder.ano_curriculo.setText(c.getTurma().getNome());
        holder.nome_curso.setText(c.getCurso().getNome());
    }

    @Override
    public int getItemCount() {
        return curriculumVitaeList != null ? curriculumVitaeList.size() : 0;
    }

    class CurriculumVitaeHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.nome_curso)
        TextView nome_curso;

        @BindView(R.id.ano_curriculo)
        TextView ano_curriculo;

        public CurriculumVitaeHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
