package org.acme.domain.data.dto.request;

public class RequestDto {
    int n;

    public RequestDto(int n) {
        this.n = n;
    }

    public RequestDto() {
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return "RequestDto{" +
                "n=" + n +
                '}';
    }
}
