package com.juseon.movieTicket.MovieTicketsBooking.domain.hello;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class HelloRepositoryTest {

        @Autowired
        HelloRepository helloRepository;

        @AfterEach
        public void cleanup() {
            helloRepository.deleteAll();
        }

        @Test
        public void 저장_조회(){
            //given
            String title = "테스트 제목";
            String seats = "{\n" +
                    "  \"squadName\": \"Super hero squad\",\n" +
                    "  \"homeTown\": \"Metro City\",\n" +
                    "  \"formed\": 2016,\n" +
                    "  \"secretBase\": \"Super tower\",\n" +
                    "  \"active\": true,\n" +
                    "  \"members\": [\n" +
                    "    {\n" +
                    "      \"name\": \"Molecule Man\",\n" +
                    "      \"age\": 29,\n" +
                    "      \"secretIdentity\": \"Dan Jukes\",\n" +
                    "      \"powers\": [\n" +
                    "        \"Radiation resistance\",\n" +
                    "        \"Turning tiny\",\n" +
                    "        \"Radiation blast\"\n" +
                    "      ]\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"name\": \"Madame Uppercut\",\n" +
                    "      \"age\": 39,\n" +
                    "      \"secretIdentity\": \"Jane Wilson\",\n" +
                    "      \"powers\": [\n" +
                    "        \"Million tonne punch\",\n" +
                    "        \"Damage resistance\",\n" +
                    "        \"Superhuman reflexes\"\n" +
                    "      ]\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"name\": \"Eternal Flame\",\n" +
                    "      \"age\": 1000000,\n" +
                    "      \"secretIdentity\": \"Unknown\",\n" +
                    "      \"powers\": [\n" +
                    "        \"Immortality\",\n" +
                    "        \"Heat Immunity\",\n" +
                    "        \"Inferno\",\n" +
                    "        \"Teleportation\",\n" +
                    "        \"Interdimensional travel\"\n" +
                    "      ]\n" +
                    "    }\n" +
                    "  ]\n" +
                    "}";

            helloRepository.save(HelloDomain.builder()
                            .title(title)
                            .seats(seats)
                            .cinema("용산아이파크")
                            .build());

            //when
            List<HelloDomain> helloDomainList = helloRepository.findAll();

            //then
            HelloDomain helloDomain = helloDomainList.get(0);
            assertThat(helloDomain.getTitle()).isEqualTo(title);
            assertThat(helloDomain.getSeats()).isEqualTo(seats);

        }

}
