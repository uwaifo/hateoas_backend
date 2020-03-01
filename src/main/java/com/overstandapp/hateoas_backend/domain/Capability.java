package com.overstandapp.hateoas_backend.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Capability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Technology can not be blank")//disallows black or no value
    @NotNull(message =  "Technology Stack can not be null")// disallows if the field is not included
    private String techStack;
    private Integer numsOfDevelopers = 0;
    private Integer numsOfAvailableDeveloper = 0;

    public Capability(String techStack, Integer numsOfDevelopers, Integer numsOfAvailableDeveloper) {
        this.techStack = techStack;
        this.numsOfDevelopers = numsOfDevelopers;
        this.numsOfAvailableDeveloper = numsOfAvailableDeveloper;
    }

    public Capability() {
    }

    public Long getId() {
        return this.id;
    }

    public @NotBlank(message = "Technology can not be blank") @NotNull(message = "Technology Stack can not be null") String getTechStack() {
        return this.techStack;
    }

    public Integer getNumsOfDevelopers() {
        return this.numsOfDevelopers;
    }

    public Integer getNumsOfAvailableDeveloper() {
        return this.numsOfAvailableDeveloper;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTechStack(@NotBlank(message = "Technology can not be blank") @NotNull(message = "Technology Stack can not be null") String techStack) {
        this.techStack = techStack;
    }

    public void setNumsOfDevelopers(Integer numsOfDevelopers) {
        this.numsOfDevelopers = numsOfDevelopers;
    }

    public void setNumsOfAvailableDeveloper(Integer numsOfAvailableDeveloper) {
        this.numsOfAvailableDeveloper = numsOfAvailableDeveloper;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Capability)) return false;
        final Capability other = (Capability) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$techStack = this.getTechStack();
        final Object other$techStack = other.getTechStack();
        if (this$techStack == null ? other$techStack != null : !this$techStack.equals(other$techStack)) return false;
        final Object this$numsOfDevelopers = this.getNumsOfDevelopers();
        final Object other$numsOfDevelopers = other.getNumsOfDevelopers();
        if (this$numsOfDevelopers == null ? other$numsOfDevelopers != null : !this$numsOfDevelopers.equals(other$numsOfDevelopers))
            return false;
        final Object this$numsOfAvailableDeveloper = this.getNumsOfAvailableDeveloper();
        final Object other$numsOfAvailableDeveloper = other.getNumsOfAvailableDeveloper();
        if (this$numsOfAvailableDeveloper == null ? other$numsOfAvailableDeveloper != null : !this$numsOfAvailableDeveloper.equals(other$numsOfAvailableDeveloper))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Capability;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $techStack = this.getTechStack();
        result = result * PRIME + ($techStack == null ? 43 : $techStack.hashCode());
        final Object $numsOfDevelopers = this.getNumsOfDevelopers();
        result = result * PRIME + ($numsOfDevelopers == null ? 43 : $numsOfDevelopers.hashCode());
        final Object $numsOfAvailableDeveloper = this.getNumsOfAvailableDeveloper();
        result = result * PRIME + ($numsOfAvailableDeveloper == null ? 43 : $numsOfAvailableDeveloper.hashCode());
        return result;
    }

    public String toString() {
        return "Capability(id=" + this.getId() + ", techStack=" + this.getTechStack() + ", numsOfDevelopers=" + this.getNumsOfDevelopers() + ", numsOfAvailableDeveloper=" + this.getNumsOfAvailableDeveloper() + ")";
    }
}
