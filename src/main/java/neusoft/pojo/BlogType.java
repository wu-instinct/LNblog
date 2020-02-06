package neusoft.pojo;

public class BlogType {
    private Integer id;
    private String typeName;
    private String orderNo;
    private Integer blogCount;

    public Integer getBlogCount() {
        return blogCount;
    }

    public void setBlogCount(Integer blogCount) {
        this.blogCount = blogCount;
    }

    public BlogType(Integer id, String typeName, String orderNo) {
        this.id = id;
        this.typeName = typeName;
        this.orderNo = orderNo;
    }

    public BlogType() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    @Override
    public String toString() {
        return "BlogType{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                ", orderNo='" + orderNo + '\'' +
                '}';
    }
}
