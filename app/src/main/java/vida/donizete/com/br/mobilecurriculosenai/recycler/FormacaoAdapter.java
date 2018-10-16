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
import vida.donizete.com.br.mobilecurriculosenai.entities.Formacao;

public class FormacaoAdapter extends RecyclerView.Adapter<FormacaoAdapter.FormacaoHolder> {

    List<Formacao> formacaos;
    Context context;
    SimpleDateFormat sdf;

    public FormacaoAdapter(List<Formacao> formacaos, Context context) {
        this.context = context;
        this.formacaos = formacaos;
        sdf = new SimpleDateFormat("dd/MM/yyyy");
    }

    @NonNull
    @Override
    public FormacaoAdapter.FormacaoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.formacao_curriculum_vitae_adapter, parent, false);
        return new FormacaoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FormacaoAdapter.FormacaoHolder holder, int position) {
        Formacao form = formacaos.get(position);

        holder.nome_formacao.setText(form.getNome());
        holder.text_date_inicio_formacao.setText(sdf.format(form.getData_inicio()));
        holder.text_date_fim_formacao.setText(sdf.format(form.getData_fim()));
        holder.text_escola.setText(form.getEscola());
    }

    @Override
    public int getItemCount() {
        return formacaos != null ? formacaos.size() : 0;
    }

    class FormacaoHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.nome_formacao)
        TextView nome_formacao;

        @BindView(R.id.text_date_fim_formacao)
        TextView text_date_fim_formacao;

        @BindView(R.id.text_date_inicio_formacao)
        TextView text_date_inicio_formacao;

        @BindView(R.id.text_escola)
        TextView text_escola;

        public FormacaoHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
