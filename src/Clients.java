public class Clients {

    private Long client_id;
    private String client_name;
    private String client_surname;
    private boolean client_status;
    private String client_mail;
    private String client_password;
    private int client_price;

    public Clients(Long client_id, String client_name, String client_surname, boolean client_status, String client_mail, String client_password, int client_price) {
        this.client_id = client_id;
        this.client_name = client_name;
        this.client_surname = client_surname;
        this.client_status = client_status;
        this.client_mail = client_mail;
        this.client_password = client_password;
        this.client_price = client_price;
    }

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getClient_surname() {
        return client_surname;
    }

    public void setClient_surname(String client_surname) {
        this.client_surname = client_surname;
    }

    public boolean isClient_status() {
        return client_status;
    }

    public void setClient_status(boolean client_status) {
        this.client_status = client_status;
    }

    public String getClient_mail() {
        return client_mail;
    }

    public void setClient_mail(String client_mail) {
        this.client_mail = client_mail;
    }

    public String getClient_password() {
        return client_password;
    }

    public void setClient_password(String client_password) {
        this.client_password = client_password;
    }

    public int getClient_price() {
        return client_price;
    }

    public void setClient_price(int client_price) {
        this.client_price = client_price;
    }

    @Override
    public String toString() {
        return "Clients{" +
                "client_id=" + client_id +
                ", client_name='" + client_name + '\'' +
                ", client_surname='" + client_surname + '\'' +
                ", client_status=" + client_status +
                ", client_mail='" + client_mail + '\'' +
                ", client_password='" + client_password + '\'' +
                ", client_price=" + client_price +
                '}';
    }
}

