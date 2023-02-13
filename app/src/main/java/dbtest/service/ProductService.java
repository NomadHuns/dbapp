package dbtest.service;

import java.sql.Connection;
import java.sql.SQLException;

import dbtest.model.ProductRepository;

public class ProductService {
    private ProductRepository productRepository;
    private Connection conn;

    public ProductService(ProductRepository productRepository, Connection conn) {
        this.productRepository = productRepository;
        this.conn = conn;
    }

    public void insert(String name, int price, int qty) {
        // 트랜젝션 시작
        try {
            productRepository.insert(name, price, qty);
            productRepository.insert(name, price, qty);
            conn.rollback();
        } catch (Exception e1) {
            e1.printStackTrace();
            try {
                conn.rollback();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        // 트랜젝션 끝
    }
}
