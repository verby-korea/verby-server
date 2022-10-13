package com.verby.restapi.contest.command.domain;

import org.springframework.data.repository.Repository;

public interface ContestRepository extends Repository<Contest, Long> {

    Contest save(Contest contest);

}
