package me.dio.domain.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "tb_empresario")
public class EmpresarioMei {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String cpf;

    @OneToOne(cascade = CascadeType.ALL)
    private EmpresaMei empresa;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Atividades> atividades;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public EmpresaMei getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaMei empresa) {
        this.empresa = empresa;
    }

    public List<Atividades> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<Atividades> atividades) {
        this.atividades = atividades;
    }
}
