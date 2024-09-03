# Welcome to StarMap<⭐️>


*Mapping the Stars, One Click at a Time*

## 🌌 Overview
**StarMap<⭐️>** is your gateway to the cosmos! With the magic of NASA's Astronomy Picture of the Day (APOD) API, we bring you breathtaking images and fascinating insights about our universe, right at your fingertips. Whether you're an astrophysics aficionado or a casual stargazer, StarMap<⭐️> has something for everyone.

But StarMap<⭐️> is more than just eye candy. It’s a platform designed for deep dives into the science behind the stars, with opportunities for users to contribute their own cosmic musings. We combine the best of technology and astronomy to create an educational, engaging, and—let’s face it—downright fun experience.

## 🚀 Business Use Cases
1. **Astronomy Picture of the Day (APOD)**:
    - **Daily Cosmic Delights**: Automatically fetch and display the latest APOD from NASA, complete with descriptions and credits. Perfect for anyone needing a daily dose of the universe's beauty.
    - **Deep Space Exploration**: Users can search for APODs by date or request a random picture—ideal for generating ideas for blog posts, classroom materials, or just satisfying curiosity.

2. **Astrophysics Writing and Content Creation**:
    - **Cosmic Blog**: StarMap<⭐️> provides a dedicated space for writing and sharing articles on astrophysics. Whether you're breaking down the mysteries of black holes or exploring the life cycle of stars, there's a place for your thoughts here.
    - **Educator’s Corner**: Teachers and science communicators can use StarMap<⭐️> to create and share lesson plans, complete with stunning visuals and scientific data from NASA (coming soon!).

3. **Dedicated Website for Astronomical Content**:
    - **A Hub for Astro Enthusiasts**: A one-stop-shop for everything astronomy—articles, images, and community discussions. It's like having your own corner of the universe on the internet.
    - **Collaborative Space**: StarMap<⭐️> fosters a community of like-minded individuals who can share ideas, provide feedback, and grow their understanding of the cosmos together.

## 🧠 Learning Experiences
Building StarMap<⭐️> has been a journey through the stars—literally and figuratively. Here are a few things we learned along the way:

1. **Integrating OAuth2**: Implementing OAuth2 for Google and GitHub taught us the intricacies of secure authentication, while ensuring a smooth user experience.
2. **Handling NASA’s APOD API**: Fetching and managing external data from the APOD API required fine-tuning to the backend for reliability (custom deserializers coming!).
3. **Spring Security and Custom Authentication**: Combining traditional form-based login with OAuth2 was a challenge, but it also taught us the importance of flexible security configurations.
4. **Spring Modulith**: As we prepare to modularize StarMap<⭐️>, we're excited to dive into Spring Modulith, event buses, and improving transactional boundaries with a Domain Driven Design. The goal? A more maintainable, scalable, and responsive application.

## 🌟 Additional Features in the Works
- **Spring Modulith**: We’re working on modularizing the app to improve scalability and maintainability.
- **Event Buses**: Integrating event-driven architecture for better decoupling and responsiveness.
- **Improved Transactional Boundaries**: Enhancing the transactional management to ensure data integrity and performance.

## 🛠️ How to Fork, Clone, and Set Up StarMap<⭐️>

### Fork and Clone the Repository
1. **Fork the Repository**:
    - Head over to the [StarMap<⭐️> GitHub repository](https://github.com/your-repo-link-here).
    - Click the "Fork" button at the top right of the page to create a copy of the repository under your GitHub account.

2. **Clone the Repository**:
    - Open your terminal.
    - Run the following command to clone the forked repository to your local machine:
      ```bash
      git clone https://github.com/your-username/StarMap.git
      ```
    - Navigate into the project directory:
      ```bash
      cd StarMap
      ```

### Setup the Project
1. **Environment Setup**:
    - Ensure you have Java 21 or higher installed.
    - Make sure Maven is installed and configured properly on your machine.
    - Install PostgreSQL and set up a database for the project.

2. **Configure Environment Variables**:
    - Create an `application.properties` file in the `src/main/resources` directory, or use the provided `.env` file for environment-specific configurations.
    - Add your NASA API key and OAuth2 client credentials:
      ```properties
      spring.security.oauth2.client.registration.google.client-id=your-google-client-id
      spring.security.oauth2.client.registration.google.client-secret=your-google-client-secret
      spring.security.oauth2.client.registration.github.client-id=your-github-client-id
      spring.security.oauth2.client.registration.github.client-secret=your-github-client-secret
      nasa.api.key=your-nasa-api-key
      ```

3. **Run the Application**:
    - Use Maven to build and run the application:
      ```bash
      mvn clean install
      mvn spring-boot:run
      ```
    - The application should now be running on `http://localhost:8080`.

## ✨ Application Overview

### Models
1. **Post**:
    - Full CRUD functionality with corresponding controller, repository, and service layers.
    - Users can create, read, update, and delete posts.

2. **Security**:
    - **OAuth2 Integration**: Supports login via GitHub and Google.
    - **Custom Form Login**: Features a traditional form-based login system with a `Users` model and a `SecurityUser` class that implements `UserDetails`.

3. **APOD (Astronomy Picture of the Day)**:
    - Represents the APOD fetched from NASA’s API.
    - Users can access the daily APOD, request a random one, and search by date.

### Front-End Design
- **Punny Sign-Up Page**: A space-themed design that’s out of this world, with a go-to-market strategy that’s as catchy as it is clever.

## 🌠 Go-To-Market Strategy
- **Launch with a Bang**: Like the Big Bang, our launch strategy is all about explosive growth! We’ll use the captivating beauty of space to draw in users and keep them engaged with our unique content offerings.

## ✨ License

### You are licensed to learn and have fun!

## 💫 Conclusion
StarMap<> is more than just an application—it’s a journey through the cosmos. We’re excited to continue expanding its capabilities, and we invite you to join us as we explore the universe together. Whether you’re contributing to our blog, gazing at the stars, or diving into the wonders of astrophysics, there’s a place for you in the StarMap<> community.

Feel free to reach out if you have any questions, ideas, or just want to talk about the universe!

Happy stargazing! 🚀✨