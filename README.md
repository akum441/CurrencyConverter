Currency Converter
Currency Converter is a web application that allows users to convert between different currencies. It provides a simple HTML interface for users to input source currency, target currency, and the source amount. The application then calculates the target amount based on the current exchange rate and displays the result to the user.

Features
Convert between currencies: Users can select the source and target currencies from a predefined list of supported currencies.
Accurate Exchange Rates: The application fetches real-time exchange rates from a currency conversion API to ensure accurate conversions.
Currency Formatting: The application handles currency formatting correctly, taking into account the decimal places for each currency (e.g., USD uses 2 decimal places, JPY uses 0 decimal places).
Error Handling: Error handling is implemented for invalid input or API errors to provide a seamless user experience.

Prerequisites
Before running the application, make sure you have the following:
Java Development Kit (JDK) installed on your system. version 17 
Maven build tool installed. 3+

Getting Started
Step 1: Clone the Repository
If you haven't already, clone the Currency Converter repository to your local machine using the following command:
git clone https://github.com/akum441/CurrencyConverter.git
Step 2: Configure Currency Conversion API
Configure the application to use the Currency Conversion API of your choice. You may need to update the API endpoint and any required authentication details in your application's configuration.

Step 3: Build the Application
Navigate to the project's root directory and build the application using Maven:
cd currency-converter
mvn clean install
Step 4: Run the Application
You can run the application using the following Maven command:
mvn spring-boot:run
The Spring Boot application will start, and you'll see log messages indicating that the server has started.

Step 5: Access the Application
Once the application is running, you can access it in your web browser by navigating to:
http://localhost:8080
