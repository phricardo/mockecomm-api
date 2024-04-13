-- Dropa a tabela de produtos se já existir
DROP TABLE IF EXISTS products;

-- Cria a tabela de produtos
CREATE TABLE IF NOT EXISTS products (
    product_id SERIAL PRIMARY KEY,
    sku VARCHAR(50) UNIQUE,
    name VARCHAR(255),
    description TEXT,
    price DECIMAL(19, 2),
    category VARCHAR(50),
    image_url VARCHAR(255)
);
