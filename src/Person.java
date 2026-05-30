public class Person extends Customer{
    private int number;
    private Date birthDate;

    public Person(String numberId, String name, String address, String numberPhone, int number, int y,int m ,int d) {
        super(numberId, name, address, numberPhone);
        this.number = number;
        birthDate =new Date(y,m,d);
    }
    

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }


    @Override
    public String toString() {
        return super.toString()+"Person [number=" + number + ", birthDate=" + birthDate.toString() + "]";
    }

    

    

}

