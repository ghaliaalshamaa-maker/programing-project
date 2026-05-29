public class Person extends Customer{
    int number;
    Date birthDate;

    public Person(String numberId, String name, String address, String numberPhone, int number, int d,int m ,int y) {
        super(numberId, name, address, numberPhone);
        this.number = number;
        birthDate =new Date(d,m,y);
    }

    @Override
    public String toString() {
        return super.toString()+"Person [number=" + number + ", birthDate=" + birthDate.toString() + "]";
    }

    

    

}

