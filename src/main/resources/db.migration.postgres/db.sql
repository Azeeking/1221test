CREATE TABLE USERS
(
    id                  BIGSERIAL PRIMARY KEY,
    name                VARCHAR(100)        NOT NULL,
    email               VARCHAR(100) UNIQUE NOT NULL,
    age                 INT CHECK (age >= 18 AND age <= 100),
    height              INT CHECK (height >= 50 AND height <= 250),
    weight              INT CHECK (weight >= 20 AND weight <= 300),
    purpose             VARCHAR(255)        NOT NULL,
    daily_calories_goal INT
);

CREATE TABLE DISHES
(
    id       BIGSERIAL PRIMARY KEY,
    name     VARCHAR(255) NOT NULL,
    calories INT CHECK (calories >= 0),
    proteins FLOAT CHECK (proteins >= 0)
);

CREATE TABLE MEALS
(
    id        BIGSERIAL PRIMARY KEY,
    date      DATE         NOT NULL,
    meal_type VARCHAR(255) NOT NULL,
    user_id   BIGINT       NOT NULL,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE meal_dishes
(
    meal_id BIGINT NOT NULL,
    dish_id BIGINT NOT NULL,
    CONSTRAINT fk_meal FOREIGN KEY (meal_id) REFERENCES meals(id) ON DELETE CASCADE,
    CONSTRAINT fk_dish FOREIGN KEY (dish_id) REFERENCES dishes(id) ON DELETE CASCADE,
    PRIMARY KEY (meal_id, dish_id)
);
