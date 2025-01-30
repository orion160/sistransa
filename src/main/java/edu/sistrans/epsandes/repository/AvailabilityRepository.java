package edu.sistrans.epsandes.repository;

import edu.sistrans.epsandes.model.AvailabilityScheduleEntity;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvailabilityRepository extends JpaRepository<AvailabilityScheduleEntity, Long> {
  List<AvailabilityScheduleEntity> findByHealthServiceIdAndAvailabilityDateBetween(
      Long healthServiceId, LocalDateTime startDate, LocalDateTime endDate);
}
