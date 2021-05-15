CREATE TABLE IF NOT EXISTS articles(
    id BIGSERIAL PRIMARY KEY,
    name TEXT,
    package_quantity TEXT,
    available_units BIGINT,
    mrp NUMERIC(5, 2),
    cost NUMERIC(5, 2),
    is_active BOOL,
    created_at TIMESTAMP WITH TIME ZONE,
    updated_at TIMESTAMP WITH TIME ZONE
);