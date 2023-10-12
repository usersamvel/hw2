package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class Task7Test {

    @Test
    void rotateLeft1() {
        Task7 task7 = new Task7();
        //given
        int n=16;
        int shift=1;
        //when
        int response = task7.rotateLeft(n,shift);
        //then
        Assertions.assertThat(response).isEqualTo(1);
    }
    @Test
    void rotateLeft2() {
        Task7 task7 = new Task7();
        //given
        int n=17;
        int shift=2;
        //when
        int response = task7.rotateLeft(n,shift);
        //then
        Assertions.assertThat(response).isEqualTo(6);
    }
}
