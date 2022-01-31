CREATE TABLE IF NOT EXISTS usuario (
    id SERIAL PRIMARY KEY,
    login VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT NOW() NOT NULL,
    updated_at TIMESTAMP
);

CREATE TABLE IF NOT EXISTS transacao (
    id SERIAL PRIMARY KEY,
    tipo_orcamento VARCHAR(50) NOT NULL,
    descricao VARCHAR(200) NOT NULL,
    categoria VARCHAR(50),
    valor DECIMAL(12,2) NOT NULL,
    data DATE NOT NULL,
    created_at TIMESTAMP DEFAULT NOW() NOT NULL,
    updated_at TIMESTAMP
);

CREATE OR REPLACE FUNCTION updated_at_modified_column()
RETURNS TRIGGER AS $$
BEGIN
    NEW.updated_at = now();
    RETURN NEW;
END;
$$ language 'plpgsql';

CREATE TRIGGER update_transacao BEFORE UPDATE ON transacao FOR EACH ROW EXECUTE PROCEDURE  updated_at_modified_column();
CREATE TRIGGER update_usuario BEFORE UPDATE ON usuario FOR EACH ROW EXECUTE PROCEDURE  updated_at_modified_column();
