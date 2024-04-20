package taba.tabaServer.tabaserver.dto.drivingsessiondto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import taba.tabaServer.tabaserver.enums.DrivingStatus;

import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
public record DrivingSessionRequestDto(
        @JsonProperty("userId") Long userId,
        @JsonProperty("startTime")LocalDateTime startTime,  //프론트에서 넘길지, 백에서 처리할지 상의 필요
        @JsonProperty("drivingStatus")DrivingStatus drivingStatus
        ) implements Serializable {
            public static DrivingSessionRequestDto of(
                    final Long userId,
                    final LocalDateTime startTime,
                    final DrivingStatus drivingStatus
            ) {
                return DrivingSessionRequestDto.builder()
                        .userId(userId)
                        .startTime(startTime)
                        .drivingStatus(drivingStatus)
                        .build();
            }
}