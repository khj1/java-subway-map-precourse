package subway.controller;

import subway.command.MainCommand;
import subway.domain.Line;
import subway.domain.Station;
import subway.domain.Stations;
import subway.repository.LineRepository;
import subway.repository.StationRepository;
import subway.utils.ProcessUtil;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Arrays;

public class SubwayController {

    private static final String[] initStations = {"교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"};

    private final InputView inputView;
    private final OutputView outputView;
    private final LineController lineController;
    private final StationController stationController;
    private final SectionController sectionController;

    public SubwayController() {
        init();
        inputView = new InputView();
        outputView = new OutputView();
        lineController = new LineController();
        stationController = new StationController();
        sectionController = new SectionController();
    }

    private void init() {
        saveStations();
        saveLines();
    }

    private void saveStations() {
        Arrays.stream(initStations)
                .map(Station::create)
                .forEach(StationRepository::addStation);
    }

    private void saveLines() {
        Arrays.stream(InitLines.values())
                .map(initLines -> Line.of(initLines.getLineName(), Stations.create(initLines.getSections())))
                .forEach(LineRepository::addLine);
    }

    public void run() {
        ProcessUtil.checkError(this::manageMain);
    }

    private void manageMain() {
        boolean isRunnable = true;
        while (isRunnable) {
            outputView.printMainMenu();
            MainCommand command = MainCommand.convert(inputView.readCommand());

            if (command == MainCommand.STATION) {
                stationController.run();
                manageMain();
            }
            if (command == MainCommand.LINE) {
                lineController.run();
                manageMain();
            }
            if (command == MainCommand.SECTION) {
                sectionController.run();
                manageMain();
            }
            if (command == MainCommand.PRINT_LINES) {
                outputView.printLines();
                manageMain();
            }
            isRunnable = false;
        }
    }
}
