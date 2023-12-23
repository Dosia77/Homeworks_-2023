package medics;
public abstract class Medics {
    private String name;
    private int phoneNamber;
    private String specialization;
    private String qualification;
    private int experience;
    protected String type;

    public Medics(String name, int phoneNamber, String specialization, String qualification, int experience){
        this.name = name;
        this.phoneNamber = phoneNamber;
        this.specialization = specialization;
        this.qualification = qualification;
        this.experience = experience;
        this.type = getClass().getSimpleName();
       
    }

    public String getName(){
        return name;
    }
    public Integer getPhoneNamber(){
        return phoneNamber;
    }
    public String getSpecialization(){
        return specialization;
      }
    public String getQualification(){
        return qualification;
    }

    public int getExperience(){
        return experience;
    }

    protected abstract void injection();

    protected abstract void test();

    protected abstract void examination();

    @Override
    public String toString() {
        return "Medic: " +
                "name = " + name +
                ",poneNamber = "+phoneNamber+
                ",specialization = "+ specialization+
                ", qualification = " + qualification +
                ", experience = " + experience;
       
    }
}
