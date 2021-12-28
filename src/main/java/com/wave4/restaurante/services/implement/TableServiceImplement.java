package com.wave4.restaurante.services.implement;

import com.wave4.restaurante.RestauranteApplication;
import com.wave4.restaurante.entities.Table;
import com.wave4.restaurante.services.interfaces.CrudInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class TableServiceImplement implements CrudInterface<Table> {


    @Override
    public Table create(Table table) {
        RestauranteApplication.getTables().put(table.getId(), table);
        return table;
    }

    @Override
    public Table edit(Table table) {
        return null;
    }

    @Override
    public void remove(Table table) {

    }

    @Override
    public void remove(Long i) {

    }

    @Override
    public List<Table> findAll() {
        return RestauranteApplication.getTables().values().stream().collect(Collectors.toList());
    }

    @Override
    public Table findById(Long id) {
        return RestauranteApplication.getTables().get(id);
    }

    public List<Table> findByName(String tableName) {
        return RestauranteApplication.getTables().values().stream().filter(table -> table.getName().equals(tableName)).collect(Collectors.toList());
    }


}
