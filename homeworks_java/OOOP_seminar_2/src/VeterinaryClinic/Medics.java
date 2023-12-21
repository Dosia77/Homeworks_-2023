package VeterinaryClinic;
public abstract class Medics {
    private String name;
    private String qualification;
    private int experience;
    protected String type;

    public Medics(String name, String qualification, int experience){
        this.name = name;
        this.qualification = qualification;
        this.experience = experience;
        this.type = getClass().getSimpleName();
    }

    public String getName(){
        return name;
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
}
