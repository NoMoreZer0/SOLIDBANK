CREATE TABLE IF NOT EXISTS account (
    id VARCHAR(60) PRIMARY KEY,
    clientID VARCHAR(60) NOT NULL,
    balance NUMERIC(6, 3) NOT NULL,
    withdrawAllowed BIT NOT NULL,
    accountType VARCHAR(60) NOT NULL
);