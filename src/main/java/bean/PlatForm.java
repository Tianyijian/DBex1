package bean;

public class PlatForm {
    private Integer pId;

    private String name;

    private String pIntro;

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getpIntro() {
        return pIntro;
    }

    public void setpIntro(String pIntro) {
        this.pIntro = pIntro == null ? null : pIntro.trim();
    }
}