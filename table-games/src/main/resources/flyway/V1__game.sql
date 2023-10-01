create table tg_game (
  guid  uuid    not null  primary key,
  title  varchar not null
);

create index
  on tg_game (title);
