package com.learn.banking.services;

import com.learn.banking.models.Chart;
import com.learn.banking.models.User;
import com.learn.banking.repositories.ChartRepository;
import com.learn.banking.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ChartService {

    @Autowired
    private ChartRepository chartRepository;

    public ChartService(ChartRepository chartRepository) {
        this.chartRepository = chartRepository;
    }

    public List<Chart> getAll(){
        return chartRepository.findAll();
    }

    public Chart getById(Long id){
        return chartRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "User Not Found"
                ));
    }

    public Chart findByidBarang(String idBarang){
        return chartRepository.findByidBarang(idBarang);
    }

    public Chart Create(Chart chart){
        if (chart.getId() != null){
            throw new ResponseStatusException(HttpStatus.CONFLICT,String.format("User %s already exist", chart.getId()));
        }

        return chartRepository.save(chart);
    }

    public Chart Update(Long id, Chart chart){
        getById(id);
        chart.setId(id);

        return chartRepository.save(chart);
    }

    public Chart Delete(Long id, Chart chart){
        chart = getById(id);
        chartRepository.deleteById(chart.getId());
        return chart;
    }
}
