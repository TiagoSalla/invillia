package com.invillia.member_jdbc;

public class UpdateMemberRequest {
    private String name;
    private long team_id;

    public UpdateMemberRequest(String name, long team_id) {
        this.name = name;
        this.team_id = team_id;
    }

    public String getName() {
        return name;
    }

    public long getTeam_id() {
        return team_id;
    }
}
