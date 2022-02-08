package com.camcop.outfitmixer.repo;

import com.camcop.outfitmixer.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends JpaRepository<Item, Long> {


}
