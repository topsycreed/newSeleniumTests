import chursov.patterns.builder.Company;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class BuilderTests {
    @Test
    void builderTest() {
        Company company = Company.builder()
                .name("TechNova")
                .industry("Software")
                .country("Serbia")
                .city("Belgrade")
                .foundedYear(2015)
                .numberOfEmployees(150)
                .revenueInMillions(12.5)
                .isPublic(false)
                .ceo("Gennady Chursov")
                .registrationDate(LocalDate.of(2015, 6, 1))
                .techStack(Arrays.asList("Java", "Spring", "React", "Docker"))
                .build();

        assertNotNull(company);
        assertEquals("TechNova", company.getName());
    }

    @Test
    void builderUpdateTest() {
        Company initialCompany = Company.builder()
                .name("TechNova")
                .industry("Software")
                .country("Serbia")
                .city("Belgrade")
                .foundedYear(2015)
                .numberOfEmployees(150)
                .revenueInMillions(12.5)
                .isPublic(false)
                .ceo("Gennady Chursov")
                .registrationDate(LocalDate.of(2015, 6, 1))
                .techStack(Arrays.asList("Java", "Spring", "React", "Docker"))
                .build();
        Company newCompany = initialCompany.toBuilder()
                .name("NovaSoft")
                .build();

        assertNotNull(newCompany);
        assertEquals("NovaSoft", newCompany.getName());
        assertEquals("Software", newCompany.getIndustry());
    }
}
