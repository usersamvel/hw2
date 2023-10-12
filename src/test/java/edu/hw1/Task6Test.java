package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task6Test {

    @Test
    void countK1() {
        Task6 task6 = new Task6();
        //given
        int n=6621;
        //when
        int response = task6.countK(n);
        //then
        Assertions.assertThat(response).isEqualTo(5);
    }
    @Test
    void countK1000() {
        Task6 task6 = new Task6();
        //given
        int n=1000;
        //when
        int response = task6.countK(n);
        //then
        Assertions.assertThat(response).isEqualTo(-1);
    }
    @Test
    void countK3333() {
        Task6 task6 = new Task6();
        //given
        int n=3333;
        //when
        int response = task6.countK(n);
        //then
        Assertions.assertThat(response).isEqualTo(-1);
    }
    @Test
    void countK12345() {
        Task6 task6 = new Task6();
        //given
        int n=12345;
        //when
        int response = task6.countK(n);
        //then
        Assertions.assertThat(response).isEqualTo(-1);
    }
}
