package br.com.caelum.casadocodigo.modelo;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

import java.io.Serializable;

@SuppressWarnings("serial")
@Entity
public class Cartao implements Serializable {

    @Id
    private Long id;
    @NotNull
    private String nomeCompleto;
    @NotNull
    private Long numero;
    private Integer cvv;
    private String validade;
    @Generated(hash = 115823341)
    public Cartao(Long id, @NotNull String nomeCompleto, @NotNull Long numero,
            Integer cvv, String validade) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.numero = numero;
        this.cvv = cvv;
        this.validade = validade;
    }
    @Generated(hash = 1431601988)
    public Cartao() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNomeCompleto() {
        return this.nomeCompleto;
    }
    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }
    public Long getNumero() {
        return this.numero;
    }
    public void setNumero(Long numero) {
        this.numero = numero;
    }
    public Integer getCvv() {
        return this.cvv;
    }
    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }
    public String getValidade() {
        return this.validade;
    }
    public void setValidade(String validade) {
        this.validade = validade;
    }

    
}
