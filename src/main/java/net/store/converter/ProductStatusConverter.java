package net.store.converter;

import net.store.domain.entity.ProductStatus;

import javax.persistence.AttributeConverter;

public interface ProductStatusConverter<P, S> extends AttributeConverter<ProductStatus, String> {

    public String convertEnumToString(final ProductStatus productStatus);
    public String convertToDatabaseColumn(final ProductStatus attribute);
}
