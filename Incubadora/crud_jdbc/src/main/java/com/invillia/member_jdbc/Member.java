package com.invillia.member_jdbc;

import java.util.StringJoiner;

public class Member {
    private final long id;
    private String name;
    private long team_id;

    public Member(long id, String name, long team_id) {
        this.id = id;
        this.name = name;
        this.team_id = team_id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getTeam_id() {
        return team_id;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", "Member(", ")")
                .add("id=" + id)
                .add("name=" + name)
                .add("team_id=" + team_id)
                .toString();
    }
}

