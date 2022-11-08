package com.juseon.movieTicket.MovieTicketsBooking.domain.hello;

import com.juseon.movieTicket.MovieTicketsBooking.domain.hello.HelloDomain;
import com.juseon.movieTicket.MovieTicketsBooking.domain.hello.QHelloDomain;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@SpringBootTest
public class querydslTest {

    @PersistenceContext
    EntityManager entityManager;

    @Test
    void test(){
        //given
        HelloDomain helloDomain = HelloDomain.builder()
                                    .title("title")
                                    .seats("seats")
                                    .cinema("용산아이파크")
                                    .build();

        entityManager.persist(helloDomain);

        //when
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        QHelloDomain qHelloDomain = new QHelloDomain("hello");
        HelloDomain found = queryFactory.selectFrom(qHelloDomain).fetchOne();

    }
}
