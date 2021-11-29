package com.learn.banking.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tbl_chart")
public class Chart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_barang", nullable = false, length = 20, unique = true)
    private String idBarang;

    @Column(name = "harga_jual", nullable = false, length = 50)
    private String harga_jual;

    @Column(name = "jumlah_barang", nullable = false, length = 100)
    private String jumlah_barang;

    private Double total_bayar;

}
