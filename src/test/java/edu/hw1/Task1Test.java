package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task1Test {

    @Test
    void minutesToSecondsCorrect() {
        Task1 task1 = new Task1();
        //given
        String s = "12:40";
        //when
        int response = task1.minutesToSeconds(s);
        //then
        Assertions.assertThat(response).isEqualTo(12*60+40);
    }
    @Test
    void minutesToSecondsIncorrect() {
        Task1 task1 = new Task1();
        //given
        String s = "32:70";
        //when
        int response = task1.minutesToSeconds(s);
        //then
        Assertions.assertThat(response).isEqualTo(-1);
    }

}
