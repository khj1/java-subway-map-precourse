package subway.view.input;

import subway.domain.Station;

import java.util.Scanner;

public class InputView {

    final Scanner scanner = new Scanner(System.in);

    public String readCommand() {
        System.out.println("## 원하는 기능을 선택하세요.");

        return scanner.nextLine();
    }

    public Station readStation() {
        System.out.println("## 등록할 역 이름을 입력하세요.");

        return Station.create(scanner.nextLine());
    }

    public Station readDeleteStation() {
        System.out.println("## 삭제할 역 이름을 입력하세요.");

        return Station.create(scanner.nextLine());
    }

    public String readLineName() {
        System.out.println("## 등록할 노선 이름을 입력하세요.");

        return scanner.nextLine();
    }

    public Station readUpStation() {
        System.out.println("## 등록할 노선의 상행 종점역 이름을 입력하세요.");

        return Station.create(scanner.nextLine());
    }

    public Station readDownStation() {
        System.out.println("## 등록할 노선의 하행 종점역 이름을 입력하세요.");

        return Station.create(scanner.nextLine());
    }

    public String readDeleteLineName() {
        System.out.println("## 삭제할 노선 이름을 입력하세요.");

        return scanner.nextLine();
    }

    public String readLineNamesForSection() {
        System.out.println("## 노선을 입력하세요.");

        return scanner.nextLine();
    }

    public String readStationForSection() {
        System.out.println("## 역이름을 입력하세요.");

        return scanner.nextLine();
    }

    public int readSequence() {
        System.out.println("## 순서를 입력하세요.");

        return parseInt(scanner.nextLine());
    }

    public String readLineForDeleteSection() {
        System.out.println("## 삭제할 구간의 노선을 입력하세요.");

        return scanner.nextLine();
    }

    public Station readStationForDeleteSection() {
        System.out.println("## 삭제할 구간의 역을 입력하세요.");

        return Station.create(scanner.nextLine());
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException error) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다");
        }
    }


}
