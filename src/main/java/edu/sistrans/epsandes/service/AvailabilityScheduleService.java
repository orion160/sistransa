package edu.sistrans.epsandes.service;

import edu.sistrans.epsandes.model.AvailabilityScheduleEntity;
import edu.sistrans.epsandes.repository.AvailabilityRepository;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvailabilityScheduleService {
  @Autowired private AvailabilityRepository availabilityRepository;

  public List<AvailabilityScheduleEntity> getAvailabilityForNextFourWeeks(Long healthServiceId) {
    final var now = LocalDateTime.now();
    final var end = now.plusWeeks(4);

    return availabilityRepository.findByHealthServiceIdAndAvailabilityDateBetween(
        healthServiceId, now, end);
  }
}
