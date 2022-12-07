package subway.controller;

import subway.command.LineCommand;
import subway.command.MainCommand;
import subway.command.SectionCommand;
import subway.command.StationCommand;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.Stations;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class SubwayController {

    private static final String[] initStations = {"교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"};

    private final InputView inputView;
    private final OutputView outputView;

    public SubwayController() {
        init();
        inputView = new InputView();
        outputView = new OutputView();
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
        checkError(this::manageMain);
    }

    private void manageMain() {
        boolean isRunnable = true;
        while (isRunnable) {
            outputView.printMainMenu();
            MainCommand command = MainCommand.convert(inputView.readCommand());

            if (command == MainCommand.STATION) {
                checkError(this::manageStation);
            }
            if (command == MainCommand.LINE) {
                checkError(this::manageLine);
            }
            if (command == MainCommand.SECTION) {
                checkError(this::manageSection);
            }
            if (command == MainCommand.PRINT_LINES) {
                outputView.printLines();
                manageMain();
            }
            isRunnable = false;
        }
    }

    private void manageStation() {
        outputView.printStationMenu();
        StationCommand command = StationCommand.convert(inputView.readCommand());

        if (command == StationCommand.ADD) {
            Station station = inputView.readStation();
            StationRepository.addStation(station);
            outputView.printStationRegisterResult();
        }
        if (command == StationCommand.DELETE) {
            Station station = inputView.readDeleteStation();
            StationRepository.deleteStation(station);
            outputView.printStationDeleteResult();
        }
        if (command == StationCommand.READ) {
            outputView.printStations();
        }
        manageMain();
    }

    private void manageLine() {
        outputView.printLineMenu();
        LineCommand command = LineCommand.convert(inputView.readCommand());

        if (command == LineCommand.ADD) {
            String lineName = inputView.readLineName();
            Station upStation = inputView.readUpStation();
            Station downStation = inputView.readDownStation();
            Stations stations = Stations.create(List.of(upStation, downStation));

            Line line = Line.of(lineName, stations);
            LineRepository.addLine(line);
            outputView.printLineRegisterResult();
        }
        if (command == LineCommand.DELETE) {
            String lineName = inputView.readDeleteLineName();
            LineRepository.deleteLineByName(lineName);
            outputView.printLineDeleteResult();
        }
        if (command == LineCommand.READ) {
            outputView.printLineNames();
        }
        manageMain();
    }

    private void manageSection() {
        outputView.printSectionMenu();
        SectionCommand command = SectionCommand.convert(inputView.readCommand());

        if (command == SectionCommand.ADD) {
            String lineName = inputView.readLineNamesForSection();
            String stationName = inputView.readStationForSection();
            int sequence = inputView.readSequence();

            Line line = LineRepository.findByName(lineName);
            Station station = StationRepository.findByName(stationName);
            line.addStation(station, sequence);
            outputView.printSectionRegisterResult();
        }
        if (command == SectionCommand.DELETE) {
            String lineName = inputView.readLineForDeleteSection();
            Line line = LineRepository.findByName(lineName);
            Station station = inputView.readStationForDeleteSection();

            line.remove(station);
            outputView.printSectionDeleteResult();
        }
        manageMain();
    }

    private void checkError(Runnable inputReader) {
        try {
            inputReader.run();
        } catch (IllegalArgumentException error) {
            outputView.printError(error);
            checkError(inputReader);
        }
    }
}
