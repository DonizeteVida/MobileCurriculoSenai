package vida.donizete.com.br.mobilecurriculosenai.utils;

import vida.donizete.com.br.mobilecurriculosenai.entities.Usuario;

public class Perfil {

    private static Usuario usuario;

    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario usuario) {
        Perfil.usuario = usuario;
    }
}
