public class Admin {
    private int admin_id;
    private String admin_Name;
    private String admin_Surname;
    private String admin_Pass;
    private String admin_Email;

    public Admin(int admin_id, String admin_Name, String admin_Surname, String admin_Pass, String admin_Email) {
        this.admin_id = admin_id;
        this.admin_Name = admin_Name;
        this.admin_Surname = admin_Surname;
        this.admin_Pass = admin_Pass;
        this.admin_Email = admin_Email;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_Name() {
        return admin_Name;
    }

    public void setAdmin_Name(String admin_Name) {
        this.admin_Name = admin_Name;
    }

    public String getAdmin_Surname() {
        return admin_Surname;
    }

    public void setAdmin_Surname(String admin_Surname) {
        this.admin_Surname = admin_Surname;
    }

    public String getAdmin_Pass() {
        return admin_Pass;
    }

    public void setAdmin_Pass(String admin_Pass) {
        this.admin_Pass = admin_Pass;
    }

    public String getAdmin_Email() {
        return admin_Email;
    }

    public void setAdmin_Email(String admin_Email) {
        this.admin_Email = admin_Email;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "admin_id=" + admin_id +
                ", admin_Name='" + admin_Name + '\'' +
                ", admin_Surname='" + admin_Surname + '\'' +
                ", admin_Pass='" + admin_Pass + '\'' +
                ", admin_Email='" + admin_Email + '\'' +
                '}';
    }
}
