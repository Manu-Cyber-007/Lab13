package com.lab13.models;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OnSiteCourseTest {

    private OnSiteCourse osc;

    @BeforeAll
    void beforeAll() {
        System.out.println("=== Iniciando tests de OnSiteCourse ===");
    }

    @AfterAll
    void afterAll() {
        System.out.println("=== Finalizando tests de OnSiteCourse ===");
    }

    @BeforeEach
    void beforeEach() {
        osc = new OnSiteCourse("Base", 10, "Aula 1", 20);
        System.out.println("Preparando OnSiteCourse...");
    }

    @AfterEach
    void afterEach() {
        osc = null;
        System.out.println("OnSiteCourse limpiado.");
    }

    @Test
    @Order(1)
    @DisplayName("Room y quota se asignan correctamente")
    void testRoomAndQuota() {
        assertEquals("Aula 1", osc.getRoom());
        assertEquals(20, osc.getQuota());
    }

    @ParameterizedTest
    @Order(2)
    @CsvSource({
        "Aula 3, 30",
        "Aula 5, 25",
        "Aula 9, 40"
    })
    @DisplayName("Probando distintos valores de room y quota")
    void testParameterizedRoomAndQuota(String room, int quota) {
        osc = new OnSiteCourse("Course", 10, room, quota);
        assertEquals(room, osc.getRoom());
        assertEquals(quota, osc.getQuota());
    }

    @ParameterizedTest
    @Order(3)
    @CsvSource({
        "Manuela, Aula 12, 30",
        "Sky, Aula 7, 20",
        "Carlos, Aula 4, 15"
    })
    @DisplayName("Probando constructor completo con profesor")
    void testFullConstructor(String professor, String room, int quota) {
        OnSiteCourse temp = new OnSiteCourse("Course", 10, professor, room, quota);

        assertEquals(professor, temp.getProfessor());
        assertEquals(room, temp.getRoom());
        assertEquals(quota, temp.getQuota());
    }

    @Test
    @Order(4)
    @DisplayName("showInformation() contiene los datos correctos")
    void testShowInformation() {
        String info = osc.showInformationString();

        assertTrue(info.contains("Base"));
        assertTrue(info.contains("10"));
        assertTrue(info.contains("Aula 1"));
        assertTrue(info.contains("20"));
    }
}