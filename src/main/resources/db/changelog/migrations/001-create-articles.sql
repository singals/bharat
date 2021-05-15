CREATE TABLE IF NOT EXISTS articles(
    id BIGSERIAL PRIMARY KEY,
    name TEXT,
    package_quantity TEXT,
    available_units BIGINT,
    mrp NUMERIC(10, 2),
    cost NUMERIC(10, 2),
    created_at TIMESTAMP WITH TIME ZONE,
    updated_at TIMESTAMP WITH TIME ZONE
);

