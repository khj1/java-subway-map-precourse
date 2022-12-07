package subway.controller;

import subway.command.LineCommand;
import subway.domain.Line;
import subway.domain.Station;
import subway.domain.Stations;
import subway.repository.LineRepository;
import subway.utils.ProcessUtil;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;

public class LineController {

    private final InputView inputView;
    private final OutputView outputView;

    public LineController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        ProcessUtil.checkError(this::manageLine);
    }

    private void manageLine() {
        outputView.printLineMenu();
        LineCommand command = LineCommand.convert(inputView.readCommand());

        if (command == LineCommand.ADD) {
            addLine();
            outputView.printLineRegisterResult();
        }
        if (command == LineCommand.DELETE) {
            deleteLine();
            outputView.printLineDeleteResult();
        }
        if (command == LineCommand.READ) {
            outputView.printLineNames();
        }
    }

    private void addLine() {
        String lineName = inputView.readLineName();
        Station upStation = inputView.readUpStation();
        Station downStation = inputView.readDownStation();

        Stations stations = Stations.create(List.of(upStation, downStation));
        Line line = Line.of(lineName, stations);

        LineRepository.addLine(line);
    }

    private void deleteLine() {
        String lineName = inputView.readDeleteLineName();
        LineRepository.deleteLineByName(lineName);
    }
}
