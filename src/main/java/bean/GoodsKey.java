package bean;

public class GoodsKey {
    private Integer gId;

    private Integer sId;

    private Integer soId;

    private Integer pId;

    
    public GoodsKey(Integer gId, Integer sId, Integer soId, Integer pId) {
		super();
		this.gId = gId;
		this.sId = sId;
		this.soId = soId;
		this.pId = pId;
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

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

	@Override
	public String toString() {
		return "GoodsKey [gId=" + gId + ", sId=" + sId + ", soId=" + soId + ", pId=" + pId + "]";
	}
    
    
}