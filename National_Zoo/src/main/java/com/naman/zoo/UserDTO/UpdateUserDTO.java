package com.naman.zoo.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UpdateUserDTO {

	private String firstName;
    private String lastName;
    private AddressDTO address; // Nested AddressDTO

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddressDTO {
        private String street;
        private String zipCode;
        private CityDTO city; // Nested CityDTO
        private String createdBy;
        
        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class CityDTO {
            private Long cityId;
        }
    }
}