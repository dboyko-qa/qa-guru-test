package com.demoqa.tests;

import com.github.javafaker.Faker;
import com.demoqa.utils.Utils.*;

import static com.demoqa.utils.Utils.*;

public class Student {

    Faker faker = new Faker();

    //value arrays
    static String[] genders = {"Male", "Female", "Other"};
    static String[] subjects = {"Maths", "Chemistry", "Computer Science"};
    static String[] hobbies = {"Sports", "Reading", "Music"};


    //information about student
    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userNumber = faker.phoneNumber().subscriberNumber(10),
            subject = getRandomFromArray(subjects),
            dateOfBirthDay = "05",
            dateOfBirthMonth = "October",
            dateOfBirthYear = "2007",
            gender = getRandomFromArray(genders),
            hobby = getRandomFromArray(hobbies),
            imgFileName = "pic.png",
            currentAddress = faker.address().streetAddress(),
            state = "Uttar Pradesh",
            city = "Lucknow";

    public String dateOfBirthFullFormat = String.format("%s %s,%s", dateOfBirthDay, dateOfBirthMonth, dateOfBirthYear);


}
