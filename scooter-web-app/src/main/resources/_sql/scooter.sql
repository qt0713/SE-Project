-- Drop tables if they exist to avoid conflicts
DROP TABLE IF EXISTS Feedback;
DROP TABLE IF EXISTS Payment;
DROP TABLE IF EXISTS Booking;
DROP TABLE IF EXISTS CreditCard;
DROP TABLE IF EXISTS UserDiscount;
DROP TABLE IF EXISTS Scooter;
DROP TABLE IF EXISTS RentalOption;

-- Create RentalOption table
CREATE TABLE RentalOption (
    id VARCHAR(20) PRIMARY KEY,
    option_name VARCHAR(50) NOT NULL,
    duration_hours INT NOT NULL,
    base_price DECIMAL(10, 2) NOT NULL,
    description TEXT,
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

-- Create UserDiscount table
CREATE TABLE UserDiscount (
    id VARCHAR(20) PRIMARY KEY,
    user_id VARCHAR(20) NOT NULL,
    discount_type ENUM('FREQUENT_USER', 'STUDENT', 'SENIOR') NOT NULL,
    discount_percentage DECIMAL(5, 2) NOT NULL,
    valid_from DATE NOT NULL,
    valid_until DATE,
    proof_document VARCHAR(255),
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES CLIENT_USER(ID)
) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

-- Create CreditCard table (encrypted storage would be implemented at application level)
CREATE TABLE CreditCard (
    id VARCHAR(20) PRIMARY KEY,
    user_id VARCHAR(20) NOT NULL,
    card_number VARCHAR(255) NOT NULL, -- Would be encrypted
    card_holder VARCHAR(100) NOT NULL,
    expiry_date VARCHAR(10) NOT NULL, -- Format: MM/YY
    cvv VARCHAR(255), -- Would be encrypted
    is_default BOOLEAN DEFAULT FALSE,
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES CLIENT_USER(ID)
) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

-- Create Scooter table
CREATE TABLE Scooter (
    id VARCHAR(20) PRIMARY KEY,
    model VARCHAR(50) NOT NULL,
    status ENUM('AVAILABLE', 'UNAVAILABLE', 'MAINTENANCE') NOT NULL DEFAULT 'AVAILABLE',
    location VARCHAR(20) , -- Location String (e.g., '(Latitude, Longitude)')
    battery_level INT NOT NULL DEFAULT 100,
    last_maintenance_date DATETIME,
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

-- Create Booking table
CREATE TABLE Booking (
    id VARCHAR(20) PRIMARY KEY,
    user_id VARCHAR(20),
    scooter_id VARCHAR(20) NOT NULL,
    option_id VARCHAR(20) NOT NULL,
    start_time DATETIME NOT NULL,
    end_time DATETIME NOT NULL,
    status ENUM('PENDING', 'ACTIVE', 'COMPLETED', 'CANCELLED', 'EXTENDED') NOT NULL DEFAULT 'PENDING',
    total_price DECIMAL(10, 2) NOT NULL,
    booking_reference VARCHAR(50) UNIQUE NOT NULL,
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES CLIENT_USER(ID),
    FOREIGN KEY (scooter_id) REFERENCES Scooter(id),
    FOREIGN KEY (option_id) REFERENCES RentalOption(id)
) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

-- Create Payment table
CREATE TABLE Payment (
    id VARCHAR(20) PRIMARY KEY,
    booking_id VARCHAR(20) NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    payment_method ENUM('CREDIT_CARD', 'CASH', 'OTHER') NOT NULL,
    card_id VARCHAR(20),
    transaction_reference VARCHAR(100) NOT NULL,
    status ENUM('PENDING', 'COMPLETED', 'FAILED', 'REFUNDED') NOT NULL,
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (booking_id) REFERENCES Booking(id),
    FOREIGN KEY (card_id) REFERENCES CreditCard(id)
) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

-- Create Feedback table
CREATE TABLE Feedback (
    id VARCHAR(20) PRIMARY KEY,
    user_id VARCHAR(20),
    scooter_id VARCHAR(20),
    booking_id VARCHAR(20),
    feedback_text TEXT NOT NULL,
    priority ENUM('LOW', 'MEDIUM', 'HIGH') NOT NULL DEFAULT 'LOW',
    status ENUM('OPEN', 'IN_PROGRESS', 'RESOLVED') NOT NULL DEFAULT 'OPEN',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES CLIENT_USER(ID),
    FOREIGN KEY (scooter_id) REFERENCES Scooter(id),
    FOREIGN KEY (booking_id) REFERENCES Booking(id)
) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

-- Insert sample data for rental options
INSERT INTO RentalOption (id, option_name, duration_hours, base_price, description) VALUES
('OPT1', '1 Hour Rental', 1, 9.99, 'Short trip around town'),
('OPT2', '4 Hour Rental', 4, 24.99, 'Half-day exploration'),
('OPT3', 'Day Rental', 24, 49.99, 'Full day adventure'),
('OPT4', 'Week Rental', 168, 199.99, 'Weekly rental with significant discount');
