package employee;

public enum Genders{


    MALE("man"),

    FEMALE("woman");

    private String gender;

    Genders(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }


    @Override
    public String toString() {
        return gender + ",\n";
    }
}
