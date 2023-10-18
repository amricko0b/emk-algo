create sequence tg_ids_seq
    start with 1
    increment by 50
    no maxvalue;

create table tg_contest (
    id bigint not null primary key,
    game_name varchar not null,
    ticket_price decimal not null
);
