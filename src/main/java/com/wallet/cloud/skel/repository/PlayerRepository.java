package com.wallet.cloud.skel.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wallet.cloud.skel.model.*;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

	@Query("FROM Player WHERE name= ?1")
	Player findByName(String name);
    List<Player> findAll();
    Player save(Player pl);

}