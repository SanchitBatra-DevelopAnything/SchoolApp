package com.sbgu.admissionservice.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class BasicSchoolData {

    private String name;

    private String website;

    private String location_latitude;
    private String location_longitude;
}
