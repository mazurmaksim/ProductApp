package net.store.converter.impl;

import net.store.converter.ProductStatusConverter;
import net.store.domain.entity.ProductStatus;

import javax.persistence.Converter;

@Converter(autoApply = true)
public class ProductStatusConverterImpl implements ProductStatusConverter<ProductStatus, String> {

    @Override
    public String convertEnumToString(final ProductStatus productStatus) {
        if(productStatus == null){
            return null;
        }
        return productStatus.getStatus();
    }

    @Override
    public String convertToDatabaseColumn(final ProductStatus productStatus) {
        if(productStatus == null){
            return null;
        }
        return productStatus.getStatus();
    }

    @Override
    public ProductStatus convertToEntityAttribute(final String productStatus) {
        return ProductStatus.valueOf(productStatus);
    }
}
