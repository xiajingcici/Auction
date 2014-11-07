package Test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.PriorityQueue;

import org.junit.Test;

import streamingEdge.BuyerAuction;
import streamingEdge.Deal;
import streamingEdge.Operation;
import streamingEdge.SellerAuction;

public class OperationTest {

	@Test
	public void testReportPair() {
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

