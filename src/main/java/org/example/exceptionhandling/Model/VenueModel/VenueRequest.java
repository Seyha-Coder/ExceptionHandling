package org.example.exceptionhandling.Model.VenueModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VenueRequest {
    String name;
    String location;
}
