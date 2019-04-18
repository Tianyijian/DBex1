package bean;

public class Goods extends GoodsKey {
    private Float price;

    private String name;

	public Goods(Integer gId, Integer sId, Integer soId, Integer pId) {
		super(gId, sId, soId, pId);
		// TODO Auto-generated constructor stub
	}

	public Goods(Integer gId, Integer sId, Integer soId, Integer pId, Float price, String name) {
		super(gId, sId, soId, pId);
		this.price = price;
		this.name = name;
	}

	public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

	@Override
	public String toString() {
		return "Goods [price=" + price + ", name=" + name + ", toString()=" + super.toString() + "]";
	}
    
    
}