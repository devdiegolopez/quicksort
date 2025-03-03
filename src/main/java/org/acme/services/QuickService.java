package org.acme.services;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.domain.data.dto.request.RequestDto;
import org.acme.domain.data.dto.response.ResponseDto;
import org.acme.domain.ports.QuickServicePort;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
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
        String startTime = new SimpleDateFormat("HH:mm:ss.SSS").format(new java.util.Date(System.currentTimeMillis()));
        logger.info(startTime);
        for (int i = 0; i < n; i++) {
            Random r = new Random();
            list.add(r.nextInt(0,1000));
        }
        logger.info(String.valueOf(list));
        quicksort(list, 0, list.size() - 1);
        logger.info(String.valueOf(list));
        String finalTime =new SimpleDateFormat("HH:mm:ss.SSS").format(new java.util.Date(System.currentTimeMillis()));
        logger.info(finalTime);
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
        list.set(i + 1, list.get(high));
        list.set(high, list.get(i + 1));
        return i + 1;
    }
}