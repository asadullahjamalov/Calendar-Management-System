package com.company.calendarmanagementsystem.util;

import com.company.calendarmanagementsystem.entity.ColorType;
import com.company.calendarmanagementsystem.entity.UserEvent;
import com.company.calendarmanagementsystem.repository.ColorTypeRepo;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ColorAssigningUtil {
    private final ColorTypeRepo colorTypeRepo;

    public ColorAssigningUtil(ColorTypeRepo colorTypeRepo) {
        this.colorTypeRepo = colorTypeRepo;
    }

    public UserEvent setColorTypeByDate(UserEvent userEvent) {
        List<ColorType> sortedColorTypes = colorTypeRepo.getOrdinaryColorTypes()
                .stream()
                .sorted(Comparator.comparingInt(ColorType::getActivationDay))
                .collect(Collectors.toList());

        int counter = 0;
        for (ColorType colorType : sortedColorTypes) {
            if (userEvent.getDate().isBefore(LocalDate.now().plusDays(colorType.getActivationDay()))) {
                userEvent.setColorType(colorType);
                break;
            }
            counter++;
        }
        if (counter == sortedColorTypes.size()) {
            userEvent.setColorType(colorTypeRepo.getDefaultColorType());
        }
        return userEvent;
    }
}
