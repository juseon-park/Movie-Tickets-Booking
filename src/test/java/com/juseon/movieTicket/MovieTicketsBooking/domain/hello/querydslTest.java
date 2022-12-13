package com.juseon.movieTicket.MovieTicketsBooking.domain.hello;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

        //then
        assertEquals(found,helloDomain);

    }
}
