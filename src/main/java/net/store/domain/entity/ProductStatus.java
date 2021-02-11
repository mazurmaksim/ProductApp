package net.store.domain.entity;

public enum ProductStatus {

    OUT_OF_STOCK("out_of_stock"),
    IN_STOCK("in_stock"),
    RUNNING_LOW("running_low");

    private final String status;

    ProductStatus(String status) {
        this.status = status;
    }

    public String getStatus(){
        return status;
    }
}
