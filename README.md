# Team Exercise: Spring Boot RESTful API Project 

## Mô tả
''' 
Áp dụng Spring Boot cơ bản xây dụng ứng dụng ResfulAPI
'''

## Cài đăt
Yêu cầu cần có: Java JDK over 11 version, Maven

1. Tải source
```
git clone
```
2. Config application
```
- Tạo file application.yml tại thư mục resources
- Thêm và chỉnh sửa biến môi trường tương tự như file application_example.yml 
```

3. Run app 
```
mvn install
mvn package
java -jar target/ex4-1.0-SNAPSHOT.jar
```


## Test API:  
Swagger UI được tích hợp để xem và thử nghiệm API một cách dễ dàng. Truy cập http://localhost:14567/api/v1/swagger-ui/index.html để sử dụng.  

### 6 API được clone tương ứng:  
http://localhost:14567/api/v1/user : lấy danh sách user  
http://localhost:14567/api/v1/comment : lấy danh sách comment  
http://localhost:14567/api/v1/post : lấy danh sách post  
http://localhost:14567/api/v1/album : lấy danh sách album  
http://localhost:14567/api/v1/photo : lấy danh sách photo  
http://localhost:14567/api/v1/todo : lấy danh sách todo

### 3 API được viết bổ sung:  
http://localhost:14567/api/v1/post/{id} : lấy nội dung của post dựa vào id  
http://localhost:14567/api/v1/comment/post/{post_id} : lấy danh sách comment của post dựa vào post_id  
http://localhost:14567/api/v1/photo/album/{album_id} : lấy danh sách photo của album dựa vào album_id
