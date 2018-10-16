package vida.donizete.com.br.mobilecurriculosenai.recycler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import vida.donizete.com.br.mobilecurriculosenai.R;
import vida.donizete.com.br.mobilecurriculosenai.entities.Experiencia;

public class ExperienciaAdapter extends RecyclerView.Adapter<ExperienciaAdapter.ExperienciaHolder> {

    List<Experiencia> experiencias;
    Context context;

    SimpleDateFormat sdf;

    public ExperienciaAdapter(List<Experiencia> experiencias, Context context) {
        this.context = context;
        this.experiencias = experiencias;
        sdf = new SimpleDateFormat("dd/MM/yyyy");
    }


    @NonNull
    @Override
    public ExperienciaAdapter.ExperienciaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.experiencia_curriculum_vitae_adapter, parent, false);
        return new ExperienciaHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExperienciaAdapter.ExperienciaHolder holder, int position) {
        Experiencia exp = experiencias.get(position);


        holder.nome_experiencia.setText(exp.getNome());
        holder.edit_data_inicio.setText(sdf.format(exp.getData_inicio()));
        holder.edit_data_fim.setText(sdf.format(exp.getData_fim()));
        holder.edit_cargo.setText(exp.getCargo());
        holder.edit_empresa.setText(exp.getEmpresa());
        holder.edit_funcoes.setText(exp.getFuncoes());
    }

    @Override
    public int getItemCount() {
        return experiencias != null ? experiencias.size() : 0;
    }

    class ExperienciaHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.edit_cargo)
        TextView edit_cargo;

        @BindView(R.id.edit_data_fim)
        TextView edit_data_fim;

        @BindView(R.id.edit_data_inicio)
        TextView edit_data_inicio;

        @BindView(R.id.edit_empresa)
        TextView edit_empresa;

        @BindView(R.id.edit_funcoes)
        TextView edit_funcoes;

        @BindView(R.id.nome_experiencia)
        TextView nome_experiencia;

        public ExperienciaHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
