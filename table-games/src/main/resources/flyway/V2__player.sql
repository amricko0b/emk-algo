create table tg_player (
  guid      uuid    not null  primary key,
  nick_name varchar not null
);

create index
  on tg_player (nick_name);
