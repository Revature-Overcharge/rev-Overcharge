
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
    role        int,
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

CREATE TABLE feedbacks (
    id          IDENTITY,
    deck_id     int,
    content     varchar(255),
    created_on  bigint,
    FOREIGN KEY (deck_id) REFERENCES decks(id) ON DELETE CASCADE
);

CREATE TABLE tags (
    id          IDENTITY,
    tag         varchar(255),
    PRIMARY KEY (id)
);

CREATE TABLE deck_tag (
    id          IDENTITY,
    deck_id  int,
    tag_id  int,
    PRIMARY KEY (id),
    FOREIGN KEY (deck_id) REFERENCES decks(id) ON DELETE SET NULL,
    FOREIGN KEY (tag_id) REFERENCES tags(id) ON DELETE SET NULL
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
