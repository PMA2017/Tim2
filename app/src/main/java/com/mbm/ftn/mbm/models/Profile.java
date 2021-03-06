package com.mbm.ftn.mbm.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by Makso on 6/17/2017.
 */

@DatabaseTable
public class Profile extends BaseModel implements Serializable {

    public static final String TITLE_FIELD_NAME = "title";
    public static final String CHECKED_FIELD_NAME = "chechked";
    public static final String FIRSTNAME_FIELD_NAME = "firstName";
    public static final String LASTNAME_FIELD_NAME = "lastName";
    public static final String PHONE_FIELD_NAME = "phone";
    public static final String EMAIL_FIELD_NAME = "email";
    public static final String MESSAGE_FIELD_NAME = "message";

    @DatabaseField(columnName = TITLE_FIELD_NAME)
    private String title;

    @DatabaseField(columnName = FIRSTNAME_FIELD_NAME)
    private String firstName;

    @DatabaseField(columnName = LASTNAME_FIELD_NAME)
    private String lastName;

    @DatabaseField(columnName = PHONE_FIELD_NAME)
    private String phone;

    @DatabaseField(columnName = EMAIL_FIELD_NAME)
    private String email;

    @DatabaseField(columnName = MESSAGE_FIELD_NAME)
    private String message;

    @DatabaseField(columnName = CHECKED_FIELD_NAME)
    private Boolean checked;

    public Profile() {
    }

    public Profile(String title, String firstName, String lastName, String phone, String email, String message, Boolean checked) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.message = message;
        this.checked = checked;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "title='" + title + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", message='" + message + '\'' +
                ", checked=" + checked +
                '}';
    }
}
