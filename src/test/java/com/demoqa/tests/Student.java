package com.demoqa.tests;

import com.github.javafaker.Faker;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Student {

    Faker faker = new Faker();

    private enum Genders {
        M("Male"), F("Female"), O("Other");

        private String genderName;

        Genders(String value) {
            this.genderName = value;
        }

        public String getGenderName() {
            return genderName;
        }
    }

    private enum Subjects {
        MATHS("Maths"), CHE("Chemistry"), CS("Computer Science");

        private String subjectName;

        Subjects(String name) {
            this.subjectName = name;
        }

        public String getSubjectName() {
            return subjectName;
        }
    }

    private enum Hobbies {
        SPORTS("Sports"), READING("Reading"), MUSIC("Music");

        private String hobbyName;

        Hobbies(String name) {
            this.hobbyName = name;
        }

        public String getHobbyName() {
            return hobbyName;
        }
    }

    //information about student
    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userNumber = faker.phoneNumber().subscriberNumber(10),
            subject = faker.options().option(Subjects.values()).getSubjectName(),
            gender = faker.options().option(Genders.values()).getGenderName(),
            hobby = faker.options().option(Hobbies.values()).getHobbyName(),
            imgFileName = "pic.png",
            currentAddress = faker.address().streetAddress(),
            state = "Uttar Pradesh",
            city = "Lucknow";

    private Date dateOfBirth = faker.date().birthday(16, 40);
    Locale loc = new Locale("en", "US");

    public String dateOfBirthDay = new SimpleDateFormat("dd",loc).format(dateOfBirth);
    public String dateOfBirthMonth = new SimpleDateFormat("MMMM",loc).format(dateOfBirth);
    public String dateOfBirthYear = new SimpleDateFormat("yyyy",loc).format(dateOfBirth);

    public String dateOfBirthFullFormat = String.format("%s %s,%s", dateOfBirthDay, dateOfBirthMonth, dateOfBirthYear);

}
