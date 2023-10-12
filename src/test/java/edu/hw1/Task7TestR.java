package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task7TestR {

    @Test
    void rotateRight() {
        Task7 task7 = new Task7();
        //given
        int n=8;
        int shift=1;
        //when
        int response = task7.rotateRight(n,shift);
        //then
        Assertions.assertThat(response).isEqualTo(4);
    }
    @Test
    void rotateRight2() {
        Task7 task7 = new Task7();
        //given
        int n=456;
        int shift=111;
        //when
        int response = task7.rotateRight(n,shift);
        //then
        Assertions.assertThat(response).isEqualTo(57);
    }
}
