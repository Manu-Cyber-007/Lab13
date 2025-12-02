package com.lab13.models;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CourseTest {

    private Course course;

    @BeforeAll
    void beforeAll() {
        System.out.println("=== Iniciando tests de Course ===");
    }

    @AfterAll
    void afterAll() {
        System.out.println("=== Finalizando tests de Course ===");
    }

    @BeforeEach
    void beforeEach() {
        course = new Course("Base", 10);
        System.out.println("Preparando un nuevo Course...");
    }

    @AfterEach
    void afterEach() {
        course = null;
        System.out.println("Course limpiado.");
    }

    @Test
    @DisplayName("Constructor sin profesor asigna 'Unassigned'")
    void testConstructorWithoutProfessor() {
        Course c = new Course("Java", 20);
        assertEquals("Unassigned", c.getProfessor());
    }

    @Test
    @DisplayName("Constructor con profesor asigna correctamente")
    void testConstructorConProfesor() {
        Course c = new Course("SQL", 30, "Laura");
        assertEquals("Laura", c.getProfessor());
        assertEquals("SQL", c.getTitle());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Java", "Python", "C++"})
    @DisplayName("Probando distintos títulos válidos")
    void testTitles(String title) {
        course.setTitle(title);
        assertEquals(title, course.getTitle());
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 10, 15})
    @DisplayName("Probando duraciones válidas")
    void testDurations(int duration) {
        course.setDuration(duration);
        assertEquals(duration, course.getDuration());
    }

    @Test
    @DisplayName("showInformation() no devuelve errores (String vacío)")
    void testShowInformationString() {
        String info = course.showInformationString();
        assertEquals("", info, "Course base debe devolver un string vacío.");
    }
}
