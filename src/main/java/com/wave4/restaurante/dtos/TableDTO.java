package com.wave4.restaurante.dtos;

import com.wave4.restaurante.dtos.interfaces.ConverterInterface;
import com.wave4.restaurante.entities.Table;
import com.wave4.restaurante.utils.DateUtils;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TableDTO implements ConverterInterface<Table, TableDTO> {

    private Long id;
    private String name;
    private Double totalConsumed;

    @Override
    public Table convert() {
        if (this.id != null) {
            return new Table(id, this.name, this.totalConsumed);
        } else {
            return new Table(DateUtils.getCurrentTimeMillis(), this.name, this.totalConsumed);
        }
    }

    @Override
    public TableDTO convert(Table table) {
        this.id = table.getId();
        this.name = table.getName();
        this.totalConsumed = table.getTotalConsumed();
        return null;
    }
}
