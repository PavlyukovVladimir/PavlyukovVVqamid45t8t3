package ru.netology.statistic;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тестируем сервис статистики")
@ExtendWith(MyTestWatcher.class)
public class StatisticsServiceTest {

    private StatisticsService service;

    @BeforeEach
    public void setUp(TestInfo testInfo, TestReporter testReporter) {
        System.out.println("Начинаем проверку, что " + testInfo.getDisplayName().toLowerCase() + "\uD83E\uDD1E");
        this.service = new StatisticsService();
    }

    @Test
    @DisplayName("Максимум находится в начале списка")
    public void findMaxWhenMaxFirst() {
        long[] incomesInBillions = {12, 5, 8, 4, 5, 3, 8, 6, 11, 11, 12};
        long expected = 12;
        long actual = service.findMax(incomesInBillions);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Максимум находится в конце списка")
    public void findMaxWhenMaxEnd() {
        long[] incomesInBillions = {12, 5, 8, 4, 5, 3, 8, 6, 11, 11, 15};
        long expected = 15;
        long actual = service.findMax(incomesInBillions);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Максимум находится не по краям списка")
    public void findMaxWhenMaxBetween() {
        long[] incomesInBillions = {12, 5, 8, 4, 5, 13, 8, 6, 11, 11, 12};
        long expected = 13;
        long actual = service.findMax(incomesInBillions);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("В списке один элемент")
    public void findMaxOneElement() {
        long[] incomesInBillions = {12};
        long expected = 12;
        long actual = service.findMax(incomesInBillions);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("В списке несколько и только одинаковых элементов")
    public void findMaxSeveralEqualElements() {
        long[] incomesInBillions = {12, 12, 12};
        long expected = 12;
        long actual = service.findMax(incomesInBillions);

        assertEquals(expected, actual);
    }
}