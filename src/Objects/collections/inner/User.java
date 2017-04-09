package Objects.collections.inner;

import java.util.Comparator;

/**
 * Created by xmitya on 20.10.16.
 */
public class User implements Comparable<User> {
    private String name;
    private int age;
    private int salary;
    private String company;

    public User() {
    }

    public User(String name, int age, int salary, String company) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", company='" + company + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        if (salary != user.salary) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return company != null ? company.equals(user.company) : user.company == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + salary;
        result = 31 * result + (company != null ? company.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(User u) {
        return this.getName().compareTo(u.getName());
    }

    public static Comparator<User> CompanyAndNameComparator = new Comparator<User>() {
        @Override
        public int compare(User u1, User u2) {
            int rez = u1.getCompany().compareTo(u2.getCompany());
            if (rez == 0) {
                rez = u1.getName().compareTo(u2.getName());
            }
            return rez;
        }
    };

    public static Comparator<User> SalaryAndNameComparator = new Comparator<User>() {
        @Override
        public int compare(User u1, User u2) {
            int rez = u1.getSalary() - u2.getSalary();
            if (rez == 0) {
                rez = u1.getName().compareTo(u2.getName());
            }
            return rez;
        }
    };

    public static Comparator<User> SalaryAgeCompanyAndNameComparator = new Comparator<User>() {
        @Override
        public int compare(User u1, User u2) {
            int rez = u1.getSalary() - u2.getSalary();
            if (rez == 0) {
                rez = u1.getAge() - u2.getAge();
                if (rez == 0) {
                    rez = u1.getCompany().compareTo(u2.getCompany());
                    if (rez == 0) {
                        rez = u1.getName().compareTo(u2.getName());
                    }
                }
            }
            return rez;
        }
    };
}
