package Java.lab4;

import java.util.Arrays;
import java.util.Comparator;

public class lab4 {
    public static void main(String[] args) {
        University_Array university_array = new University_Array(4);

        university_array.add(new University("Киевский политехнический институт",
                5, "Киев, проспект Победы, 37", 25000, 1898));

        university_array.add(new University("Львовская политехника",
                10, "Львов, ул. Степана Бандеры, д.12", 30000, 1844));

        university_array.add(new University("Харьковский политехнический институт",
                1, "Харьков, ул. Кирпичева, 2", 20000, 1885));

        university_array.add(new University("Киевский национальный университет имени Тараса Шевченко",
                4, "Киев, ул. Владимирская, 60", 20000, 1834));



        university_array.print();
        university_array.sort(false, 1);
        System.out.println();
        university_array.print();

    }

}
class University{
    private String name;
    private int area;
    private String street;
    private int num_students;
    private int year_create;
    public University(String name, int area, String street, int num_students, int year_create){
        this.name = name;
        this.area = area;
        this.street = street;
        this.num_students = num_students;
        this.year_create = year_create;
    }

    public String getName() {
        return name;
    }

    public int getArea() {
        return area;
    }

    public String getStreet() {
        return street;
    }

    public int getNum_students() {
        return num_students;
    }

    public int getYear_create() {
        return year_create;
    }

    public void print(){
        System.out.printf("%60s | %3d |%32s | %d | %d\n",this.name, this.area, this.street, this.num_students, this.year_create);
    }

}
class University_Array{
    private University[] universities;
    private int size;
    private int i = 0;
    public University_Array(int size){
        universities = new University[size];
        this.size = size;
    }
    public void add(University university){
        universities[this.i] = university;
        this.i++;
    }

    public void print(){
        for (i = 0; i < this.size; i++)
            universities[i].print();
    }

    private void sort_reverse(int column_num){
        Comparator<University> comparing = null;
        switch (column_num){
            case 1: comparing = Comparator.comparing(University::getName); break;
            case 2: comparing = Comparator.comparingInt(University::getArea); break;
            case 3: comparing = Comparator.comparing(University::getStreet); break;
            case 4: comparing = Comparator.comparingInt(University::getNum_students); break;
            case 5: comparing = Comparator.comparingInt(University::getYear_create); break;
            default:
                System.out.printf("Error! %d column in Java.lab4.University don't exist", column_num);
                System.exit(-1);
                break;
        }
       /* if (n == 1) {    //"n" is "reverse" in sort, solve task more prefect, this replace -- sort, sort_reverse, sort_non_reverse
            comparing  = comparing.reversed();
        }
        Arrays.sort(universities, comparing);*/
    }

    private void sort_non_reverse(int column_num){
        switch (column_num){
            case 1:Arrays.sort(universities, Comparator.comparing(University::getName)); break;
            case 2:Arrays.sort(universities, Comparator.comparingInt(University::getArea)); break;
            case 3:Arrays.sort(universities, Comparator.comparing(University::getStreet)); break;
            case 4:Arrays.sort(universities, Comparator.comparingInt(University::getNum_students)); break;
            case 5:Arrays.sort(universities, Comparator.comparingInt(University::getYear_create)); break;
            default:
                System.out.printf("Error! %d column in Java.lab4.University don't exist", column_num);
                System.exit(-1);
                break;
        }
    }

    public void sort(boolean reverse, int column_num){
        if (reverse)
            sort_reverse(column_num);
        else
            sort_non_reverse(column_num);
    }

}
