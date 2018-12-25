package com.ruolin.respository;

import com.ruolin.model.equipment;
import org.springframework.data.repository.CrudRepository;

public interface EquipRepository extends CrudRepository<equipment, Long> {
}
