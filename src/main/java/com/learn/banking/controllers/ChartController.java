package com.learn.banking.controllers;

import com.learn.banking.models.Chart;
import com.learn.banking.models.User;
import com.learn.banking.services.ChartService;
import com.learn.banking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/chart")
public class ChartController {

    @Autowired
    private ChartService chartService;
    private Chart chart;

    public ChartController(ChartService chartService) {
        this.chartService = chartService;
    }

    @GetMapping
    public ResponseEntity<List<Chart>> getAll(){
        return new ResponseEntity<>(chartService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chart> getById(@PathVariable("id") Long id){
        return new ResponseEntity<>(chartService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/idBarang/{id-barang}")
    public ResponseEntity<Chart> getByidBarang(@PathVariable("id-barang") String idBarang){
        return new ResponseEntity<>(chartService.findByidBarang(idBarang), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Chart> create(@RequestBody Chart chart){
        return new ResponseEntity<>(chartService.Create(chart), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Chart> update(@PathVariable("id") Long id, @RequestBody Chart chart){
        return new ResponseEntity<>(chartService.Update(id, chart), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Chart> delete(@PathVariable("id") Long id){
        return new ResponseEntity<>(chartService.Delete(id, chart), HttpStatus.OK);
    }

}
