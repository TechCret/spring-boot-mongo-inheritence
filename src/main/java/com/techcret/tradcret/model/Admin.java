package com.techcret.tradcret.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "users")
@TypeAlias("admin")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Admin extends User implements Serializable {

    private String firstName;
    private String middleName;

}
