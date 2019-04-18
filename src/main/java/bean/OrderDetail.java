package bean;

public class OrderDetail extends OrderDetailKey {
    private Float odPrice;

    private Integer odNum;

    private Integer gId;

    private Integer sId;

    private Integer soId;

    public Float getOdPrice() {
        return odPrice;
    }

    public void setOdPrice(Float odPrice) {
        this.odPrice = odPrice;
    }

    public Integer getOdNum() {
        return odNum;
    }

    public void setOdNum(Integer odNum) {
        this.odNum = odNum;
    }

    public Integer getgId() {
        return gId;
    }

    public void setgId(Integer gId) {
        this.gId = gId;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public Integer getSoId() {
        return soId;
    }

    public void setSoId(Integer soId) {
        this.soId = soId;
    }
}