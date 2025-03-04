package org.acme.services;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.domain.data.dto.request.RequestDto;
import org.acme.domain.data.dto.response.ResponseDto;
import org.acme.domain.ports.QuickServicePort;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

@ApplicationScoped
public class QuickService implements QuickServicePort {

    @Override
    public ResponseDto quickSorting(RequestDto requestDto) {

        int n = requestDto.getN();
        List<Integer> list = new ArrayList<>();
        Logger logger = Logger.getLogger(QuickService.class.getName());
        for (int i = 0; i < n; i++) {
            Random r = new Random();
            list.add(r.nextInt(0,n));
        }
        long startTime = System.nanoTime();
        logger.info(String.valueOf(startTime));
        logger.info(String.valueOf(list));
        quicksort(list, 0, list.size() - 1);
        long endTime = System.nanoTime();
        long finalTime = endTime - startTime;
        logger.info(String.valueOf(finalTime));
        logger.info(String.valueOf(list));
        logger.info("Execution time in seconds: " + finalTime / 1_000_000_000.0);
            return new ResponseDto(list);
    }

    private void quicksort(List<Integer> list, int low, int high) {
        if (low < high) {
            int p = partition(list, low, high);
            quicksort(list, low, p - 1);
            quicksort(list, p + 1, high);
        }
    }
    private int partition(List<Integer> list, int low, int high) {
        int pivot = list.get(high), i = low - 1;
        for (int j = low; j < high; j++) {
            if (list.get(j) < pivot) {
                i++;
                int temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }
        int temp = list.get(i + 1);
        list.set(i + 1, list.get(high));
        list.set(high, temp);
        return i + 1;
    }
}