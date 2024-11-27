# e-cart-server

### Takeaways :: 
1. In ProductService we have method called `addProduct(request)` but before saving product directly to db we are first creating the product using createProduct(request) helper method to validate data and transform data seperating the creation logic and persistance(db) logic. This helps in better reusablity and uses 1st point of SOLID
2. Understand when to use @Data and @Getter @Setter @AllArgsConstructor. I can't explain it here.
3. Get insights about MultipartFile that i have used in IImageService, like what is it and why are we using it.
    > In Spring Boot, we use MultipartFile to send files from a client to a server. [reference](https://stackoverflow.com/questions/44728459/spring-boot-multipartfile-methods).
4. try understanding how are we saving image(blob) from client to server using  update method.
5. `Content-Disposition` : [reference](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Disposition)

6. ```-java
    @RestController
    @RequiredArgsConstructor
    @RequestMapping("${api.prefix}/products")
    public class ProductController {
        private final IProductService productService;
    }
    <!-- i am confused which class's object will be invoked for productService since IProductService is an interface? --> ```
: In this case DI is used to inject concrete implementation of that interface. In this case it will inject object of `ProductService`. The `@RequiredArgsConstructor` annotation from Lombok generates a constructor with parameters for all final fields (in this case, `productService`). Spring's `@RestController` and dependency injection capabilities will automatically use this constructor to inject the `ProductService` implementation into the `ProductController`.
using these steps
1. Component Scanning 
2. DI 
3. Bean selection : If there are multiple implementations we then need to use `@Qualifier` to specify which one to inject. 
7. Run Docker container: `docker run --name container-name -d image-id`
8. Execute Docker container: `docker exec -it my-mysql-container mysql -uroot -p`
9. stop Docker container: `docker stop my-mysql-container`
10. kill Docker container: `docker kill my-mysql-container`
11. start Docker container: `docker start my-container`
12. restart Docker container: `docker restart my-container`