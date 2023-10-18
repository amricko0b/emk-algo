create view tg_player_report as (
    select tcp.nick_name "nick_name", count(distinct tc.id) "total_contests"
        from tg_contest_player tcp
        left join tg_contest tc
            on tc.id = tcp.contest_id
        group by tcp.nick_name
);
