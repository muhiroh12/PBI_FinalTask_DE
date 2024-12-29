--QUERY
------------------------------------------------------------------------------------
--CREATE DATABASE AND TABLE
CREATE DATABASE DWH;

USE DWH;

CREATE TABLE dbo.DimBranch(
    BranchID INT PRIMARY KEY NOT NULL,
    BranchName VARCHAR(50),
    BranchLocation VARCHAR(50)
);

CREATE TABLE dbo.DimCustomer(
    CustomerID INT PRIMARY KEY NOT NULL,
    CustomerName VARCHAR(50) NOT NULL,
    Address VARCHAR(255),
    Age VARCHAR(3),
    Gender VARCHAR(10),
    Email VARCHAR(50),
    CityName VARCHAR(50),
    StateName VARCHAR(50)
);

CREATE TABLE dbo.DimAccount(
    AccountID INT PRIMARY KEY NOT NULL,
    CustomerID INT NOT NULL,
    AccountType VARCHAR(10),
    Balance INT,
    DateOpened DATETIME2,
    Status VARCHAR(10),
    CONSTRAINT FK_DimAccount_DimCustomer FOREIGN KEY (CustomerID) REFERENCES dbo.DimCustomer(CustomerID)
);

CREATE TABLE dbo.FactTransaction(
    TransactionID INT PRIMARY KEY NOT NULL,
    AccountID INT NOT NULL,
    BranchID INT NOT NULL,
    TransactionDate DATETIME2,
    Amount INT,
    TransactionType VARCHAR(10),
    CONSTRAINT FK_FactTransaction_DimAccount FOREIGN KEY (AccountID) REFERENCES dbo.DimAccount(AccountID),
    CONSTRAINT FK_FactTransaction_DimBranch FOREIGN KEY (BranchID) REFERENCES dbo.DimBranch(BranchID)
);

---------------------------------------------------------------------------------------------------

--Stored Procedure 
--DailyTransaction
CREATE PROCEDURE dbo.DailyTransaction
(
	@start_date DATE,
	@end_date DATE
)
AS
BEGIN
	SELECT
	CAST(TransactionDate AS DATE) AS Date,
	COUNT(*) AS TotalTransactions,
	SUM(Amount) AS TotalAmount
FROM dbo.FactTransaction
WHERE TransactionDate BETWEEN @start_date AND @end_date
GROUP BY CAST(TransactionDate AS DATE)
ORDER BY CAST(TransactionDate AS DATE)
END;

EXEC dbo.DailyTransaction @start_date = '2024-01-01', @end_date = '2024-01-31';


--------------------------------------------------------------------------------------------
--BalancePerCustomer

CREATE PROCEDURE dbo.BalancePerCustomerBI (@name VARCHAR(50))
AS
BEGIN
    WITH CurBalanceCTE AS (
        SELECT
            dc.CustomerName,
            da.AccountType,
            da.Balance,
            SUM(CASE
                WHEN fct.TransactionType = 'Deposit' THEN fct.Amount
                ELSE -fct.Amount
            END) AS TotalAmount
        FROM dbo.FactTransaction fct
        JOIN dbo.DimAccount da ON fct.AccountID = da.AccountID
        JOIN dbo.DimCustomer dc ON da.CustomerID = dc.CustomerID
        WHERE da.Status = 'active' AND dc.CustomerName LIKE UPPER(@name) + '%'
        GROUP BY dc.CustomerName, da.AccountType, da.Balance
    )
    SELECT
        CustomerName,
        AccountType,
        Balance,
        Balance + TotalAmount AS CurrentBalance
    FROM CurBalanceCTE;
END;

EXEC dbo.BalancePerCustomerBI @name = 'Shelly';