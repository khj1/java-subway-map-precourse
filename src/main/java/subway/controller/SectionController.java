package subway.controller;

import subway.command.SectionCommand;
import subway.domain.Line;
import subway.domain.Station;
import subway.repository.LineRepository;
import subway.repository.StationRepository;
import subway.utils.ProcessUtil;
import subway.view.InputView;
import subway.view.OutputView;

public class SectionController {

    private final InputView inputView;
    private final OutputView outputView;

    public SectionController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        ProcessUtil.checkError(this::manageSection);
    }

    private void manageSection() {
        outputView.printSectionMenu();
        SectionCommand command = SectionCommand.convert(inputView.readCommand());

        if (command == SectionCommand.ADD) {
            addSection();
            outputView.printSectionRegisterResult();
        }
        if (command == SectionCommand.DELETE) {
            deleteSection();
            outputView.printSectionDeleteResult();
        }
    }

    private void addSection() {
        String lineName = inputView.readLineNamesForSection();
        Line line = LineRepository.findByName(lineName);

        String stationName = inputView.readStationForSection();
        Station station = StationRepository.findByName(stationName);

        int sequence = inputView.readSequence();
        line.addStation(station, sequence);
    }

    private void deleteSection() {
        String lineName = inputView.readLineForDeleteSection();
        Line line = LineRepository.findByName(lineName);
        Station station = inputView.readStationForDeleteSection();

        line.remove(station);
    }
}
