package com.banco.digital.resources;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract interface BaseRepository<Entities extends BaseEntity> extends JpaRepository<Entities, Integer> {

}
