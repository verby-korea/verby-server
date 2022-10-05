package com.verby.restapi.user.command.application;

import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface CertificationRepository extends Repository<Certification, String> {

    Certification save(Certification certification);

    Optional<Certification> findByPhone(String phone);

}
