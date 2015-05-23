package encontreoferta.api.model;

public class Visitante {
    private int idUsuario;
    private int idPromocao;
    private String email;

    public Visitante() {
    }
    
    public Visitante(int idPromocao, String email) {
        this.idPromocao = idPromocao;
        this.email = email;
    }

    public Visitante(int idUsuario, int idPromocao) {
        this.idUsuario = idUsuario;
        this.idPromocao = idPromocao;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdPromocao() {
        return idPromocao;
    }

    public void setIdPromocao(int idPromocao) {
        this.idPromocao = idPromocao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
