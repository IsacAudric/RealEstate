package model;

import java.util.UUID;

public class Client {
    private final String id;
    private String name;
    private String email;

    public Client(String name, String email) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return String.format("Client{id=%s, name='%s', email='%s'}", id, name, email);
    }
}