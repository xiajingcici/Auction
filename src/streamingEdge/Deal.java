package streamingEdge;

import java.util.Date;

//this class is defined for holding deal information
public class Deal {
	private int dealPrice;
	private int dealSize;
	private long time;

	public int getDealPrice() {
		return dealPrice;
	}

	public void setDealPrice(int dealPrice) {
		this.dealPrice = dealPrice;
	}

	public int getDealSize() {
		return dealSize;
	}

	public void setDealSize(int dealSize) {
		this.dealSize = dealSize;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Deal: [Price=" + dealPrice + ", Size="
				+ dealSize + ", Time=" + new Date(time) + "]";
	}

}
