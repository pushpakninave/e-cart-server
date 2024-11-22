# e-cart-server

### Takeaways :: 
1. In ProductService we have method called `addProduct(request)` but before saving product directly to db we are first creating the product using createProduct(request) helper method to validate data and transform data seperating the creation logic and persistance(db) logic. This helps in better reusablity and uses 1st point of SOLID
2. Understand when to use @Data and @Getter @Setter @AllArgsConstructor. I can't explain it here.
3. Get insights about MultipartFile that i have used in IImageService, like what is it and why are we using it.
    > In Spring Boot, we use MultipartFile to send files from a client to a server. [reference](https://stackoverflow.com/questions/44728459/spring-boot-multipartfile-methods).
4. try understanding how are we saving image(blob) from client to server using  update method.
5. `Content-Disposition` : [reference](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Disposition)
