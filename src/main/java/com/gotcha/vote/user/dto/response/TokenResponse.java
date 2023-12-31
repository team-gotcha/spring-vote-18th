package com.gotcha.vote.user.dto.response;

import com.gotcha.vote.user.domain.PartName;
import com.gotcha.vote.user.domain.TeamName;
import com.gotcha.vote.user.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TokenResponse {
    private String accessToken;
    private String name;
    private PartName partName;
    private TeamName teamName;

    @Builder
    public TokenResponse(String accessToken, String name, PartName partName, TeamName teamName) {
        this.accessToken = accessToken;
        this.name = name;
        this.partName = partName;
        this.teamName = teamName;
    }

    public static TokenResponse from(String accessToken, User selectedUser) {
        return TokenResponse.builder()
                .accessToken(accessToken)
                .name(selectedUser.getName())
                .partName(selectedUser.getPartName())
                .teamName(selectedUser.getTeamName())
                .build();
    }

}