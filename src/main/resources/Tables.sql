DROP TABLE PRODUCT IF EXISTS;
DROP TABLE SELLER IF EXISTS;

CREATE TABLE SELLER (
   seller_id VARCHAR(255) primary key,
   seller_name VARCHAR(255) UNIQUE
);

CREATE TABLE PRODUCT(
   product_id VARCHAR(255) primary key,
   product_name VARCHAR(255),
   price_item int,
   seller_name VARCHAR(255),
   FOREIGN KEY (seller_name) REFERENCES SELLER(seller_name)
);


INSERT INTO SELLER (seller_id, seller_name) VALUES ('1','Jabra'),
                                                   ('2','Kirkland');

INSERT INTO PRODUCT (product_id,product_name,price_item,seller_name) VALUES ('1','headphone',10,'Jabra');