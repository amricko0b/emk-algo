create view tg_contest_report as (
    select tgc.game_name "game_name", count(distinct tgp.nick_name) "total_players", count(distinct tgc.id) "total_contests"
        from tg_contest tgc
        inner join tg_contest_player tgp
            on tgp.contest_id = tgc.id
        group by tgc.game_name
);
