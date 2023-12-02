package com.umc.springboot.repository;

import com.umc.springboot.domain.mapping.MemberMission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    boolean existsByMissionId(Long missionId);

    boolean existsByMemberIdAndMissionId(Long memberId, Long MissionId);
}
