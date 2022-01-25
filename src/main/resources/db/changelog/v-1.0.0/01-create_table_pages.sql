--changeset author:com.gmail.rak.aleh

CREATE TABLE IF NOT EXISTS pages(
    slug         varchar(50) primary key not null,
    title        varchar(255)            not null,
    description  varchar(255)            not null,
    menu_label   varchar(255)            not null,
    h1           varchar(50)             not null,
    content      text,
    published_at timestamptz default now(),
    priority     int                     not null
);