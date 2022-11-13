
# moral-riddle-2098

ER Diagram -
===========
![er diagram](https://user-images.githubusercontent.com/105962036/201519557-50028f5a-54e1-47fb-a30b-f5d97986ed42.png)

  Domain Description:
	-------------------
    Tender management software completely changes the way you approach tendering. It not just improves efficiency 
    but also makes your tender decisions more insights-driven.
	Whenever a company  requires a service / merchandise , a tender is floated. Company maintains an empaneled list 
	of Vendors. An empaneled vendor can only bid for a tender. Every vendor can bid only once against   each tender. 
	Against each tender there may be   bids from several vendors. The company will then select the most suitable bid 
	and places the order to that vendor.
	
	There are 2 users in the system:
	1. Administrator 
	2. Vendor
	
	
	The Role of Administrator is: 
	-----------------------------
	1. Login with his account.
	2. Register new Vendor. (assign a new username and password to him)
	3. View all the vendors.
	4. Create new tenders.
	5. View All the Tenders.
	6. View All the Bids of a tender.
	7. Assign tender to a vendor.
	
	
	The Role of a Vendor is: 
	------------------------
	1. Login with his account (username and password given by admin)
	1. View all the current Tenders.
	2. Place a Bid against a Tender.
	3. View status of a Bid(Whether Selected or Not)
	4. View his own Bid History.
