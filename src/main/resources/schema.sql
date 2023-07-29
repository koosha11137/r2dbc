CREATE TABLE IF NOT EXISTS tutorial (id INT NOT NULL GENERATED ALWAYS AS IDENTITY , title VARCHAR(255), description VARCHAR(255), published BOOLEAN, PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS persons (id INT NOT NULL  GENERATED ALWAYS AS IDENTITY, first_name VARCHAR(255), last_name VARCHAR(255),phone_number VARCHAR(15), PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS person_course (id INT NOT NULL  GENERATED ALWAYS AS IDENTITY,person_id INT NOT NULL ,course_id  INT NOT NULL,PRIMARY KEY (id));