package com.overstandapp.hateoas_backend.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "First Name can not be blank")
    @NotNull(message = "First Name can not be Null")
    private String firstName;

    @NotBlank(message = "Last Name can not be blank")
    @NotNull(message = "Last Name can not be Null")
    private String lastName ;
    private String contactPhoneNumber = "No Number";
    private String contactEmailAddress = "No Email";

    public User(String firstName, String lastName, String contactPhoneNumber, String contactEmailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactPhoneNumber = contactPhoneNumber;
        this.contactEmailAddress = contactEmailAddress;
    }

    public User() {
    }

    public long getId() {
        return this.id;
    }

    public @NotBlank(message = "First Name can not be blank") @NotNull(message = "First Name can not be Null") String getFirstName() {
        return this.firstName;
    }

    public @NotBlank(message = "Last Name can not be blank") @NotNull(message = "Last Name can not be Null") String getLastName() {
        return this.lastName;
    }

    public String getContactPhoneNumber() {
        return this.contactPhoneNumber;
    }

    public String getContactEmailAddress() {
        return this.contactEmailAddress;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(@NotBlank(message = "First Name can not be blank") @NotNull(message = "First Name can not be Null") String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(@NotBlank(message = "Last Name can not be blank") @NotNull(message = "Last Name can not be Null") String lastName) {
        this.lastName = lastName;
    }

    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public void setContactEmailAddress(String contactEmailAddress) {
        this.contactEmailAddress = contactEmailAddress;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof User)) return false;
        final User other = (User) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$firstName = this.getFirstName();
        final Object other$firstName = other.getFirstName();
        if (this$firstName == null ? other$firstName != null : !this$firstName.equals(other$firstName)) return false;
        final Object this$lastName = this.getLastName();
        final Object other$lastName = other.getLastName();
        if (this$lastName == null ? other$lastName != null : !this$lastName.equals(other$lastName)) return false;
        final Object this$contactPhoneNumber = this.getContactPhoneNumber();
        final Object other$contactPhoneNumber = other.getContactPhoneNumber();
        if (this$contactPhoneNumber == null ? other$contactPhoneNumber != null : !this$contactPhoneNumber.equals(other$contactPhoneNumber))
            return false;
        final Object this$contactEmailAddress = this.getContactEmailAddress();
        final Object other$contactEmailAddress = other.getContactEmailAddress();
        if (this$contactEmailAddress == null ? other$contactEmailAddress != null : !this$contactEmailAddress.equals(other$contactEmailAddress))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof User;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        final Object $firstName = this.getFirstName();
        result = result * PRIME + ($firstName == null ? 43 : $firstName.hashCode());
        final Object $lastName = this.getLastName();
        result = result * PRIME + ($lastName == null ? 43 : $lastName.hashCode());
        final Object $contactPhoneNumber = this.getContactPhoneNumber();
        result = result * PRIME + ($contactPhoneNumber == null ? 43 : $contactPhoneNumber.hashCode());
        final Object $contactEmailAddress = this.getContactEmailAddress();
        result = result * PRIME + ($contactEmailAddress == null ? 43 : $contactEmailAddress.hashCode());
        return result;
    }

    public String toString() {
        return "User(id=" + this.getId() + ", firstName=" + this.getFirstName() + ", lastName=" + this.getLastName() + ", contactPhoneNumber=" + this.getContactPhoneNumber() + ", contactEmailAddress=" + this.getContactEmailAddress() + ")";
    }
}
