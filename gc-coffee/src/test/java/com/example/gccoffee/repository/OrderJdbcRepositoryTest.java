package com.example.gccoffee.repository;

import com.example.gccoffee.model.Category;
import com.example.gccoffee.model.Product;
import com.wix.mysql.EmbeddedMysql;
import com.wix.mysql.ScriptResolver;
import com.wix.mysql.config.Charset;
import com.wix.mysql.distribution.Version;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

import static com.wix.mysql.EmbeddedMysql.anEmbeddedMysql;
import static com.wix.mysql.config.MysqldConfig.aMysqldConfig;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.jupiter.api.Assertions.*;

class OrderJdbcRepositoryTest {
    @SpringBootTest
// SpringBootTest는 SpringBootApplication을 자동으로 찾아준다.  ->  SpringConfiguration을 자동으로 찾는다: Bean설정을 읽어서 컨테이너를 만들어준다.
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    @ActiveProfiles("test") // test용 profile을 사용하도록 연결
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class ProductJdbcRepositoryTest {

        static EmbeddedMysql embeddedMysql;

        // anEmbeddedMysql 셋업
        @BeforeAll
        static void setup() {
            var config = aMysqldConfig(Version.v5_7_latest)
                    .withCharset(Charset.UTF8)
                    .withPort(2215) // 기존 서버와 겹치지 않는 포트넘버
                    .withUser("test", "test1234!")
                    .withTimeZone("Asia/Seoul")
                    .build();
            embeddedMysql = anEmbeddedMysql(config)
                    .addSchema("test-order_mgmt", ScriptResolver.classPathScript("schema.sql"))
                    .start();
        }

        // anEmbeddedMysql 종료
        @AfterAll
        static void cleanup() {
            embeddedMysql.stop();
        }

        // repository AutoWiring
        @Autowired
        ProductRepository repository;

        // 테스트를 위한 product 객체
        private final Order newOrder = new Order(UUID.randomUUID(), "suran@gmail", "31546", OrderItem orderItems, 1000L); // static으로 생성해야 테스트마다 인스턴스가 생성되지 않는다.


        @Test
        @Order(1)
        @DisplayName("상품을 추가할 수 있다.")
        void testInsert() {
            repository.insert(newProduct);
            var all = repository.findAll();
            assertThat(all.isEmpty(), is(false));
        }

        @Test
        @Order(2)
        @DisplayName("상품을 이름으로 조회할 수 있다.")
        void testFindByName() {
            var product = repository.findByName(newProduct.getProductName());
            assertThat(product.isEmpty(), is(false));
        }

        @Test
        @Order(3)
        @DisplayName("상품을 아이디로 조회할 수 있다.")
        void testFindById(){
            var product = repository.findById(newProduct.getProductId());
            assertThat(product.isEmpty(), is(false));
        }

        @Test
        @Order(4)
        @DisplayName("상품을 카테고리로 조회할 수 있다.")
        void testFindByCategory(){
            var product = repository.findByCategory(newProduct.getCategory());
            assertThat(product.isEmpty(), is(false));
        }




        @Test
        @Order(5)
        @DisplayName("상품을 수정할 수 있다.")
        void testUpdate(){
            newProduct.setProductName("new-product");
            repository.update(newProduct);

            var product = repository.findById(newProduct.getProductId());
            assertThat(product.isEmpty(), is(false));
            assertThat(product.get(), samePropertyValuesAs(newProduct)); // 두 객체가 같은지 비교
        } // 상품 이름 수정 및 상품 업데이트 기능 테스트


        @Test
        @Order(6)
        @DisplayName("상품을 전체 삭제한다.")
        void testDeleteAll(){
            repository.deleteAll();
            var all = repository.findAll();
            assertThat(all.isEmpty(), is(true));
        }
    }

}