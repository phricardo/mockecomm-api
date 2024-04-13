-- Cria tabela de produtos se ela não existir
CREATE TABLE IF NOT EXISTS public.dp_products (
	product_id serial4 NOT NULL,
	sku varchar(50) NULL,
	"name" varchar(255) NULL,
	description text NULL,
	price numeric NULL,
	category public."productcategoryenum" NULL,
	image_url varchar(255) NULL,
	CONSTRAINT dp_products_pkey null,
	CONSTRAINT dp_products_sku_key null
);

-- Inserindo dados na nova tabela de produtos
INSERT INTO DP_PRODUCTS (sku, name, description, price, category, image_url)
VALUES ('SKU001', 'Product 1', 'Description of Product 1', 19.99, 'ELECTRONICS', 'http://example.com/product1.jpg');

INSERT INTO DP_PRODUCTS (sku, name, description, price, category, image_url)
VALUES ('SKU002', 'Product 2', 'Description of Product 2', 29.99, 'CLOTHING', 'http://example.com/product2.jpg');

INSERT INTO DP_PRODUCTS (sku, name, description, price, category, image_url)
VALUES ('SKU003', 'Product 3', 'Description of Product 3', 39.99, 'HOME_AND_KITCHEN', 'http://example.com/product3.jpg');
