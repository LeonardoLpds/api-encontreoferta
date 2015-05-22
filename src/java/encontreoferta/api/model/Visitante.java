package encontreoferta.api.model;

public class Visitante {
    private int idPromocao;
    private String email;

    public Visitante() {
    }
    
    public Visitante(int idPromocao, String email) {
        this.idPromocao = idPromocao;
        this.email = email;
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
