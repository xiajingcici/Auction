It contains four classes: BuyerAuction, SellerAuction, and Deal are data structures.
Operation is the main function class.

BuyerAuction and SellerAuction contain the information of price, size and bid time.
Deal defines the deal price, quantity and time.

I set deal price as the one who first offered the bid. For example, A wants to sell it at $2,
B wants to buy it at $3. If A comes in first, the deal price is $3, otherwise it's $2.
deal.size=min(buyer.size, seller.size).
time is the later one who offered the price.
