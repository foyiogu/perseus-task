package com.perseus.task.payload.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.perseus.task.validator.annotation.ValidContact;
import com.perseus.task.validator.annotation.ValidContactType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@ValidContact
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserUpdateContactRequest implements Serializable {
    @NotNull(message = "Please enter user id")
    private Long userId;

    @NotNull(message = "Please enter contact-type")
    @ValidContactType
    private String contactType;

    @JsonIgnore
    @Min(value = 9, message = "Please enter your old number")
    private String oldPhoneNumber;

    @JsonIgnore
    @Min(value = 9, message = "Please enter your new number")
    private String newPhoneNumber;

    @Email(message = "Please enter valid email")
    @JsonIgnore
    private String oldEmailContact;

    @Email(message = "Please enter valid email")
    @JsonIgnore
    private String newEmailContact;
}
