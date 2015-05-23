package encontreoferta.api.model;

public class Visitante {
    private Integer idUsuario;
    private Integer idPromocao;
    private String email;

    public Visitante() {
    }
    
    public Visitante(Integer idPromocao, String email) {
        this.idPromocao = idPromocao;
        this.email = email;
    }

    public Visitante(Integer idUsuario, Integer idPromocao) {
        this.idUsuario = idUsuario;
        this.idPromocao = idPromocao;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdPromocao() {
        return idPromocao;
    }

    public void setIdPromocao(Integer idPromocao) {
        this.idPromocao = idPromocao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
