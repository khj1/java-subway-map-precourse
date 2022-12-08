package subway.utils;

import subway.view.ouput.OutputView;

public class ProcessUtil {

    public static void checkError(Runnable inputReader) {
        try {
            inputReader.run();
        } catch (IllegalArgumentException error) {
            OutputView.printError(error);
            checkError(inputReader);
        }
    }
}
