
DROP TABLE IF EXISTS ratings;
DROP TABLE IF EXISTS studied_cards;
DROP TABLE IF EXISTS cards;
DROP TABLE IF EXISTS decks;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id          IDENTITY,
    username    varchar(255) UNIQUE,
    password    varchar(255),
    points      int,
    role        varchar(255),
    last_login  bigint,
    PRIMARY KEY (id)
);

CREATE TABLE decks (
    id          IDENTITY,
    creator_id  int,
    title       varchar(255),
    created_on  bigint,
    status      int,
    PRIMARY KEY (id),
    FOREIGN KEY (creator_id) REFERENCES users(id) ON DELETE SET NULL
);

CREATE TABLE cards (
    id          IDENTITY,
    deck_id     int,
    question    varchar(255),
    answer      varchar(255),
    created_on  bigint,
    PRIMARY KEY (id),
    FOREIGN KEY (deck_id) REFERENCES decks(id) ON DELETE CASCADE
);

CREATE TABLE studied_cards (
    user_id     integer,
    card_id     integer,
    studied_on  bigint,
    PRIMARY KEY (user_id, card_id),
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (card_id) REFERENCES cards(id) ON DELETE CASCADE
);

CREATE TABLE ratings (
    user_id     integer,
    deck_id     integer,
    stars		integer,
    rated_on    bigint,
    PRIMARY KEY (user_id, deck_id),
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (deck_id) REFERENCES decks(id) ON DELETE CASCADE
);
