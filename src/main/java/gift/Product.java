package gift;

public class Product {
    private Long id;
    private String name;
    private Integer price;
    private String imageUrl;

    public Product(){
    }
    public Product(Long id, String name, Integer price, String imageUrl){
        this.id = id;
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id){this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {this.name = name;}

    public Integer getPrice() { return this.price;}

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}