package model;

import java.util.UUID;

public class Owner {
    private final String id;
    private String name;
    private String phone;

    public Owner(String name, String phone) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.phone = phone;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    @Override
    public String toString() {
        return String.format("Owner{id=%s, name='%s', phone='%s'}", id, name, phone);
    }
}