package dbtest;

import java.sql.Connection;
import java.sql.SQLException;

import dbtest.config.DBConfig;
import dbtest.model.ProductRepository;
import dbtest.service.ProductService;

public class DBApp {
    public static void main(String[] args) throws SQLException {
        // 스프링에서는 컴포넌트 스캔으로 자동으로 작동함
        // 1. 커넥션 가져오기
        Connection conn = DBConfig.getConnection();
        // 2. 리파지토리 가져오기
        ProductRepository productRepository = new ProductRepository(conn);
        // 3. 서비스 가져오기
        ProductService productService = new ProductService(productRepository, conn);
        productService.insert("carrot", 600, 20);
    }
}
