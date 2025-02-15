# 🌍 Ride-Share Travel App 🚗💨

Welcome to the **Ride-Share Travel App**, a community-driven platform for carpooling between towns! 🏙️➡️🌆 Save money, meet new people, and travel smarter! 🌟

---

## ✨ Features
- 🚘 **Post Available Seats** – Drivers can share their empty seats for a shared ride.
- 🎒 **Find a Ride** – Passengers can search for available seats in cars.
- 🔎 **Easy Search & Filtering** – Find the perfect ride based on location and timing.
- 📍 **Location-Based Suggestions** – Get smart ride recommendations.
- 🔐 **Secure & Simple** – Seamless experience for both drivers and passengers.

---

## 🚀 Getting Started

### Prerequisites ✅
Before running the project, ensure you have the following installed:

- **Java 17** ☕
- **Spring Boot** 🏗️
- **PostgreSQL 16.3** 🗄️
- **Maven** 📦

### 🛠️ Setup & Run Backend (Spring Boot)

1. **Clone the repository** 📂
   ```sh
   git clone https://github.com/Polclard/EasyTravel.git
   cd EasyTravel
   ```
2. **Configure database** 🗄️
    - Update `application.properties` in `src/main/resources/` with your PostgreSQL settings:
      ```properties
      spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
      spring.datasource.username=username
      spring.datasource.password=password 
      #Change your db username and password
      ```
3. **Build & run the app** 🚀
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```
4. **Access the API** 🌐
    - The backend will be running at: `http://localhost:8084`

---

## 🌟 Contributing
Contributions are welcome! Feel free to submit issues and pull requests. 🙌

---

## 👥 Contact
For questions or feedback, reach out to **esi.asmino@gmail.com** 📧

Happy Carpooling! 🚀🚘💨
