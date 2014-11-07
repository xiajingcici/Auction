It contains four classes: BuyerAuction, SellerAuction, and Deal are data structures, and Operation is the main function class.

BuyerAuction and SellerAuction contain the information of price, size and bid time. Deal defines the deal price, quantity and time.

I set deal price as the one who first offered the bid. For example, A wants to sell it at $2, B wants to buy it at $3. If A comes in first, the deal price is $3, otherwise it's $2.
deal.size=min(buyer.size, seller.size).
time is the later one who offered the price.

I am not sure whether I get it right for startAuction and endAuction. Here I assume startAuction is to get the start time and the auction period is half an hour. 

For realtime system, I should take thread and concurrency into account. 
