CREATE TABLE IF NOT EXISTS debtors(
    id BIGSERIAL PRIMARY KEY,
    name TEXT,
    village TEXT,
    contact_number TEXT,
    created_at TIMESTAMP WITH TIME ZONE,
    updated_at TIMESTAMP WITH TIME ZONE
);
