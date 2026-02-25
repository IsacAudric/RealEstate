package dto;

public class CreatePropertyDTO {
    public String title;
    public String address;
    public double price;
    public String ownerName;
    public String ownerPhone;

    public CreatePropertyDTO(String title, String address, double price, String ownerName, String ownerPhone) {
        this.title = title;
        this.address = address;
        this.price = price;
        this.ownerName = ownerName;
        this.ownerPhone = ownerPhone;
    }
}