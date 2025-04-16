package chursov.patterns.builder;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder(toBuilder = true)
public class Company {
    private String name;
    private String industry;
    private String country;
    private String city;
    private int foundedYear;
    private int numberOfEmployees;
    private double revenueInMillions;
    private boolean isPublic;
    private String ceo;
    private LocalDate registrationDate;
    private List<String> techStack;
}
