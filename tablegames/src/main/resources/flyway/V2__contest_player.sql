create table tg_contest_player (
    nick_name varchar not null,
    contest_id bigint not null,

    foreign key (contest_id)
        references tg_contest (id)
);
