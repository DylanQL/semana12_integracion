package com.tecsup.petclinic.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author [Your Name]
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class VetTO {

    private Integer id;

    private String firstName;

    private String lastName;

}