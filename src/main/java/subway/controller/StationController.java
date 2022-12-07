package subway.controller;

import subway.command.StationCommand;
import subway.domain.Station;
import subway.repository.StationRepository;
import subway.utils.ProcessUtil;
import subway.view.input.InputView;
import subway.view.ouput.OutputView;
import subway.view.ouput.StationOutputVIew;

public class StationController {

    private final InputView inputView;
    private final OutputView outputView;

    public StationController() {
        inputView = new InputView();
        outputView = new StationOutputVIew();
    }

    public void run() {
        ProcessUtil.checkError(this::manageStation);
    }

    private void manageStation() {
        outputView.printMenu();
        StationCommand command = StationCommand.convert(inputView.readCommand());

        if (command == StationCommand.ADD) {
            addStation();
            outputView.printRegisterResult();
        }
        if (command == StationCommand.DELETE) {
            deleteStation();
            outputView.printDeleteResult();
        }
        if (command == StationCommand.READ) {
            outputView.printList();
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
