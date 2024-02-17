package edu.qc.seclass.fim;

public class Product {
    private String id;
    private String name;
    private String color;
    private String size;
    private String brand;
    private String type;
    private String price;
    private String category;
    private String material;
    private String species;
    private String waterResistant;

    public Product(String id, String name, String color, String size, String brand, String type, String price,
                   String category, String material, String species, String waterResistant) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.size = size;
        this.brand = brand;
        this.type = type;
        this.price = price;
        this.category = category;
        this.material = material;
        this.species = species;
        this.waterResistant = waterResistant;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public String getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String getMaterial() {
        return material;
    }

    public String getSpecies() {
        return species;
    }

    public String isWaterResistant() {
        return waterResistant;
    }
}
