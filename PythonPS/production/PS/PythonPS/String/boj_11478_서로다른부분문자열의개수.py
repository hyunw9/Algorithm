from amazon_product_review_scraper import amazon_product_review_scraper
review_scraper = amazon_product_review_scraper(amazon_site="amazon.com", product_asin="B016NRXO06")
reviews_df = review_scraper.scrape()
reviews_df.head(5)