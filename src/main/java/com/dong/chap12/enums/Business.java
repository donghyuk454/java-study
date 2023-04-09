package main.java.com.dong.chap12.enums;

public class Business {
    private String name;
    private Status status;

    public static Business of(String name, Status status) {
        Business business = new Business();
        business.name = name;
        business.status = status;
        return business;
    }

    public String getMessage() {
        return "name : "
                + name
                + "\nstatus : "
                + status.name()
                + "\nstatus info : "
                + status.getMyStatusInfo()
                + "\n";
    }
}
