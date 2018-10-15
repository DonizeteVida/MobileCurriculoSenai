package vida.donizete.com.br.mobilecurriculosenai.entities;

import java.io.Serializable;


public class CurriculumVitae implements Serializable {

    public CurriculumVitae() {
        curso = new ClasseGenerica();
        turma = new ClasseGenerica();
        status = new ClasseGenerica();
        categoria = new ClasseGenerica();
        usuario = new Usuario();
        semestre = new Integer(1);
    }

    private Integer semestre;
    private Integer id;
    private Long data_criacao;
    private ClasseGenerica curso;
    private ClasseGenerica turma;
    private ClasseGenerica status;
    private ClasseGenerica categoria;
    private Usuario usuario;

    public Long getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(Long data_criacao) {
        this.data_criacao = data_criacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClasseGenerica getCurso() {
        return curso;
    }

    public void setCurso(ClasseGenerica curso) {
        this.curso = curso;
    }

    public ClasseGenerica getTurma() {
        return turma;
    }

    public void setTurma(ClasseGenerica turma) {
        this.turma = turma;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public ClasseGenerica getStatus() {
        return status;
    }

    public void setStatus(ClasseGenerica status) {
        this.status = status;
    }

    public ClasseGenerica getCategoria() {
        return categoria;
    }

    public void setCategoria(ClasseGenerica categoria) {
        this.categoria = categoria;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
