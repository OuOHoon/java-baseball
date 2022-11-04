package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {

    @Test
    @DisplayName("1~9까지 서로 다른 임의의 수 3개를 선택한다.")
    void selectRandomNumbers() {
        Computer computer = new Computer();
        List<Integer> selectRandomNumbers = computer.selectRandomNumbers();
        List<Integer> compare = new ArrayList<>();
        for (Integer randomNumber : selectRandomNumbers) {
            if (!compare.contains(randomNumber)) {
                compare.add(randomNumber);
            }
        }
        assertThat(selectRandomNumbers.size()).isEqualTo(3);
        assertThat(selectRandomNumbers.size()).isEqualTo(compare.size());
    }

    @Test
    @DisplayName("스트라이크의 숫자를 세는 기능")
    void countStrike() {
        Computer computer = new Computer();
        List<Integer> numbers = computer.selectRandomNumbers();
        Integer compare = 0;
        for (Integer number : numbers) {
            compare = 10 * compare + number;
        }
        assertThat(computer.countStrike(compare)).isEqualTo(3);
        assertThat(computer.countStrike(compare-1)).isEqualTo(2);
        assertThat(computer.countStrike(compare-11)).isEqualTo(1);
    }
}