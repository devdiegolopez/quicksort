package org.acme.domain.data.dto.response;

import java.util.List;

public class ResponseDto {
   List<Integer> list;

    public ResponseDto(List<Integer> list) {
        this.list = list;
    }
    public List<Integer> getList() {
        return list;
    }
    public void setList(List<Integer> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "ResponseDto{" +
                "list=" + list +
                '}';
    }
}