# CakeStudio

CakeStudio is a Java application built using `Eclipse Temurin JDK 17`. It is a platform for managing cake recipes and orders.
- **Installation**

    - Ensure you have Docker installed on your machine.

    - Clone this repository to your local machine.

    - Navigate to the root directory of the project.

    - Build the Docker image using the provided Dockerfile:

```
    docker build -t cakestudio .
```

**Usage**

To run the CakeStudio application, execute the following command:
```bash
docker run -p 8080:8080 cakestudio
```

Access the application by navigating to `http://localhost:8080` in your web browser.

**Dependencies**

CakeStudio relies on the following dependencies:

- **Eclipse Temurin JDK 17**
- **Maven Wrapper (included in the project)**
- **PostgreSQL (database)**

**Contributing**

Contributions are welcome! Please fork this repository and submit a pull request.
License

This project is licensed under the `MIT License`.

---

# PostgreSQL Database

This is a PostgreSQL database instance used by the CakeStudio application.

- **Installation**

    - Ensure you have Docker installed on your machine.
    - Clone this repository to your local machine.
    - Navigate to the root directory of the project.

- **Usage**

To run the PostgreSQL database, execute the following command:


```bash
docker run -p 5432:5432 -e POSTGRES_PASSWORD=password postgres
```

This will start the PostgreSQL server with the default username postgres and password password.

- **Initialization**

The database schema will be automatically initialized using the provided SQL script located at /data/Query_to_Database.sql. This script will be executed when the container starts up.

- **Contributing**

Contributions are welcome! Please fork this repository and submit a pull request.

- **License**

This project is licensed under the `MIT License`.
