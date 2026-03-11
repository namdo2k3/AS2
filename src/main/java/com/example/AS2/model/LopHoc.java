package com.example.AS2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "lop_hoc")
public class LopHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten_lop")
    private String tenLop;

    @Column(name = "khoi")
    private Integer khoi;

    @Column(name = "si_so")
    private Integer siSo;
}
