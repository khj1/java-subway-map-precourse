package subway.controller;

import subway.command.StationCommand;
import subway.domain.Station;
import subway.repository.StationRepository;
import subway.utils.ProcessUtil;
import subway.view.InputView;
import subway.view.OutputView;

public class StationController {

    private final InputView inputView;
    private final OutputView outputView;

    public StationController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        ProcessUtil.checkError(this::manageStation);
    }

    private void manageStation() {
        outputView.printStationMenu();
        StationCommand command = StationCommand.convert(inputView.readCommand());

        if (command == StationCommand.ADD) {
            addStation();
            outputView.printStationRegisterResult();
        }
        if (command == StationCommand.DELETE) {
            deleteStation();
            outputView.printStationDeleteResult();
        }
        if (command == StationCommand.READ) {
            outputView.printStations();
        }
    }

    private void addStation() {
        Station station = inputView.readStation();
        StationRepository.addStation(station);
    }

    private void deleteStation() {
        Station station = inputView.readDeleteStation();
        StationRepository.deleteStation(station);
    }
}
