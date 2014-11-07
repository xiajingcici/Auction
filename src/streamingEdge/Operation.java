package streamingEdge;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Jing Xia
 *
 */
public class Operation {
	private long startTime;
	private long endTime;

	
	/**
	 * not sure how to write startAuction, I just set the start time
	 */
	public void startAuction() {
		startTime = System.currentTimeMillis();
	}

	// set the endTime to half an hour after the auction started
	public void endAuction() {
		endTime = startTime + 1800000;
	}


	/**
	 * @param buyerBook: priority queue for buyers' information
	 * @param sellerBook: priority queue for sellers' information
	 * @return List of deals that matches the price, quantity and time
	 */
	public List<Deal> reportPair(PriorityQueue<BuyerAuction> buyerBook,
			PriorityQueue<SellerAuction> sellerBook) {
		List<Deal> result = new ArrayList<Deal>();
		while (!buyerBook.isEmpty() || !sellerBook.isEmpty()) {
			SellerAuction sa = sellerBook.peek();
			BuyerAuction ba = buyerBook.peek();

			// if the auction time is later than the end time, we should poll it out
			if (ba.getTime() > endTime) {
				// System.out.println("Array here 1.1");
				buyerBook.poll();
			}
			if (sa.getTime() > endTime) {
				// System.out.println("Array here 1.2");
				sellerBook.poll();
			}
			
			//if buyers' price is higher or equal than the sellers', that's a deal
			if (ba.getPrice() >= sa.getPrice()) {
				// System.out.println("Array here 2");
				Deal deal = new Deal();
				int diff = ba.getSize() - sa.getSize();
				// set deal size and update the uncomplete auction
				if (diff > 0) {
					deal.setDealSize(sa.getSize());
					ba.setSize(diff);
					sellerBook.poll();
				} else if (diff < 0) {
					deal.setDealSize(ba.getSize());
					sa.setSize(-diff);
					buyerBook.poll();
				} else {// size of buyer and seller equals
					buyerBook.poll();
					sellerBook.poll();
					deal.setDealSize(ba.getSize());
				}
				// set deal price at whom first offer
				if (sa.getTime() < ba.getTime()) {
					deal.setDealPrice(ba.getPrice());
					deal.setTime(ba.getTime());
				} else {
					deal.setDealPrice(sa.getPrice());
					deal.setTime(sa.getTime());
				}

				result.add(deal);
			} else {//if buyers' price is lower than sellers', no deal
				return result;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// SellerAuction(price, size, time)
		long t = System.currentTimeMillis() + 1000;
		SellerAuction sa0 = new SellerAuction(10, 2, t);
		SellerAuction sa1 = new SellerAuction(5, 2, t);
		SellerAuction sa2 = new SellerAuction(6, 12, t + 100);
		SellerAuction sa3 = new SellerAuction(6, 10, t);
		SellerAuction sa4 = new SellerAuction(7, 2, t);
		BuyerAuction ba0 = new BuyerAuction(11, 2, t);
		BuyerAuction ba1 = new BuyerAuction(10, 2, t);
		BuyerAuction ba2 = new BuyerAuction(5, 12, t);
		BuyerAuction ba3 = new BuyerAuction(6, 2, t);
		BuyerAuction ba4 = new BuyerAuction(7, 22, t);

		PriorityQueue<BuyerAuction> buyerBook = new PriorityQueue<BuyerAuction>();
		PriorityQueue<SellerAuction> sellerBook = new PriorityQueue<SellerAuction>();
		buyerBook.offer(ba0);
		buyerBook.offer(ba1);
		buyerBook.offer(ba2);
		buyerBook.offer(ba3);
		buyerBook.offer(ba4);
		sellerBook.offer(sa0);
		sellerBook.offer(sa1);
		sellerBook.offer(sa2);
		sellerBook.offer(sa3);
		sellerBook.offer(sa4);

		Operation op = new Operation();
		op.startAuction();
		op.endAuction();
		List<Deal> res = op.reportPair(buyerBook, sellerBook);
		for (Deal d : res) {
			System.out.println(d.toString());
		}
	}

}
