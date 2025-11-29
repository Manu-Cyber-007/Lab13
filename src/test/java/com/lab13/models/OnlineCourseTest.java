package com.lab13.models;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OnlineCourseTest {

    private OnlineCourse oc;

    @BeforeAll
    void beforeAll() {
        System.out.println("=== Iniciando tests de OnlineCourse ===");
    }

    @AfterAll
    void afterAll() {
        System.out.println("=== Finalizando tests de OnlineCourse ===");
    }

    @BeforeEach
    void beforeEach() {
        oc = new OnlineCourse("Base", 10, "YouTube");
        System.out.println("Preparando un nuevo OnlineCourse...");
    }

    @AfterEach
    void afterEach() {
        oc = null;
        System.out.println("OnlineCourse limpiado.");
    }

    @Test
    @DisplayName("Platform se asigna correctamente")
    void testPlatformAssignment() {
        assertEquals("YouTube", oc.getPlatform());
    }

    @ParameterizedTest
    @CsvSource({
        "Java Online, 20, Udemy",
        "Python Web, 15, YouTube",
        "Testing Pro, 25, Platzi"
    })
    @DisplayName("Probando asignación de plataforma con distintos datos")
    void testPlatforms(String title, int duration, String platform) {
        OnlineCourse temp = new OnlineCourse(title, duration, platform);
        assertEquals(platform, temp.getPlatform());
    }

    @ParameterizedTest
    @CsvSource({
        "Sky, Udemy",
        "Manuela, Platzi",
        "Ana, YouTube"
    })
    @DisplayName("Probando profesor y plataforma")
    void testProfessorAndPlatform(String professor, String platform) {
        OnlineCourse temp = new OnlineCourse("Course", 10, professor, platform);
        assertEquals(professor, temp.getProfessor());
        assertEquals(platform, temp.getPlatform());
    }
}