package bean;

public class Sell extends SellKey {
    private Integer sellNum;

    private Float sellPrice;

    private Integer gId;

    public Integer getSellNum() {
        return sellNum;
    }

    public void setSellNum(Integer sellNum) {
        this.sellNum = sellNum;
    }

    public Float getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Float sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Integer getgId() {
        return gId;
    }

    public void setgId(Integer gId) {
        this.gId = gId;
    }
}