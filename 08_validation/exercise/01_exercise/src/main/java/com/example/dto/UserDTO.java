package com.example.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class UserDTO implements Validator {

    private Integer id;

    @NotBlank(message = "First name is not  blank")
    @Size(min = 5,max = 45,message = "First name must between 5 and 45 characters")
    private String firstName;

    @NotBlank(message = "Last name is not blank")
    @Size(min = 5,max = 45,message = "Last name must between 5 and 45 characters")
    private String lastName;

    @NotBlank(message = "Number phone is not blank")
    @Pattern(regexp = "^0[0-9]{9}$",message = "Phone number must start with 0 and have 10 digits")
    private String numberPhone;

    @NotBlank(message = "Age is not black")
    //dùng cho chuỗi
    @Min(value = 18,message = "age must be over 18")
    @Max(value = 100,message = "age must be under 100")
    private String age;

    @NotBlank(message ="Email is not black")
    @Email(message = "Email entered wrong format")
    private String email;

    public UserDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDTO userDTO = (UserDTO) target;

    }
}
