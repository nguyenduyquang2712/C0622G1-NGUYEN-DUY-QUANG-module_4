package com.codegym.dto;



import javax.validation.constraints.*;

public class UserDto {
    private int id;
    @NotEmpty(message = "Invalid")
    @Size(min = 5, max = 45)
    private String firstName;
    @NotNull
    @Size(min = 5, max = 45)
    private String lastName;
    @Pattern(regexp = "^[0-9]{9}$", message = "Phone number is a string of 9 digits")
    private String phoneNumber;
    @NotNull(message = "Please fill in the information")
    @Min(value = 18, message = "Age must be greater than or equal to 18")
    private int age;
    @NotEmpty
    @Email
    private String email;

    public UserDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    @Override
//    public boolean supports(Class<?> clazz) {
//        return false;
//    }

//    @Override
//    public void validate(Object target, Errors errors) {
//
//    }
}
