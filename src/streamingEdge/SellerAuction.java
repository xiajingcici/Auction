package streamingEdge;

public class SellerAuction implements Comparable<SellerAuction>{
	private int price;
	private int size;
	private long time;
	
	public SellerAuction(int price, int size, long time) {
		this.price = price;
		this.size = size;
		this.time = time;
	}
	@Override
	public int compareTo(SellerAuction sa) {
		//Seller auction with lower price, earlier time has priority
		if(this.price<sa.price||(sa.price==this.price&&this.time<sa.time)){
			return -1;
		}else{
			return 1;
		}
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
}
