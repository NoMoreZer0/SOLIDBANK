CREATE TABLE IF NOT EXISTS transaction (
    accountID VARCHAR(60) PRIMARY KEY,
    clientID VARCHAR(60) NOT NULL,
    amount NUMERIC(6, 3) NOT NULL,
    type VARCHAR(60) NOT NULL,
    failed BIT NOT NULL
);