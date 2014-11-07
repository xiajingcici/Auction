package streamingEdge;

import java.util.Date;

public class BuyerAuction implements Comparable<BuyerAuction>{
	private int price;
	private int size;
	private long time;
	
	public BuyerAuction(int price, int size, long time) {
		this.price = price;
		this.size = size;
		this.time = time;
	}
	
	@Override
	public int compareTo(BuyerAuction ba) {
		//Buyer auction with higher price, earlier time has priority
		if(this.price>ba.price||(ba.price==this.price&&ba.time>this.time)){
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
