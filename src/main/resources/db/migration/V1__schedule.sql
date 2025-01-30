CREATE TABLE health_services (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE ips (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE doctors (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE availability_schedules (
    id SERIAL PRIMARY KEY,
    health_service_id INT NOT NULL,
    availability_date TIMESTAMP NOT NULL,
    ips_id INT NOT NULL,
    doctor_id INT NOT NULL,
    FOREIGN KEY (health_service_id) REFERENCES health_services(id) ON DELETE CASCADE,
    FOREIGN KEY (ips_id) REFERENCES ips(id) ON DELETE CASCADE,
    FOREIGN KEY (doctor_id) REFERENCES doctors(id) ON DELETE CASCADE
);
