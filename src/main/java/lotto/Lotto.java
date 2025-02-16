package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에는 중복된 숫자가 없어야 합니다.");
        }
    }

    public String printTicketDetail() {
        return numbers.toString();
    }

    public int countMatchingNumbers(Lotto other) {
        int count = 0;
        for (int number : numbers) {
            if (other.numbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
