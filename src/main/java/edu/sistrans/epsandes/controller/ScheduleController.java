package edu.sistrans.epsandes.controller;

import edu.sistrans.epsandes.dto.AvailabilityScheduleDTO;
import edu.sistrans.epsandes.service.AvailabilityScheduleService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {
  @Autowired private AvailabilityScheduleService availabilityService;

  @GetMapping("availability")
  public List<AvailabilityScheduleDTO> getAvailability(@RequestParam Long healthServiceId) {

    if (healthServiceId == 1) {
      return List.of(
          new AvailabilityScheduleDTO("cirugia", LocalDateTime.now(), "salucoop", "rasputin"),
          new AvailabilityScheduleDTO("foo", LocalDateTime.now(), "aa", "aaa"));
    }

    final var availabilities = availabilityService.getAvailabilityForNextFourWeeks(healthServiceId);

    final var availabilityDTOs =
        availabilities.stream()
            .map(
                avail ->
                    new AvailabilityScheduleDTO(
                        avail.getHealthService().getName(),
                        avail.getAvailabilityDate(),
                        avail.getIps().getName(),
                        avail.getDoctor().getName()))
            .collect(Collectors.toList());

    return availabilityDTOs;
  }
}
