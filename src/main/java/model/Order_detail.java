package model;

public class Order_detail {
	private int order_id;
	private int product_id;
	private int amount_product;
	private int price_product;
	
	public Order_detail(int order_id, int product_id, int amount_product, int price_product) {
		super();
		this.order_id = order_id;
		this.product_id = product_id;
		this.amount_product = amount_product;
		this.price_product = price_product;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getAmount_product() {
		return amount_product;
	}

	public void setAmount_product(int amount_product) {
		this.amount_product = amount_product;
	}

	public int getPrice_product() {
		return price_product;
	}

	public void setPrice_product(int price_product) {
		this.price_product = price_product;
	}
	
	
	
	
}
