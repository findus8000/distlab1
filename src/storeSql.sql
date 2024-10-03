-- Create the database
CREATE DATABASE ecommerce;


-- Use the newly created database
USE ecommerce;


-- Creating ProductCategory table
CREATE TABLE ProductCategory (
                                 CategoryID INT PRIMARY KEY,
                                 CategoryName NVARCHAR(255) NOT NULL
);

-- Creating Product table
CREATE TABLE Product (
                         ProductID INT PRIMARY KEY,
                         ProductName NVARCHAR(255) NOT NULL,
                         Price DECIMAL(10, 2) NOT NULL,
                         StockQuantity INT NOT NULL,
                         CategoryID INT,
                         FOREIGN KEY (CategoryID) REFERENCES ProductCategory(CategoryID) ON DELETE SET NULL
);

-- Creating Customer table
CREATE TABLE Customer (
                          CustomerID INT PRIMARY KEY,
                          FirstName NVARCHAR(50) NOT NULL,
                          LastName NVARCHAR(50) NOT NULL,
                          Email NVARCHAR(255) NOT NULL UNIQUE,  -- Ensuring unique emails for customers
                          PhoneNumber NVARCHAR(15),
                          PasswordHash NVARCHAR(255) NOT NULL -- Hashed and salted password
);

-- Creating OrderHeader table
CREATE TABLE OrderHeader (
                             OrderID INT PRIMARY KEY,
                             CustomerID INT,
                             OrderDate DATETIME NOT NULL,  -- Set default order date to current date
                             TotalAmount DECIMAL(10, 2) NOT NULL,
                             ShippingAddress NVARCHAR(255),  -- Increased size for addresses
                             BillingAddress NVARCHAR(255),    -- Increased size for addresses
                             OrderStatus NVARCHAR(50) NOT NULL, -- Pending, Shipped, Delivered, etc.
                             FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID) ON DELETE CASCADE
);

-- Creating OrderDetail table
CREATE TABLE OrderDetail (
                             OrderDetailID INT PRIMARY KEY,
                             OrderID INT,
                             ProductID INT,
                             Quantity INT NOT NULL CHECK (Quantity > 0), -- Ensure quantity is positive
                             Subtotal DECIMAL(10, 2) NOT NULL,
                             FOREIGN KEY (OrderID) REFERENCES OrderHeader(OrderID) ON DELETE CASCADE,
                             FOREIGN KEY (ProductID) REFERENCES Product(ProductID) ON DELETE CASCADE
);
