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
@Table(name = "hoc_sinh")
public class HocSinh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ho_ten")
    private String hoTen;

    @Column(name = "gioi_tinh")
    private Boolean gioiTinh;

    @Column(name = "dia_chi")
    private String diaChi;

    @ManyToOne
    @JoinColumn(name = "lop_hoc_id",referencedColumnName = "id")
    private LopHoc lopHoc;
}
