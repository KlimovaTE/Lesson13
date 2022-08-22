public class ProductManager {
    protected ProductRepository repo;

    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }

    public void addNew(Product newProduct) {
        repo.save(newProduct);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        ProductRepository tmp = new ProductRepository();
        for (Product product : repo.findAll()) {
            if (product.matches(text)) {
                tmp.save(product);
                result = tmp.findAll();
            }
        }
        return result;
    }

//    public boolean matches(Product product, String search) {
//        if (product.getName().contains(search)) {
//            return true;
//        } else {
//            return false;
//        }
//    }
}


