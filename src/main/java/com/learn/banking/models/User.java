package com.learn.banking.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.xml.soap.Name;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tbl_barang")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_barang", nullable = false, length = 20, unique = true)
    private String idBarang;

    @Column(name = "nama_barang", nullable = false, length = 50)
    private String nama_barang;

    @Column(name = "deskripsi", nullable = false, length = 100)
    private String deskripsi;

    private Double harga;

}
